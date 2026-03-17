package com.example;

import java.awt.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame {

    // Налаштування бази даних
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty321";

    private DefaultTableModel tableModel;

    public App() {
        super("MySQL Viewer — Single File");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        // Створення інтерфейсу
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        


        add(new JScrollPane(table), BorderLayout.CENTER);

        // Перше завантаження при старті
        loadData();
    }

    private void loadData() {
        String query = "SELECT * FROM students";

        // 1. Явно завантажуємо драйвер (про всяк випадок для старих середовищ)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            showError("Драйвер MySQL не знайдено в Classpath!");
            return;
        }

        // 2. Робота з БД
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            // Очищення таблиці
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);

            // Додаємо заголовки
            for (int i = 1; i <= cols; i++) {
                tableModel.addColumn(meta.getColumnName(i));
            }

            // Додаємо рядки
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= cols; i++) {
                    row.add(rs.getObject(i));
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            showError("Помилка БД: " + e.getMessage());
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Помилка", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Запуск GUI в правильному потоці
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}