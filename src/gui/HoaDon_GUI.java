package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class HoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HoaDon_GUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1256, 553);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoas don");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(271, 270, 200, 92);
		panel.add(lblNewLabel);

	}

}
