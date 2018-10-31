import database.ParseDataController;
import models.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton btnInsertBook;
    private JTable tblBooks;
    private JTable tblEmployees;
    private JProgressBar prgBar;
    private JLabel lblStatus;
    private JButton btnEditSelectedBook;
    private JButton btnDeleteSelectedBook;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciador de Biblioteca");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() throws IOException{
        configComponents();

        createBookTable();
        createEmployeeTable();
    }

    private void createBookTable() throws IOException {
        String[] columnNames = {"Título",
                "Autor",
                "Ano de Lançamento",
                "Categoria",
                "Páginas"};

        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

        for (Book book : ParseDataController.getBooks()) {
            String title = book.getTitle();
            String author = book.getAuthor();
            int launchYear = book.getLaunchYear();
            String category = book.getCategory();
            int pages = book.getPages();

            Object[] data = {title, author, launchYear, category, pages};

            dtm.addRow(data);

        }

        tblBooks = new JTable(dtm);
    }

    private void createEmployeeTable() throws IOException {
        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        tblEmployees = new JTable(data, columnNames);
    }

    private void configComponents() {
        configureProgressBar();
    }

    private void configureProgressBar() {
        prgBar = new JProgressBar();

        prgBar.setMinimum(0);
        prgBar.setMaximum(100);

        prgBar.setValue(50);
    }
}
