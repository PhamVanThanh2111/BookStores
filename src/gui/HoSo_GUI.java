package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HoSo_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HoSo_GUI() {
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblBackgroundHoSo = new JLabel("");
		lblBackgroundHoSo.setIcon(new ImageIcon(HoSo_GUI.class.getResource("/image/background_hoso.jpg")));
		lblBackgroundHoSo.setBounds(0, 0, pnlMain.getWidth(), pnlMain.getHeight());
		pnlMain.add(lblBackgroundHoSo);

	}
}
