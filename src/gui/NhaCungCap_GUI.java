package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class NhaCungCap_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public NhaCungCap_GUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nha Cung Cap");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(372, 273, 439, 172);
		panel.add(lblNewLabel);

	}

}
