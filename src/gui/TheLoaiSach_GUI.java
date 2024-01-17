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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.PhatSinhMa_DAO;
import dao.TheLoaiSach_DAO;
import entity.NhanVien;
import entity.TheLoaiSach;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TheLoaiSach_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaTheLoaiSach;
	private JTextField txtTenTheLoaiSach;

	private JPanel panel;
	private JPanel pThongTin;
	private JLabel lblThongTinTheLoaiSach;
	private JLabel lblMaTheLoaiSach;
	private JTable table;
	private JLabel lblTenTheLoaiSach;
	private JPanel pDanhSach;

	private JButton btnLamMoi;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnTim;

	private JScrollPane scrollPaneTheLoaiSach;

	private JTableHeader tableHeader;

	private DefaultTableModel model;

	private TheLoaiSach_DAO theLoaiSach_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;

	private JDesktopPane desktopPane;

	private JInternalFrame timKiemTheLoaiSach_GUI;
	private ArrayList<TheLoaiSach> ds;

	/**
	 * Create the panel.
	 */
	public TheLoaiSach_GUI(NhanVien nhanVien) {

		// khai bao DAO
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();

		ds = new ArrayList<TheLoaiSach>();

		setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1300, 720);
		add(panel);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		desktopPane.setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		desktopPane.add(pMain);

		pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 204, 1300, 516);

		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 184);
		pMain.add(pThongTin);

		lblThongTinTheLoaiSach = new JLabel("Thông Tin Thể Loại Sách");
		lblThongTinTheLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinTheLoaiSach.setBounds(20, 15, 300, 40);
		pThongTin.add(lblThongTinTheLoaiSach);

		btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/add_person.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(103, 124, 135, 40);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnAdd.getText().equals("Thêm")) {
					enableEdit();
					focusable();
					btnDelete.setText("Hủy");
					btnAdd.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnTim.setEnabled(false);

				} else {
					add();
					disableEdit();
					unfocusable();
					btnAdd.setText("Thêm");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}

		});
		pThongTin.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/remove_person.png")));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(342, 124, 135, 40);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnDelete.getText().equals("Xóa"))
					try {
						delete();
					} catch (Exception e2) {
						// TODO: handle exception
					}
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
		pThongTin.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/update_person.png")));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(581, 124, 135, 40);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (btnUpdate.getText().equals("Sửa")) {
					if (row == -1)
						JOptionPane.showMessageDialog(null, "Bạn phải chọn vào thể lọai sách cần sửa!");
					else {
						enableEdit();
						focusable();
						btnDelete.setText("Hủy");
						btnUpdate.setText("Xác nhận");
						btnLamMoi.setEnabled(false);
						btnAdd.setEnabled(false);
						btnTim.setEnabled(false);
					}
				} else {
					update();
					unfocusable();
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					disableEdit();
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pThongTin.add(btnUpdate);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lamMoi();
//				refresh();
			}
		});
		btnLamMoi.setBounds(1060, 124, 135, 40);

		pThongTin.add(btnLamMoi);
		btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(820, 124, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// null cho lan dau chay va isClose cho nhung click sau
				if (timKiemTheLoaiSach_GUI == null || timKiemTheLoaiSach_GUI.isClosed()) {
					timKiemTheLoaiSach_GUI = new TimKiemTheLoaiSach_GUI(ds);
					timKiemTheLoaiSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
//			                System.out.println("Internal frame is opened.");
							disableButton();
							unfocusable();
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
							model.setRowCount(0);
							loadData(ds);
//			            	System.out.println(ds);
							ds.removeAll(ds);
							enableButton();
							focusable();
						}
					});
					desktopPane.add(timKiemTheLoaiSach_GUI).setVisible(true);
				}
			}

		});
		pThongTin.add(btnTim);

		if (nhanVien.getChucVu().equals("Bán hàng")) {

			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
		}

		lblMaTheLoaiSach = new JLabel("Mã Thể Loại Sách:");
		lblMaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaTheLoaiSach.setBounds(50, 65, 150, 40);
		pThongTin.add(lblMaTheLoaiSach);

		lblTenTheLoaiSach = new JLabel("Tên Thể Loại Sách:");
		lblTenTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenTheLoaiSach.setBounds(680, 65, 175, 40);
		pThongTin.add(lblTenTheLoaiSach);

		txtMaTheLoaiSach = new JTextField();
		txtMaTheLoaiSach.setToolTipText("Mã  Thể Loại Sách");
		txtMaTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaTheLoaiSach.setEditable(false);
		txtMaTheLoaiSach.setColumns(10);
		txtMaTheLoaiSach.setBorder(null);
		txtMaTheLoaiSach.setBackground(Color.WHITE);
		txtMaTheLoaiSach.setBounds(227, 65, 400, 40);
		txtMaTheLoaiSach.setBorder(null);
		pThongTin.add(txtMaTheLoaiSach);

		txtTenTheLoaiSach = new JTextField();
		txtTenTheLoaiSach.setToolTipText("Tên thể loại sách");
		txtTenTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenTheLoaiSach.setEditable(false);
		txtTenTheLoaiSach.setColumns(10);
		txtTenTheLoaiSach.setBorder(null);
		txtTenTheLoaiSach.setBackground(Color.WHITE);
		txtTenTheLoaiSach.setBounds(850, 65, 400, 40);
		txtTenTheLoaiSach.setBorder(null);
		pThongTin.add(txtTenTheLoaiSach);

		scrollPaneTheLoaiSach = new JScrollPane();
		scrollPaneTheLoaiSach.setToolTipText("Chọn vào thể loại Sách cần hiển thị thông tin");
		scrollPaneTheLoaiSach.setBorder(null);
		scrollPaneTheLoaiSach.setBackground(Color.WHITE);
		scrollPaneTheLoaiSach.setBounds(20, 44, 1259, 451);
		pDanhSach.add(scrollPaneTheLoaiSach);

		String cols[] = { "Mã Thể Loại Sách", "Tên Thể Loại Sách" };
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
		// chỉ chọn được 1 dòng dữ liệu
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
				if (row >= 0) {
					TheLoaiSach theLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoMa(model.getValueAt(row, 0).toString());
					txtMaTheLoaiSach.setText(theLoaiSach.getmaTheLoaiSach());
					txtTenTheLoaiSach.setText(theLoaiSach.gettenTheLoaiSach());
				}
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
		JLabel lblChiTitTheLoaiSach = new JLabel("Chi Tiết Thể Loại Sách");
		lblChiTitTheLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitTheLoaiSach.setBounds(22, 10, 291, 40);
		pDanhSach.add(lblChiTitTheLoaiSach);
		
//		refresh();
//		unfocus
		unfocusable();
		
//		load Data
//		loadDataIntoTable(theLoaiSach_DAO.getAllListTheLoaiSach());
	}

	public TheLoaiSach_GUI() {

		// khai bao DAO
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();

		ds = new ArrayList<TheLoaiSach>();

		setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1300, 720);
		add(panel);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		desktopPane.setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		desktopPane.add(pMain);

		pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 204, 1300, 516);

		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 184);
		pMain.add(pThongTin);

		lblThongTinTheLoaiSach = new JLabel("Thông Tin Thể Loại Sách");
		lblThongTinTheLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinTheLoaiSach.setBounds(20, 15, 300, 40);
		pThongTin.add(lblThongTinTheLoaiSach);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lamMoi();
//				refresh();
			}
		});
		btnLamMoi.setBounds(960, 124, 135, 40);

		pThongTin.add(btnLamMoi);

		btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1115, 124, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// null cho lan dau chay va isClose cho nhung click sau
				if (timKiemTheLoaiSach_GUI == null || timKiemTheLoaiSach_GUI.isClosed()) {
					timKiemTheLoaiSach_GUI = new TimKiemTheLoaiSach_GUI(ds);
					timKiemTheLoaiSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
//			                System.out.println("Internal frame is opened.");
							btnLamMoi.setEnabled(false);
							
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
							model.setRowCount(0);
							loadData(ds);
//			            	System.out.println(ds);
							ds.removeAll(ds);
							btnLamMoi.setEnabled(true);
							
						}
					});
					desktopPane.add(timKiemTheLoaiSach_GUI).setVisible(true);
				}
			}

		});
		pThongTin.add(btnTim);

		lblMaTheLoaiSach = new JLabel("Mã Thể Loại Sách:");
		lblMaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaTheLoaiSach.setBounds(50, 65, 150, 40);
		pThongTin.add(lblMaTheLoaiSach);

		lblTenTheLoaiSach = new JLabel("Tên Thể Loại Sách:");
		lblTenTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenTheLoaiSach.setBounds(680, 65, 175, 40);
		pThongTin.add(lblTenTheLoaiSach);

		txtMaTheLoaiSach = new JTextField();
		txtMaTheLoaiSach.setToolTipText("Mã  Thể Loại Sách");
		txtMaTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaTheLoaiSach.setEditable(false);
		txtMaTheLoaiSach.setColumns(10);
		txtMaTheLoaiSach.setBackground(Color.WHITE);
		txtMaTheLoaiSach.setBorder(null);
		txtMaTheLoaiSach.setBounds(227, 67, 400, 40);
		txtMaTheLoaiSach.setFocusable(false);
//		txtMaTheLoaiSach.isEditable();
		pThongTin.add(txtMaTheLoaiSach);

		txtTenTheLoaiSach = new JTextField();
		txtTenTheLoaiSach.setToolTipText("Tên thể loại sách");
		txtTenTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenTheLoaiSach.setEditable(false);
		txtTenTheLoaiSach.setColumns(10);
		txtTenTheLoaiSach.setBackground(Color.WHITE);
		txtTenTheLoaiSach.setBounds(850, 65, 400, 40);
		txtTenTheLoaiSach.setBorder(null);
		pThongTin.add(txtTenTheLoaiSach);

		scrollPaneTheLoaiSach = new JScrollPane();
		scrollPaneTheLoaiSach.setToolTipText("Chọn vào thể loại Sách cần hiển thị thông tin");
		scrollPaneTheLoaiSach.setBorder(null);
		scrollPaneTheLoaiSach.setBackground(Color.WHITE);
		scrollPaneTheLoaiSach.setBounds(20, 44, 1259, 451);
		pDanhSach.add(scrollPaneTheLoaiSach);

		String cols[] = { "Mã Thể Loại Sách", "Tên Thể Loại Sách" };
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
		// chỉ chọn được 1 dòng dữ liệu
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
				if (row >= 0) {
					TheLoaiSach theLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoMa(model.getValueAt(row, 0).toString());
					txtMaTheLoaiSach.setText(theLoaiSach.getmaTheLoaiSach());
					txtTenTheLoaiSach.setText(theLoaiSach.gettenTheLoaiSach());
				}
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
		JLabel lblChiTitTheLoaiSach = new JLabel("Chi Tiết Thể Loại Sách");
		lblChiTitTheLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitTheLoaiSach.setBounds(22, 10, 291, 40);
		pDanhSach.add(lblChiTitTheLoaiSach);
		// loadData
		loadData(theLoaiSach_DAO.getAllTheLoaiSach());
		// unfocus
		unfocusable();
//		refresh();
		;
	}

	// đổ dữ liệu lên bảng
	public void loadData(ArrayList<TheLoaiSach> list) {
		model.setRowCount(0);
		for (TheLoaiSach theLoaiSach : list) {
			Object[] object = { theLoaiSach.getmaTheLoaiSach(), theLoaiSach.gettenTheLoaiSach() };
			model.addRow(object);
		}
	}

	// làm mới dữ liệu trên bảng
	public void lamMoi() {
		txtMaTheLoaiSach.setText("");
		txtTenTheLoaiSach.setText("");
	}
	// làm mới bảng
	public void refresh() {
		loadData(theLoaiSach_DAO.getAllTheLoaiSach());
	}

	// Thêm thể loại sách
	public boolean add() {
		
		if (txtTenTheLoaiSach.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên thể loại sách không được để trống!");
			txtTenTheLoaiSach.requestFocus();
			return false;
		} else {
			try {
				TheLoaiSach theLoaiSach = new TheLoaiSach();
				theLoaiSach.setmaTheLoaiSach(phatSinhMa_DAO.getMaTheLoaiSach());
				theLoaiSach.settenTheLoaiSach(txtTenTheLoaiSach.getText());
				theLoaiSach_DAO.themTheLoaiSach(theLoaiSach);
				JOptionPane.showMessageDialog(null, "Thêm thể loại sách thành công!");
				refresh();
				return true;
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Thêm thể loại sách thất bại!");
				e1.printStackTrace();
				return false;
			}
		}
	}
	// Kiểm tra rỗng cho thể loại sách
//		private boolean kiemTraRong() {
//			if (txtTenTheLoaiSach.getText().equals("") ||
//				txtMaTheLoaiSach.getText().equals("") {
//				return true;
//			}
//			return false;
//		}
	// Xóa thể loại sách
	public boolean delete() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showInternalMessageDialog(null, "Bạn phải chọn thể loại sách cần xóa!");
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn xóa thể loại sách '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					theLoaiSach_DAO.xoaTheLoaiSachTheoMa(model.getValueAt(row, 0).toString());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,
							"Không được xóa thể loại sách này. Bởi vì sẽ mất toàn bộ dữ liệu sách và nhà xuất bản của thể loại sách này!");
					return false;
				}
				// Nếu xóa nhân viên thì xóa luôn tài khoản của nhân viên đó
				JOptionPane.showMessageDialog(null, "Xóa nhân viên '" + model.getValueAt(row, 0) + "' thành công!");
				refresh();
				return true;
			} else {
				return false;
			}
		}
	}

	// Sửa thể loại sách theo mã
	public boolean update() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn thể loại sách cần sửa!");
		} else if (txtTenTheLoaiSach.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên thể loại sách không được để trống!");
			txtTenTheLoaiSach.requestFocus();
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn sửa thể loại sách? '" + model.getValueAt(row, 0) + "' chứ?", "Sửa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					TheLoaiSach theLoaiSach = new TheLoaiSach(txtMaTheLoaiSach.getText(), txtTenTheLoaiSach.getText());
					theLoaiSach_DAO.suaTheLoaiSachTheoMa(theLoaiSach);
					JOptionPane.showMessageDialog(null,
							"Sửa thành công thể loại sách '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Sửa thể loại sách '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}
	
	private void enableEdit() {
		txtTenTheLoaiSach.setEditable(true);
	}

	private void disableEdit() {
		txtTenTheLoaiSach.setEditable(false);
		txtTenTheLoaiSach.setBorder(null);
		txtMaTheLoaiSach.setEditable(false);
		txtMaTheLoaiSach.setBorder(null);
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
	private void focusable() {
		txtTenTheLoaiSach.setFocusable(true);
//		txtMaTheLoaiSach.setFocusable(true);
	}
	private void unfocusable() {
		txtTenTheLoaiSach.setFocusable(false);
		txtMaTheLoaiSach.setFocusable(false);
	}
	
}
