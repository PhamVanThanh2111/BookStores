package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DungCuHocTap_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtsoLuong;
	private JTextField txtgiaBan;
	private JTextField txtgiaNhap;

	/**
	 * Create the panel.
	 */
	public DungCuHocTap_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 320);
		pMain.add(pThongTin);
		
		JLabel lblthongTinDCHT = new JLabel("Thông Tin Dụng Cụ Học Tập");
		lblthongTinDCHT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinDCHT.setBounds(20, 15, 260, 40);
		pThongTin.add(lblthongTinDCHT);
		
		JLabel lblmaDCHT = new JLabel("Mã DCHT:");
		lblmaDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaDCHT.setBounds(40, 70, 90, 40);
		pThongTin.add(lblmaDCHT);
		
		JLabel lbltenDCHT = new JLabel("Tên DCHT:");
		lbltenDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenDCHT.setBounds(40, 115, 90, 40);
		pThongTin.add(lbltenDCHT);
		
		JLabel lblnhaCC = new JLabel("Nhà CC:");
		lblnhaCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaCC.setBounds(40, 160, 90, 40);
		pThongTin.add(lblnhaCC);
		
		textField = new JTextField();
		textField.setToolTipText("Mã Sách");
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(145, 70, 255, 40);
		pThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Tên Sách");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(145, 115, 255, 40);
		pThongTin.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Xuất xứ");
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(145, 162, 255, 40);
		pThongTin.add(textField_2);
		
		JLabel lblgia = new JLabel("Giá Nhập:");
		lblgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgia.setBounds(450, 70, 130, 40);
		pThongTin.add(lblgia);
		
		JLabel lblnhaXuatBan = new JLabel("Giá Bán:");
		lblnhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan.setBounds(450, 115, 130, 40);
		pThongTin.add(lblnhaXuatBan);
		
		JLabel lblgiaNhap = new JLabel("Số Lượng:");
		lblgiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap.setBounds(450, 160, 130, 40);
		pThongTin.add(lblgiaNhap);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setToolTipText("Giá nhập");
		txtsoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoLuong.setEditable(false);
		txtsoLuong.setColumns(10);
		txtsoLuong.setBackground(Color.WHITE);
		txtsoLuong.setBounds(600, 162, 255, 40);
		pThongTin.add(txtsoLuong);
		
		JLabel lblanh = new JLabel("Ảnh DCHT:");
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblanh.setBounds(880, 70, 121, 40);
		pThongTin.add(lblanh);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(145, 250, 135, 40);
		pThongTin.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(432, 250, 135, 40);
		pThongTin.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(719, 250, 135, 40);
		pThongTin.add(btnUpdate);
		
		JButton btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1006, 250, 135, 40);
		pThongTin.add(btnlamMoi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(1089, 174, 90, 19);
		pThongTin.add(btnChonHinhAnh);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(983, 25, 289, 180);
		pThongTin.add(lblHinhAnh);
		
		txtgiaBan = new JTextField();
		txtgiaBan.setToolTipText("Giá nhập");
		txtgiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaBan.setEditable(false);
		txtgiaBan.setColumns(10);
		txtgiaBan.setBackground(Color.WHITE);
		txtgiaBan.setBounds(600, 115, 255, 40);
		pThongTin.add(txtgiaBan);
		
		txtgiaNhap = new JTextField();
		txtgiaNhap.setToolTipText("Giá nhập");
		txtgiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaNhap.setEditable(false);
		txtgiaNhap.setColumns(10);
		txtgiaNhap.setBackground(Color.WHITE);
		txtgiaNhap.setBounds(600, 70, 255, 40);
		pThongTin.add(txtgiaNhap);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 330, 1300, 380);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setToolTipText("Chọn vào Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(Color.WHITE);
		scrollPaneSach.setBounds(20, 51, 1259, 319);
		pDanhSach.add(scrollPaneSach);
		
		JLabel lblChiTitDng = new JLabel("Chi Tiết Dụng Cụ Học Tập");
		lblChiTitDng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitDng.setBounds(20, 15, 246, 40);
		pDanhSach.add(lblChiTitDng);

	}
}
