package gui;
//
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//import java.awt.Color;
//import java.awt.Font;
//
//public class Sach_GUI extends JPanel {
//
//	/**
//	 * Create the panel.
//	 */
//	public Sach_GUI() {
//		setLayout(null);
//		// pnNorth
//		JPanel JPanel = new JPanel();
//		JPanel.setBounds(10, 10, 1256, 553);
//		add(JPanel);
//		JPanel.setLayout(null);
//		
//		JPanel pnTieuDe = new JPanel();
//		pnTieuDe.setBounds(4, 0, 880, 97);
//		JPanel.add(pnTieuDe);
//		pnTieuDe.setLayout(null);
//		
//		JPanel pNorth = new JPanel();
//		pNorth.setBounds(-4, -12, 894, 99);
//		pnTieuDe.add(pNorth);
//		pNorth.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("QUẢN LÝ SÁCH");
//		lblNewLabel.setBounds(33, 10, 815, 29);
//		pNorth.add(lblNewLabel);
//		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
//		lblNewLabel.setForeground(Color.RED);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		// pnCenter
//		
//		
//		
//		
//		// pnSouth
//
//	}
//}
import javax.swing.*;

import entity.Sach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sach_GUI extends Sach {
    private JFrame frame;
    private JLabel labelMaSach, labelMaNXB, labelMaLoaiSach, labelTenSach, labelXuatXu, labelGia;
    private JTextField textFieldMaSach, textFieldMaNXB, textFieldMaLoaiSach, textFieldTenSach, textFieldXuatXu, textFieldGia;
    private JButton buttonSubmit;

    public Sach_GUI() {
        frame = new JFrame("Quản lý sách");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(539, 384);
        frame.getContentPane().setLayout(new GridLayout(7, 2));

        labelMaSach = new JLabel("Mã sách:");
        textFieldMaSach = new JTextField();
        frame.getContentPane().add(labelMaSach);
        frame.getContentPane().add(textFieldMaSach);

        labelMaNXB = new JLabel("Mã NXB:");
        textFieldMaNXB = new JTextField();
        frame.getContentPane().add(labelMaNXB);
        frame.getContentPane().add(textFieldMaNXB);

        labelMaLoaiSach = new JLabel("Mã loại sách:");
        textFieldMaLoaiSach = new JTextField();
        frame.getContentPane().add(labelMaLoaiSach);
        frame.getContentPane().add(textFieldMaLoaiSach);

        labelTenSach = new JLabel("Tên sách:");
        textFieldTenSach = new JTextField();
        frame.getContentPane().add(labelTenSach);
        frame.getContentPane().add(textFieldTenSach);

        labelXuatXu = new JLabel("Xuất xứ:");
        textFieldXuatXu = new JTextField();
        frame.getContentPane().add(labelXuatXu);
        frame.getContentPane().add(textFieldXuatXu);

        labelGia = new JLabel("Giá:");
        textFieldGia = new JTextField();
        frame.getContentPane().add(labelGia);
        frame.getContentPane().add(textFieldGia);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSach = textFieldMaSach.getText();
                String maNXB = textFieldMaNXB.getText();
                String maLoaiSach = textFieldMaLoaiSach.getText();
                String tenSach = textFieldTenSach.getText();
                String xuatXu = textFieldXuatXu.getText();
                double gia = Double.parseDouble(textFieldGia.getText());

                // Thực hiện các thao tác lưu thông tin sách vào cơ sở dữ liệu hoặc xử lý theo yêu cầu

                JOptionPane.showMessageDialog(frame, "Thông tin sách đã được lưu thành công!");
            }
        });
        frame.getContentPane().add(buttonSubmit);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Sach_GUI sachGUI = new Sach_GUI();
    }
}
