package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaCungCap_DAO;
import dao.SanPham_DAO;
import entity.SanPham;

import javax.swing.JButton;

public class KhoiPhucDungCuHocTap_GUI extends JInternalFrame {
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private JButton btnXoa, btnKhoiPhuc;
	private SanPham_DAO sanPham_DAO;
	private ArrayList<SanPham> ds;
	private NhaCungCap_DAO nhaCungCap_DAO;
	private JButton btnquayLai;

	/**
	 * Launch the application.
	 */

	public KhoiPhucDungCuHocTap_GUI(ArrayList<SanPham> ds) {
		this.ds = ds;
		sanPham_DAO = new SanPham_DAO();
		nhaCungCap_DAO = new NhaCungCap_DAO();
		setBounds(100, 100, 882, 495);
		getContentPane().setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 870, 465);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setToolTipText("Chọn vào nhà xuất bản cần hiển thị thông tin");
		scrollPaneNXB.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNXB.setBackground(new Color(80, 80, 80));
		scrollPaneNXB.setBounds(20, 0, 830, 374);

		String[] cols = { "Mã Dụng Cụ Học Tập", "Tên Dụng Cụ Học Tập", "Xuất Xứ", "Giá Nhập", "Giá Bán", "Số Lượng Tồn",
				"Nhà Cung Cấp" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);

		table.setRowHeight(25);
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setDefaultEditor(Object.class, null);
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneNXB.setViewportView(table);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

		pMain.add(scrollPaneNXB);

		btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setOpaque(true);
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhoiPhuc.setBackground(new Color(73, 129, 158));
		btnKhoiPhuc.setBounds(562, 399, 135, 40);
		btnKhoiPhuc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				SanPham sanpham = new SanPham();
				sanpham.setMaSanPham((String) model.getValueAt(row, 0));
				try {
					sanPham_DAO.khoiPhucSanPham(sanpham);

					loadData(sanPham_DAO.getAllDCHTXoa());
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
		btnXoa.setBounds(715, 399, 135, 40);
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
							loadData(sanPham_DAO.getAllDCHTXoa());
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
		btnquayLai.setBounds(409, 399, 135, 40);
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

		loadData(sanPham_DAO.getAllDCHTXoa());
	}

	private void loadData(ArrayList<SanPham> ds) {
		model.setRowCount(0);
		for (SanPham sanPham : ds) {
			Object[] o = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(), sanPham.getGiaNhap(),
					sanPham.getGiaBan(), sanPham.getSoLuongTon(),
					nhaCungCap_DAO.getNhaCCTheoMa(sanPham.getMaNhaCungCap()).getTenNCC() };
			model.addRow(o);
		}
	}

	private void loadALL() {
		model.setRowCount(0);
		for (SanPham sanPham : sanPham_DAO.getAllDungCuHocTap()) {
			ds.add(sanPham);
		}
	}
}
