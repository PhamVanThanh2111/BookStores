package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_DAO;
import dao.NhaXuatBan_DAO;
import dao.SanPham_DAO;
import dao.TheLoaiSach_DAO;
import entity.SanPham;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhoiPhucSach_GUI extends JInternalFrame {
	private DefaultTableModel model;
	
	private JPanel pMain;
	
	private SanPham_DAO sanPham_DAO;
	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private TheLoaiSach_DAO theLoaiSach_DAO;
	
	private JScrollPane scrollPaneSach;
	
	private JButton btnKhoiPhuc;
	private JButton btnXoa ;
	private JButton btnquayLai;
	
	private JTable table;
	
	private ArrayList<SanPham> ds;
	

	/**
	 * Create the frame.
	 */
	public KhoiPhucSach_GUI(ArrayList<SanPham> ds ) {
		this.ds = ds;
		sanPham_DAO = new SanPham_DAO();
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		
		setBounds(100, 100, 1199, 506);
		getContentPane().setLayout(null);
		
		pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(10, 10, 1152, 465);
		
		getContentPane().add(pMain);
		
		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneSach.setBackground(new Color(80, 80, 80));
		scrollPaneSach.setBounds(20, 0, 1132, 374);
		
		String cols[] = { "Mã Sách", "Tên Sách", "Xuất Xứ", "Giá Nhập", "Giá Bán", "Số Lượng Tồn", "Nhà Xuất Bản",
				"Thể Loại Sách", "Tác Giả", "Số Trang", "Năm Xuất Bản" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào sách cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		scrollPaneSach.setViewportView(table);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		
		pMain.add(scrollPaneSach);
		
		btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setOpaque(true);
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhoiPhuc.setBackground(new Color(73, 129, 158));
		btnKhoiPhuc.setBounds(507, 399, 135, 40);
		btnKhoiPhuc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				SanPham sanpham = new SanPham();
				sanpham.setMaSanPham((String) model.getValueAt(row, 0));
				try {
					sanPham_DAO.khoiPhucSanPham(sanpham);

					loadData(sanPham_DAO.getAllSachXoa());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		pMain.add(btnKhoiPhuc);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(828, 399, 135, 40);
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sản Phẩm !");
				} else {
					int tb = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Sản Phẩm? ", "Delete",
							JOptionPane.YES_NO_OPTION);
					if (tb == JOptionPane.YES_OPTION) {
						try {
							sanPham_DAO.xoaSachTheoMa((String) model.getValueAt(row, 0));
							loadData(sanPham_DAO.getAllSachXoa());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}

			}
		});
		pMain.add(btnXoa);
		
		btnquayLai = new JButton("← Quay Lại");
		btnquayLai.setForeground(Color.WHITE);
		btnquayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnquayLai.setBackground(new Color(73, 129, 158));
		btnquayLai.setBounds(186, 399, 135, 40);
		btnquayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadALL();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		pMain.add(btnquayLai);
		loadData(sanPham_DAO.getAllSachXoa());
		
	}
	
	// load Data lên bảng
		public void loadData(ArrayList<SanPham> ds) {
			model.setRowCount(0);
			for (SanPham sanPham : ds) {
				Object[] object = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
						sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuongTon(),
						nhaXuatBan_DAO.getnhaXuatBanTheoMa(sanPham.getMaNXB()).getTenNhaXuatBan(),
						theLoaiSach_DAO.getTheLoaiSachTheoMa(sanPham.getMaTheLoaiSach()).gettenTheLoaiSach(),
						sanPham.getTacGia(), sanPham.getSoTrang(), sanPham.getNamXuatBan(), };
				model.addRow(object);
			}
		}
	private void loadALL() {
		model.setRowCount(0);
		for (SanPham sanPham : sanPham_DAO.getAllSach()) {
			ds.add(sanPham);
		}
	}
}
