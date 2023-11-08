package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TheLoaiSach_DAO;
import entity.TheLoaiSach;

public class TimKiemTheLoaiSach_GUI extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaTheLoaiSach;
	private JTextField txtTenTheLoaiSach;
	
	private TheLoaiSach_DAO theLoaiSach_DAO;
	private ArrayList<TheLoaiSach> ds;


	/**
	 * Create the frame.
	 */

	public TimKiemTheLoaiSach_GUI(ArrayList<TheLoaiSach> ds) {

		// khai bao DAO
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		this.ds = ds;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 330);
		getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 853, 405);
		getContentPane().add(contentPane);

		JLabel lblMaTheLoaiSach = new JLabel("Mã Thể loại sách:");
		lblMaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaTheLoaiSach.setBounds(132, 87, 217, 40);
		contentPane.add(lblMaTheLoaiSach);

		JLabel lblEmail = new JLabel("Tên thể loại sách:");
		lblEmail.setToolTipText("Tên của thể loại sách cần tìm");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(132, 145, 160, 40);
		contentPane.add(lblEmail);

		txtTenTheLoaiSach = new JTextField();
		txtTenTheLoaiSach.setToolTipText("Nhập vào tên của thể loại sách cần tìm");
		txtTenTheLoaiSach.setColumns(10);
		txtTenTheLoaiSach.setBounds(309, 145, 390, 40);
		contentPane.add(txtTenTheLoaiSach);

		txtMaTheLoaiSach = new JTextField();
		txtMaTheLoaiSach.setToolTipText("Nhập vào mã thể loại sách cần tìm");
		txtMaTheLoaiSach.setColumns(10);
		txtMaTheLoaiSach.setBounds(309, 91, 390, 40);
		contentPane.add(txtMaTheLoaiSach);

		JButton btnQuayLai = new JButton("← Quay Lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnQuayLai.setBackground(new Color(73, 129, 158));
		btnQuayLai.setBounds(10, 10, 135, 40);
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadAll();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.add(btnQuayLai);
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(364, 199, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! kiemTraDuLieuRong()) {
					searchTheLoaiSach();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		contentPane.add(btnTim);
	}
	private void searchTheLoaiSach() {
		// TODO Auto-generated method stub
		for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
			boolean thoaMan = false;
			if (!txtMaTheLoaiSach.getText().isEmpty()) {
				if (theLoaiSach.getmaTheLoaiSach().equalsIgnoreCase(txtMaTheLoaiSach.getText())) {
					thoaMan = true;
				}
			}
			if (!txtTenTheLoaiSach.getText().isEmpty()) {
				if (theLoaiSach.gettenTheLoaiSach().toLowerCase()
						.contains(txtTenTheLoaiSach.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (thoaMan) {
				ds.add(theLoaiSach);
			}
		}
	}

	 private boolean kiemTraDuLieuRong() {
	        if (txtMaTheLoaiSach.getText().isEmpty() && txtTenTheLoaiSach.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Bạn phải điền ít nhất một thông tin!");
	            return true;
	        }
	        return false;
	    }
    private void loadAll() {
        if (theLoaiSach_DAO.getAllListTheLoaiSach() != null) {
            for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
                ds.add(theLoaiSach);
            }
        }
    }
    @SuppressWarnings("unused")
	private void dongCuaSoNoiTai() {
        try {
            setClosed(true);
        } catch (PropertyVetoException e1) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đóng cửa sổ nội tại: " + e1.getMessage());
        }
    }

}
