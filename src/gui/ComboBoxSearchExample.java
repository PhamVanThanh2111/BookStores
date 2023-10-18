package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxSearchExample extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
    private JTextField searchField;

    public ComboBoxSearchExample() {
        setTitle("ComboBox Search Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Sample data for the combo box
        List<String> items = new ArrayList<>();
        items.add("Apple Thanh");
        items.add("Banana");
        items.add("Cherry");
        items.add("Grapes");
        items.add("Orange");
        items.add("Strawberry");

        // Create the combo box with the sample data
        comboBox = new JComboBox<>(items.toArray(new String[0]));

        // Create a text field for searching
        searchField = new JTextField(20);
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                if (searchText.isEmpty()) {
                    // If search text is empty, show all items
                    comboBox.setModel(new DefaultComboBoxModel<>(items.toArray(new String[0])));
                } else {
                    // Filter items based on the search text
                    List<String> filteredItems = new ArrayList<>();
                    for (String item : items) {
                        if (item.toLowerCase().contains(searchText)) {
                            filteredItems.add(item);
                        }
                    }
                    comboBox.setModel(new DefaultComboBoxModel<>(filteredItems.toArray(new String[0])));
                }
            }
        });

        // Create a panel to hold the combo box and the search field
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(searchField);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ComboBoxSearchExample example = new ComboBoxSearchExample();
            example.setVisible(true);
        });
    }
}
