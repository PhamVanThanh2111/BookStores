package gui;


	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class A {
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Menu Example");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 300);

	        JMenuBar menuBar = new JMenuBar();
	        JMenu fileMenu = new JMenu("File");
	        JMenuItem openItem = new JMenuItem("Open");
	        JMenuItem exitItem = new JMenuItem("Exit");

	        // Thêm sự kiện cho nút Open
	        openItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(frame, "Bạn đã chọn Open!");
	            }
	        });

	        // Thêm sự kiện cho nút Exit
	        exitItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });

	        fileMenu.add(openItem);
	        fileMenu.addSeparator();
	        fileMenu.add(exitItem);
	        menuBar.add(fileMenu);

	        frame.setJMenuBar(menuBar);

	        JButton showMenuButton = new JButton("Hiện Menu");
	        showMenuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                menuBar.setVisible(!menuBar.isVisible());
	            }
	        });

	        JPanel panel = new JPanel();
	        panel.add(showMenuButton);

	        frame.add(panel);
	        frame.setVisible(true);
	    }
	}

