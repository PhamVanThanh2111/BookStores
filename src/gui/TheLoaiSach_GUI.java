package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.TheLoaiSach_DAO;
import entity.TheLoaiSach;
public class TheLoaiSach_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmaTheLoaiSach;
	private JTextField textField_1;
	private JTable table;
	private JTableHeader tableHeader;
	private DefaultTableModel model;
	private TheLoaiSach_DAO theLoaiSach_DAO;
	/**
	 * Create the panel.
	 */
	public TheLoaiSach_GUI() {
		
		// khai bao DAO
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 300);
		pMain.add(pThongTin);
		
		JLabel lblThngTinTh = new JLabel("Thông Tin Thể Loại Sách");
		lblThngTinTh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngTinTh.setBounds(20, 15, 300, 40);
		pThongTin.add(lblThngTinTh);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(145, 200, 135, 40);
		pThongTin.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(432, 200, 135, 40);
		pThongTin.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(719, 200, 135, 40);
		pThongTin.add(btnUpdate);
		
		JButton btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1006, 200, 135, 40);
		pThongTin.add(btnlamMoi);
		
		JLabel lblmaTheLoaiSach = new JLabel("Mã Thể Loại Sách:");
		lblmaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaTheLoaiSach.setBounds(50, 100, 150, 40);
		pThongTin.add(lblmaTheLoaiSach);
		
		JLabel lbltenTheLoaiSach = new JLabel("Tên Thể Loại Sách:");
		lbltenTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenTheLoaiSach.setBounds(680, 100, 175, 40);
		pThongTin.add(lbltenTheLoaiSach);
		
		txtmaTheLoaiSach = new JTextField();
		txtmaTheLoaiSach.setToolTipText("Mã Sách");
		txtmaTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaTheLoaiSach.setEditable(false);
		txtmaTheLoaiSach.setColumns(10);
		txtmaTheLoaiSach.setBackground(Color.WHITE);
		txtmaTheLoaiSach.setBounds(220, 100, 400, 40);
		pThongTin.add(txtmaTheLoaiSach);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Mã Sách");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(850, 100, 400, 40);
		pThongTin.add(textField_1);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 362, 1300, 348);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);
		
		JScrollPane scrollPaneTheLoaiSach = new JScrollPane();
		scrollPaneTheLoaiSach.setToolTipText("Chọn vào thể loại Sách cần hiển thị thông tin");
		scrollPaneTheLoaiSach.setBorder(null);
		scrollPaneTheLoaiSach.setBackground(Color.WHITE);
		scrollPaneTheLoaiSach.setBounds(20, 44, 1259, 285);
		pDanhSach.add(scrollPaneTheLoaiSach);
		
		String cols[] = { "Mã Thể Loại Sách","Tên Thể Loại Sách"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào thể loại sách cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true); 
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		scrollPaneTheLoaiSach.setViewportView(table);
		
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JLabel lblChiTitTh = new JLabel("Chi Tiết Thể Loại Sách");
		lblChiTitTh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitTh.setBounds(22, 10, 291, 40);
		pDanhSach.add(lblChiTitTh);
		loadData();
	}
	public void loadData() {
	    // Xóa dữ liệu cũ trước khi nạp dữ liệu mới
	    model.setRowCount(0);
	    // Nạp dữ liệu sản phẩm lên bảng
		for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
			Object[] object = { theLoaiSach.getMaLoaiSach(),theLoaiSach.getTenLoaiSach() };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}
	public void refresh() {
		loadData();
	}

}
