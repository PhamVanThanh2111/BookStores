package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableWithTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable with JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Dữ liệu mẫu cho JTable
        Object[][] data = {{"Row 1, Col 1", "Row 1, Col 2"}, {"Row 2, Col 1", "Row 2, Col 2"}};
        String[] columnNames = {"Column 1", "Column 2"};
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        
        // Tạo một JTextField để sử dụng làm editor
        JTextField textField = new JTextField();
        
        // Chèn JTextField vào ô cần chỉnh sửa (ở đây là cột thứ 1)
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
        
        // Tùy chỉnh cách hiển thị dữ liệu trong ô (optional)
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa nội dung trong ô
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        
        frame.pack();
        frame.setVisible(true);
    }
}
