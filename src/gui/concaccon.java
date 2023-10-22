package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class concaccon extends JPanel {

	/**
	 * Create the panel.
	 */
	public concaccon() {
		setLayout(null);
		
		JPanel pChiTiet = new JPanel();
		pChiTiet.setLayout(null);
		pChiTiet.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pChiTiet.setBackground(Color.WHITE);
		pChiTiet.setBounds(10, 10, 780, 385);
		add(pChiTiet);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(20, 70, 740, 8);
		pChiTiet.add(separator);
		
		JLabel lblchiTiet = new JLabel("Chi Tiết");
		lblchiTiet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblchiTiet.setBounds(20, 15, 200, 40);
		pChiTiet.add(lblchiTiet);
		
		JLabel lblmaSach_1 = new JLabel("Mã Sách:");
		lblmaSach_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaSach_1.setBounds(220, 85, 90, 40);
		pChiTiet.add(lblmaSach_1);
		
		JLabel lbltenSach_1 = new JLabel("Tên Sách:");
		lbltenSach_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenSach_1.setBounds(220, 130, 90, 40);
		pChiTiet.add(lbltenSach_1);
		
		JLabel lblxuatXu_1 = new JLabel("Xuất Xứ:");
		lblxuatXu_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblxuatXu_1.setBounds(220, 175, 90, 40);
		pChiTiet.add(lblxuatXu_1);
		
		JLabel lblnhaXuatBan_1 = new JLabel("Nhà Xuất Bản:");
		lblnhaXuatBan_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan_1.setBounds(510, 85, 118, 40);
		pChiTiet.add(lblnhaXuatBan_1);
		
		JLabel lblgiaNhap_1 = new JLabel("Giá Nhập:");
		lblgiaNhap_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap_1.setBounds(510, 220, 90, 40);
		pChiTiet.add(lblgiaNhap_1);
		
		JLabel lblloaiSach_1 = new JLabel("Loại Sách:");
		lblloaiSach_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblloaiSach_1.setBounds(510, 130, 90, 40);
		pChiTiet.add(lblloaiSach_1);
		
		JLabel lbltacGia_1 = new JLabel("Tác Giả:");
		lbltacGia_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltacGia_1.setBounds(220, 220, 90, 40);
		pChiTiet.add(lbltacGia_1);
		
		JLabel lblsoLuong_1 = new JLabel("Số Lượng:");
		lblsoLuong_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsoLuong_1.setBounds(220, 265, 90, 40);
		pChiTiet.add(lblsoLuong_1);
		
		JLabel lblsoTrang_1 = new JLabel("Số Trang:");
		lblsoTrang_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsoTrang_1.setBounds(510, 175, 90, 40);
		pChiTiet.add(lblsoTrang_1);
		
		JLabel lblgiaBan_1 = new JLabel("Giá Bán:");
		lblgiaBan_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaBan_1.setBounds(510, 265, 90, 40);
		pChiTiet.add(lblgiaBan_1);
		
		JLabel lblmaSach_1_1 = new JLabel("S0001");
		lblmaSach_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaSach_1_1.setBounds(320, 85, 170, 40);
		pChiTiet.add(lblmaSach_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 85, 180, 210);
		pChiTiet.add(panel);
		
		JLabel lbltenSach_1_1_1 = new JLabel("Trên Đường Băng ");
		lbltenSach_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lbltenSach_1_1_1.setBounds(320, 130, 170, 40);
		pChiTiet.add(lbltenSach_1_1_1);
		
		JLabel lblxuatXu_1_1_2 = new JLabel("Việt nam ");
		lblxuatXu_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblxuatXu_1_1_2.setBounds(320, 175, 170, 40);
		pChiTiet.add(lblxuatXu_1_1_2);
		
		JLabel lbltacGia_1_1_3 = new JLabel("Tony Buổi Sáng");
		lbltacGia_1_1_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lbltacGia_1_1_3.setBounds(320, 220, 170, 40);
		pChiTiet.add(lbltacGia_1_1_3);
		
		JLabel lblsoLuong_1_1_4 = new JLabel("80 ");
		lblsoLuong_1_1_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblsoLuong_1_1_4.setBounds(320, 265, 170, 40);
		pChiTiet.add(lblsoLuong_1_1_4);
		
		JLabel lblnhaXuatBan_1_1 = new JLabel("Trẻ");
		lblnhaXuatBan_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblnhaXuatBan_1_1.setBounds(632, 85, 170, 40);
		pChiTiet.add(lblnhaXuatBan_1_1);
		
		JLabel lblloaiSach_1_1 = new JLabel("Selfhelp ");
		lblloaiSach_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblloaiSach_1_1.setBounds(632, 131, 170, 40);
		pChiTiet.add(lblloaiSach_1_1);
		
		JLabel lblsoTrang_1_1 = new JLabel("308");
		lblsoTrang_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblsoTrang_1_1.setBounds(632, 175, 170, 40);
		pChiTiet.add(lblsoTrang_1_1);
		
		JLabel lblgiaNhap_1_1 = new JLabel("50.000 VNĐ");
		lblgiaNhap_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblgiaNhap_1_1.setBounds(632, 220, 170, 40);
		pChiTiet.add(lblgiaNhap_1_1);
		
		JLabel lblgiaBan_1_1 = new JLabel("70.000 VNĐ");
		lblgiaBan_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblgiaBan_1_1.setBounds(632, 265, 170, 40);
		pChiTiet.add(lblgiaBan_1_1);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(321, 320, 135, 40);
		pChiTiet.add(btnDelete);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(93, 315, 135, 40);
		pChiTiet.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(549, 320, 135, 40);
		pChiTiet.add(btnUpdate);

	}

}
