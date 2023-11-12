package gui;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhaXuatBan_DAO;
import dao.SanPham_DAO;
import dao.TheLoaiSach_DAO;
import entity.NhaXuatBan;
import entity.SanPham;
import entity.TheLoaiSach;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TimKiemSach_GUI extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtXuatXu;
	private JTextField txtNamXuatBan;
	private JTextField txtGiaNhap;
	private JTextField txtTacGia;
	private JTextField txtGiaBan;
	private JTextField txtSoTrang;
	private JTextField txtSoLuong;

	private JComboBox<String> cmbTheLoaiSach;
	private JComboBox<String> cmbNhaXuatBan;
	private ArrayList<SanPham> ds;

	private SanPham_DAO sanPham_DAO;
	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private TheLoaiSach_DAO theLoaiSach_DAO;

	private JButton btnTim;
	private JButton btnquayLai;

	/**
	 * Create the frame.
	 */
	public TimKiemSach_GUI(ArrayList<SanPham> ds) {

		// khai bao DAO
		sanPham_DAO = new SanPham_DAO();
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();

		this.ds = ds;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1242, 481);
		getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1231, 523);
		getContentPane().add(contentPane);

		JLabel lblMaSach = new JLabel("Mã Sách:");
		lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaSach.setBounds(20, 87, 127, 40);
		contentPane.add(lblMaSach);

		JLabel lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(20, 167, 127, 40);
		contentPane.add(lblTenSach);

		JLabel lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXuatXu.setBounds(20, 248, 127, 40);
		contentPane.add(lblXuatXu);

		JLabel lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTacGia.setBounds(20, 330, 127, 40);
		contentPane.add(lblTacGia);

		JLabel lblNamXuatBan = new JLabel("Năm Xuất Bản:");
		lblNamXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNamXuatBan.setBounds(819, 248, 127, 40);
		contentPane.add(lblNamXuatBan);

		JLabel lblCccd = new JLabel("Loại Sách:");
		lblCccd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCccd.setBounds(410, 87, 127, 40);
		contentPane.add(lblCccd);

		JLabel lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(410, 167, 127, 40);
		contentPane.add(lblNhaXuatBan);

		JLabel lblGiaNhap = new JLabel("Giá Nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaNhap.setBounds(410, 244, 127, 40);
		contentPane.add(lblGiaNhap);

		JLabel lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(410, 330, 127, 40);
		contentPane.add(lblGiaBan);

		JLabel lblSoTrang = new JLabel("Số Trang:");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setBounds(819, 90, 127, 40);
		contentPane.add(lblSoTrang);

		txtMaSach = new JTextField();
		txtMaSach.setToolTipText("điền mã sách cần tìm ");
		txtMaSach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(133, 87, 238, 40);
		contentPane.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setToolTipText("điền tên sách cần tìm vào");
		txtTenSach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(133, 167, 238, 40);
		contentPane.add(txtTenSach);

		txtXuatXu = new JTextField();
		txtXuatXu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(133, 248, 238, 40);
		contentPane.add(txtXuatXu);

		txtNamXuatBan = new JTextField();
		txtNamXuatBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtNamXuatBan.setColumns(10);
		txtNamXuatBan.setBounds(967, 248, 238, 40);
		contentPane.add(txtNamXuatBan);

		txtGiaNhap = new JTextField();
		txtGiaNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(547, 248, 238, 40);
		contentPane.add(txtGiaNhap);

		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (duLieuRong()) {
					searchSach();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1070, 371, 135, 40);
		contentPane.add(btnTim);

		cmbTheLoaiSach = new JComboBox<String>();
		cmbTheLoaiSach.setBounds(547, 90, 238, 40);
		loadDataIntoComboboxTenLoaiSach();
		cmbTheLoaiSach.setSelectedIndex(-1);
		contentPane.add(cmbTheLoaiSach);

		btnquayLai = new JButton("← Quay Lại");
		btnquayLai.setForeground(Color.WHITE);
		btnquayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnquayLai.setBackground(new Color(73, 129, 158));
		btnquayLai.setBounds(10, 10, 135, 40);
		btnquayLai.addActionListener(new ActionListener() {

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
		contentPane.add(btnquayLai);

		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(133, 330, 238, 40);
		contentPane.add(txtTacGia);

		cmbNhaXuatBan = new JComboBox<String>();
		cmbNhaXuatBan.setBounds(547, 167, 238, 40);
		loadDataIntoComboboxTenNhaXuatBan();
		cmbNhaXuatBan.setSelectedIndex(-1);
		contentPane.add(cmbNhaXuatBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(547, 330, 238, 40);
		contentPane.add(txtGiaBan);

		txtSoTrang = new JTextField();
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(967, 87, 238, 40);
		contentPane.add(txtSoTrang);

		JLabel lblSoLuong = new JLabel("Số Lượng :");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(819, 167, 127, 40);
		contentPane.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(967, 167, 238, 40);
		contentPane.add(txtSoLuong);
	}

	private boolean duLieuRong() {
		if (txtMaSach.getText().equals("") && txtTenSach.getText().equals("") && txtXuatXu.getText().equals("")
				&& txtGiaNhap.getText().equals("") && txtGiaBan.getText().equals("") && txtSoLuong.getText().equals("")
				&& cmbNhaXuatBan.getSelectedIndex() == -1 && cmbTheLoaiSach.getSelectedIndex() == -1
				&& txtTacGia.getText().equals("") && txtSoTrang.getText().equals("") && txtSoLuong.getText().equals("")
				&& txtNamXuatBan.getText().equals("") && cmbTheLoaiSach.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải điền ít nhất một thông tin!");
			return false;
		}
		return true;
	}

//	public boolean kTraThoaMan(SanPham sanPham) {
//		boolean thoaMan = false;
//		if (sanPham.getMaSanPham().equalsIgnoreCase(txtMaSach.getText())) {
//			thoaMan = true;
//		} else if (sanPham.getTenSanPham().equalsIgnoreCase(txtTenSach.getText())) {
//			thoaMan = true;
//		} else if (sanPham.getTenSanPham().equalsIgnoreCase(txtXuatXu.getText())) {
//			thoaMan = true;
//		} else if (sanPham.getGiaBan() == Float.parseFloat(txtGiaNhap.getText())) {
//			thoaMan = true;
//		} else if (sanPham.getGiaBan() == Float.parseFloat(txtGiaBan.getText())) {
//			thoaMan = true;
//		} else if (sanPham.getSoLuongTon() == Integer.parseInt(txtSoLuong.getText())) {
//			thoaMan = true;
//		} else if (cmbNhaXuatBan.getSelectedIndex() != -1) {
//			NhaXuatBan tenNhaXuatBan = nhaXuatBan_DAO.getnhaXuatBanTheoMa(sanPham.getMaNXB());
//			if (tenNhaXuatBan.getTenNhaXuatBan().toLowerCase()
//					.equalsIgnoreCase(cmbNhaXuatBan.getSelectedItem().toString().toLowerCase())) {
////				System.out.println(tenNhaXuatBan.getTenNhaXuatBan());
//				thoaMan = true;
//			}
//		}
//
//		else if (cmbTheLoaiSach.getSelectedIndex() != -1) {
//			TheLoaiSach tenTheLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoMa(sanPham.getMaTheLoaiSach());
//			if (tenTheLoaiSach.gettenTheLoaiSach().toLowerCase()
//					.equalsIgnoreCase(cmbTheLoaiSach.getSelectedItem().toString().toLowerCase())) {
//				thoaMan = true;
//			}
//		} else if (!txtTacGia.getText().isEmpty()) {
//			if (sanPham.getTenSanPham().toLowerCase().contains(txtTacGia.getText().toLowerCase())) {
//				thoaMan = true;
//			}
//		} else if (!txtSoTrang.getText().isEmpty()) {
//			if (sanPham.getSoLuongTon() == Integer.parseInt(txtSoTrang.getText())) {
//				thoaMan = true;
//			}
//		} else if (!txtNamXuatBan.getText().isEmpty()) {
//			if (sanPham.getSoLuongTon() == Integer.parseInt(txtNamXuatBan.getText())) {
//				thoaMan = true;
//			}
//		}
//		return closable;
//	}

	public void searchSach() {
		for (SanPham sanPham : sanPham_DAO.getAllSach()) {
			boolean thoaMan = false;

			if (!txtMaSach.getText().isEmpty()) {
				if (sanPham.getMaSanPham().equalsIgnoreCase(txtMaSach.getText())) {
					thoaMan = true;
				}
			}
			// toLowerCase() chuyển đổi tất cả các ký tự trong một chuỗi thành chữ thường.
			if (!txtTenSach.getText().isEmpty()) {
				if (sanPham.getTenSanPham().toLowerCase().contains(txtTenSach.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtXuatXu.getText().isEmpty()) {
				if (sanPham.getTenSanPham().toLowerCase().contains(txtXuatXu.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtTacGia.getText().isEmpty()) {
				if (sanPham.getTenSanPham().toLowerCase().contains(txtTacGia.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (cmbTheLoaiSach.getSelectedIndex() != -1) {
				TheLoaiSach theLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoTen(cmbTheLoaiSach.getSelectedItem().toString());
				if (theLoaiSach.getmaTheLoaiSach().equals(sanPham.getMaTheLoaiSach())) {
					thoaMan = true;
				}
			}
			if (cmbNhaXuatBan.getSelectedIndex() != -1) {
				NhaXuatBan nhaXuatBan = nhaXuatBan_DAO.getnhaXuatBanTheoTen(cmbNhaXuatBan.getSelectedItem().toString());
				if (nhaXuatBan.getMaNhaXuatBan().equals(sanPham.getMaNXB())) {
					thoaMan = true;
				}
			}
			if (!txtGiaNhap.getText().isEmpty()) {
				if (sanPham.getGiaNhap() == Float.parseFloat(txtGiaNhap.getText())) {
					thoaMan = true;
				}
			}
			if (!txtGiaBan.getText().isEmpty()) {
				if (sanPham.getGiaBan() == Float.parseFloat(txtGiaBan.getText())) {
					thoaMan = true;
				}
			}
			if (!txtSoTrang.getText().isEmpty()) {
				if (sanPham.getSoTrang() == Integer.parseInt(txtSoTrang.getText())) {
					thoaMan = true;
				}
			}
			if (!txtSoLuong.getText().isEmpty()) {
				if (sanPham.getSoLuongTon() == Integer.parseInt(txtSoLuong.getText())) {
					thoaMan = true;
				}
			}
			if (!txtNamXuatBan.getText().isEmpty()) {
				if (sanPham.getSoLuongTon() == Integer.parseInt(txtNamXuatBan.getText())) {
					thoaMan = true;
				}
			}
			
			if (thoaMan) {
				ds.add(sanPham);
			}
		}
	}

	// load cbTenNhaXuatBan
	private void loadDataIntoComboboxTenNhaXuatBan() {
		cmbNhaXuatBan.removeAllItems();
		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllListNhaXuatBan()) {
			cmbNhaXuatBan.addItem(nhaXuatBan.getTenNhaXuatBan());
		}
	}

	// load cbTenTheLoaiSachs
	private void loadDataIntoComboboxTenLoaiSach() {
		cmbTheLoaiSach.removeAllItems();
		for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
			cmbTheLoaiSach.addItem(theLoaiSach.gettenTheLoaiSach());
		}
	}

	public void loadAll() {
		for (SanPham sanPham : sanPham_DAO.getAllSach()) {
			ds.add(sanPham);
		}
	}
}
