package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxSearchExample extends JFrame {
    private JComboBox<String> comboBox;

    public ComboBoxSearchExample() {
        setTitle("Editable ComboBox Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Sample data for the combo box
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Grapes");
        items.add("Orange");
        items.add("Strawberry");

        // Create the combo box with the sample data
        comboBox = new JComboBox<>(items.toArray(new String[0]));

        // Enable typing directly into the combo box
        comboBox.setEditable(true);

        // Add key listener for handling key events
        comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String searchText = ((JTextField) e.getSource()).getText().toLowerCase();
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
                });
            }
        });

        // Create a panel to hold the combo box
        JPanel panel = new JPanel();
        panel.add(comboBox);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ComboBoxSearchExample().setVisible(true);
    }
}
