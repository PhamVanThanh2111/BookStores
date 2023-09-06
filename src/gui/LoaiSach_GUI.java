package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class LoaiSach_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoaiSach_GUI() {
		setLayout(null);

		JPanel mMain = new JPanel();
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 1021, 42);
		mMain.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblQunLLoi = new JLabel("QUẢN LÝ LOẠI SÁCH");
		lblQunLLoi.setBounds(421, 10, 240, 22);
		lblQunLLoi.setForeground(Color.RED);
		lblQunLLoi.setFont(new Font("Arial", Font.BOLD, 20));
		pnTieuDe.add(lblQunLLoi);

		JPanel pnCenN = new JPanel();
		// pnCenN.setBorder(new TitledBorder(null, "Thông Tin: ", TitledBorder.LEADING,
		// TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnCenN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,0)), "Thông Tin:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnCenN.setBounds(10, 62, 1028, 106);
		mMain.add(pnCenN);
		pnCenN.setLayout(null);

		Box b = Box.createVerticalBox();
		b.setBounds(73, 10, 897, 74);
		b.setPreferredSize(new Dimension(840, 70));
		pnCenN.add(b);

		Component verticalStrut = Box.createVerticalStrut(30);
		b.add(verticalStrut);

		Box b1 = Box.createHorizontalBox();
		b.add(b1);

		JLabel lblMLoiSch = new JLabel("Mã Loại Sách: ");
		lblMLoiSch.setPreferredSize(new Dimension(86, 13));
		b1.add(lblMLoiSch);

		textField = new JTextField();
		textField.setEditable(false);
		b1.add(textField);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		b1.add(horizontalStrut);

		JLabel lblTnLoiSch = new JLabel("Tên Loại Sách:    ");
		b1.add(lblTnLoiSch);

		textField_1 = new JTextField();
		b1.add(textField_1);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		b.add(verticalStrut_1);

		JPanel pnCenS = new JPanel();
		pnCenS.setBounds(10, 167, 1028, 54);
		pnCenS.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0 )), "Chức Năng:", //162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 126, 197)));
		mMain.add(pnCenS);
		pnCenS.setLayout(null);

		JButton btnThem = new JButton("Thêm Loại Sách");
		btnThem.setBounds(145, 10, 127, 34);
		pnCenS.add(btnThem);

		JButton btnXoa = new JButton("Xóa Loại Sách");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(320, 10, 133, 34);
		pnCenS.add(btnXoa);

		JButton btnSua = new JButton("Sửa Thông Tin");
		btnSua.setBounds(498, 10, 121, 34);
		pnCenS.add(btnSua);

		JButton btnIn = new JButton("In Thông Tin");
		btnIn.setBounds(664, 10, 127, 34);
		pnCenS.add(btnIn);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(827, 10, 80, 34);
		pnCenS.add(btnThoat);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(269, 20, 53, 12);
		pnCenS.add(horizontalStrut_1);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1.setBounds(454, 20, 45, 12);
		pnCenS.add(horizontalStrut_1_1);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2.setBounds(617, 20, 45, 12);
		pnCenS.add(horizontalStrut_1_2);

		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		horizontalStrut_1_3.setBounds(792, 20, 38, 12);
		pnCenS.add(horizontalStrut_1_3);

		JPanel pnSouth_2 = new JPanel();
		pnSouth_2.setBounds(10, 231, 1028, 357);
		pnSouth_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0 )), "Danh sách:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pnSouth_2);
		pnSouth_2.setLayout(null);

		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(38, 22, 980, 314);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		pnSouth_2.add(scrollPaneSach);

		Component verticalStrut_1_1 = Box.createVerticalStrut(10);
		verticalStrut_1_1.setBounds(10, 217, 1034, 17);
		mMain.add(verticalStrut_1_1);

	}
}
