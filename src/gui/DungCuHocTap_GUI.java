package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class DungCuHocTap_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DungCuHocTap_GUI() {
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dung Cu Hoc Tap");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(563, 264, 366, 179);
		pnlMain.add(lblNewLabel);

	}
}
