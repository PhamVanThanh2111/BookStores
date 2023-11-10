package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaXuatBan_DAO;
import dao.PhatSinhMa_DAO;
import entity.NhaXuatBan;
import entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;

public class NhaXuatBan_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;

	private JTextField txtTenNhaXuatBan;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;

	private JLabel lblMaNXBValue;
	private JLabel lblTenNXB;

	private JButton btnLamMoi;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnTim;

	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;

	private TimKiemNhaXuatBan_GUI timKiemNhaXuatBan_GUI;
	private ArrayList<NhaXuatBan> ds;
	private Border borderDefault;

	/**
	 * Create the panel.
	 */
	public NhaXuatBan_GUI(NhanVien nhanVien) {

		// Khai bao DAO
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();

		ds = new ArrayList<NhaXuatBan>();

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		desktopPane.add(pMain);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pMain.add(pNhapThongTin);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 115, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setToolTipText("Số điện thoại");
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBackground(Color.WHITE);
		txtSoDienThoai.setBounds(170, 115, 240, 40);
		pNhapThongTin.add(txtSoDienThoai);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 160, 56, 40);
		pNhapThongTin.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(170, 160, 240, 40);
		pNhapThongTin.add(txtEmail);

		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);

		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Nhà Xuất Bản");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 65, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 275, 390, 2);
		pNhapThongTin.add(separator_1);

		JLabel lblthongTinNXB = new JLabel("Thông Tin Nhà Xuất Bản:");
		lblthongTinNXB.setToolTipText("Thông tin nhà XB");
		lblthongTinNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongTinNXB.setForeground(new Color(28, 28, 28));
		lblthongTinNXB.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblthongTinNXB.setBounds(20, 317, 270, 40);
		pNhapThongTin.add(lblthongTinNXB);

		JLabel lblMaNXB = new JLabel("Mã NXB:");
		lblMaNXB.setToolTipText("mã nhà xuất bản");
		lblMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNXB.setBounds(40, 409, 120, 40);
		pNhapThongTin.add(lblMaNXB);

		lblMaNXBValue = new JLabel("NV0001");
		lblMaNXBValue.setToolTipText("Số điện thoại");
		lblMaNXBValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNXBValue.setBounds(170, 409, 120, 40);
		pNhapThongTin.add(lblMaNXBValue);

		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà xuất bản");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 454, 120, 40);
		pNhapThongTin.add(lbldiaChi);

		txtTenNhaXuatBan = new JTextField();
		txtTenNhaXuatBan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenNhaXuatBan.setToolTipText("tên nhà xuất bản");
		txtTenNhaXuatBan.setText("Nhà Xuất Bản Trẻ");
		txtTenNhaXuatBan.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtTenNhaXuatBan.setEditable(false);
		txtTenNhaXuatBan.setColumns(10);
		txtTenNhaXuatBan.setBorder(null);
		txtTenNhaXuatBan.setBackground(Color.WHITE);
		txtTenNhaXuatBan.setBounds(170, 358, 240, 40);
		pNhapThongTin.add(txtTenNhaXuatBan);

		txtDiaChi = new JTextField();
		txtDiaChi.setToolTipText("Địa chỉ nhà xuất bản");
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setBounds(170, 454, 240, 40);
		pNhapThongTin.add(txtDiaChi);

		lblTenNXB = new JLabel("Tên NXB:");
		lblTenNXB.setToolTipText("tên nhà xuất bả");
		lblTenNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenNXB.setBounds(40, 359, 120, 40);
		pNhapThongTin.add(lblTenNXB);

		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 0, 857, 720);
		pMain.add(pDanhSach);

		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setToolTipText("Chọn vào nhà xuất bản cần hiển thị thông tin");
		scrollPaneNXB.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNXB.setBackground(new Color(80, 80, 80));
		scrollPaneNXB.setBounds(20, 82, 810, 557);
		pDanhSach.add(scrollPaneNXB);

		String cols[] = { "Mã Nhà Xuất Bản", "Tên Nhà Xuất Bản", "Địa Chỉ", "Số Điện Thoại", "Email" };
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
				int row = table.getSelectedRow();
				if (row >= 0) { // Ensure a row is selected
					NhaXuatBan nhaXuatBan = nhaXuatBan_DAO.getnhaXuatBanTheoMa(model.getValueAt(row, 0).toString());
					lblMaNXBValue.setText(nhaXuatBan.getMaNhaXuatBan());
					txtTenNhaXuatBan.setText(nhaXuatBan.getTenNhaXuatBan());
					txtDiaChi.setText(nhaXuatBan.getDiaChi());
					txtSoDienThoai.setText(nhaXuatBan.getSoDienThoai());
					txtEmail.setText(nhaXuatBan.getEmail());
				}

			}
		});

		scrollPaneNXB.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(20, 40, 810, 2);
		pDanhSach.add(separator);

		btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/add_person.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(239, 660, 135, 40);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnAdd.getText().equals("Thêm")) {
					enableEdit();
					btnDelete.setText("Hủy");
					btnAdd.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnTim.setEnabled(false);

				} else {
					add();
					disableEdit();
					btnAdd.setText("Thêm");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pDanhSach.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/remove_person.png")));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(391, 660, 135, 40);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnDelete.getText().equals("Xóa"))
					delete();
				else {
					disableEdit();
					btnAdd.setText("Thêm");
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pDanhSach.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/update_person.png")));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(543, 660, 135, 40);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (btnUpdate.getText().equals("Sửa")) {
					if (row == -1)
						JOptionPane.showMessageDialog(null, "Bạn phải chọn vào nhà xuất bản cần sửa!");
					else {
						enableEdit();
						btnDelete.setText("Hủy");
						btnUpdate.setText("Xác nhận");
						btnLamMoi.setEnabled(false);
						btnAdd.setEnabled(false);
						btnTim.setEnabled(false);
					}
				} else {
					update();
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					disableEdit();
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pDanhSach.add(btnUpdate);
		
		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/find_person.png")));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(695, 660, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// null cho lan dau chay va isClose cho nhung click sau
				if (timKiemNhaXuatBan_GUI == null || timKiemNhaXuatBan_GUI.isClosed()) {
					timKiemNhaXuatBan_GUI = new TimKiemNhaXuatBan_GUI(ds);
					timKiemNhaXuatBan_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
							// System.out.println("Internal frame is opened.");
							disableButton();
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
							// System.out.println("Internal frame is closed.");
							model.setRowCount(0);
							loadDataIntoTable(ds);
							ds.removeAll(ds);
							enableButton();
						}
					});
					desktopPane.add(timKiemNhaXuatBan_GUI).setVisible(true);
				}
			}

		});
		pDanhSach.add(btnTim);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setOpaque(true);
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(87, 660, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				refresh();
			}

		});
		pDanhSach.add(btnLamMoi);

		// load Data
		refresh();
		
		if (nhanVien.getChucVu().equals("Bán hàng")) {
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
		}
	}

	// đưa dữ liệu lên bảng
	private void loadDataIntoTable(ArrayList<NhaXuatBan> list) {
		model.setRowCount(0);
		for (NhaXuatBan nhaXuatBan : list) {
			Object[] object = { nhaXuatBan.getMaNhaXuatBan(), nhaXuatBan.getTenNhaXuatBan(), nhaXuatBan.getDiaChi(),
					nhaXuatBan.getSoDienThoai(), nhaXuatBan.getEmail() };
			model.addRow(object);
		}
	}

	private void refresh() {
		loadDataIntoTable(nhaXuatBan_DAO.getAllListNhaXuatBan());
	}
	// private void xoaTrang() {
	// txtTenNhaXuatBan.setText("");
	// txtDiaChi.setText("");
	// txtSoDienThoai.setText("");
	// txtEmail.setText("");
	// txtTenNhaXuatBan.requestFocus();
	// }

	// Thêm nhà xuất bản
	public boolean add() {
		if (txtTenNhaXuatBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên nhà xuất bản không được để trống!");
			txtTenNhaXuatBan.requestFocus();
			return false;
		} else if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ nhà xuất bản không được để trống!");
			txtDiaChi.requestFocus();
			return false;
		} else if (txtSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại nhà xuất bản không được để trống!");
			txtSoDienThoai.requestFocus();
			return false;
		} else if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Email nhà xuất bản không được để trống!");
			txtEmail.requestFocus();
			return false;
		} else {
			try {
				NhaXuatBan nhaXuatBan = new NhaXuatBan();
				nhaXuatBan.setTenNhaXuatBan(txtTenNhaXuatBan.getText());
				nhaXuatBan.setMaNhaXuatBan(phatSinhMa_DAO.getMaNhaXuatBan());
				nhaXuatBan.setDiaChi(txtDiaChi.getText());
				nhaXuatBan.setSoDienThoai(txtSoDienThoai.getText());
				nhaXuatBan.setEmail(txtEmail.getText());

				nhaXuatBan_DAO.themNhaXuatBan(nhaXuatBan);

				JOptionPane.showMessageDialog(null, "Thêm nhà xuất bản thành công!");
				refresh();
				return true;
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Thêm nhà xuất bản thất bại!");
				e1.printStackTrace();
				return false;
			}
		}
	}

	// Xóa nhà xuất bản
	public boolean delete() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showInternalMessageDialog(null, "Bạn phải chọn nhà xuất bản cần xóa!");
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn xóa nhà xuất bản '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					nhaXuatBan_DAO.xoaNhaXuatBanTheoMa(model.getValueAt(row, 0).toString());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,
							"Không được xóa nhà xuất bản này. Bởi vì sẽ mất toàn bộ dữ liệu sách của nhà xuất bản này!");
					return false;
				}
				JOptionPane.showMessageDialog(null, "Xóa nhà xuất bản '" + model.getValueAt(row, 0) + "' thành công!");
				refresh();
				return true;
			} else {
				return false;
			}
		}
	}

	// Sửa nhà xuất bản theo mã
	public boolean update() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn nhà xuất bản cần sửa!");
		} else if (txtTenNhaXuatBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên nhà xuất bản không được để trống!");
			txtTenNhaXuatBan.requestFocus();
			return false;
		} else if (txtSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại nhà xuất bản không được để trống!");
			txtSoDienThoai.requestFocus();
			return false;
		} else if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Email nhà xuất bản không được để trống!");
			txtEmail.requestFocus();
			return false;
		} else if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ nhà xuất bản không được để trống!");
			txtDiaChi.requestFocus();
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn sửa nhà xuất bản? '" + model.getValueAt(row, 0) + "' chứ?", "Sửa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					NhaXuatBan nhaXuatBan = new NhaXuatBan(lblMaNXBValue.getText(), txtTenNhaXuatBan.getText(),
							txtDiaChi.getText(),txtSoDienThoai.getText(),txtEmail.getText() );
					nhaXuatBan_DAO.suaNhaXuatBanTheoMa(nhaXuatBan);
					JOptionPane.showMessageDialog(null,
							"Sửa thành công nhà xuất bản '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Sửa nhà xuất bản '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	private void enableEdit() {
		txtTenNhaXuatBan.setEditable(true);
		txtDiaChi.setEditable(true);
		txtDiaChi.setBorder(borderDefault);
		txtSoDienThoai.setEditable(true);
		txtSoDienThoai.setBorder(borderDefault);
		txtEmail.setEditable(true);
		txtEmail.setBorder(borderDefault);
	}
	private void disableEdit() {
		txtTenNhaXuatBan.setEditable(false);
		txtTenNhaXuatBan.setBorder(null);
		txtDiaChi.setEditable(false);
		txtDiaChi.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBorder(null);
		txtEmail.setEditable(false);
		txtEmail.setBorder(null);
	}
	private void enableButton() {
		btnLamMoi.setEnabled(true);
		btnAdd.setEnabled(true);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnTim.setEnabled(true);
	}
	private void disableButton() {
		btnLamMoi.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnTim.setEnabled(false);
	}
}