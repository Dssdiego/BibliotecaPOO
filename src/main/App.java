import database.ParseDataController;
import listeners.InsertBookButtonListener;
import models.Book;
import models.Employee;
import models.TableModel;
import resources.Strings;

import javax.swing.*;
import java.io.IOException;

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

    private int defaultRowCount = 0;

    TableModel bookTableModel;
    TableModel employeeTableModel;

    public static void main(String[] args) {
        JFrame frame = new JFrame(Strings.title_app);
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void getData() throws IOException {
        clearTables();
    }

    private void clearTables() throws IOException {
        bookTableModel.clear();
        employeeTableModel.clear();

        createBookTable();
        createEmployeeTable();
    }

    private void createUIComponents() throws IOException {
        configComponents();

        createBookTable();
        createEmployeeTable();

        btnInsertBook = new JButton();
        btnInsertBook.addActionListener(new InsertBookButtonListener());
    }

    private void createBookTable() throws IOException {
        bookTableModel = new TableModel(Strings.bookColumns, defaultRowCount);

        for (Book book : ParseDataController.getBooks()) {
            String title = book.getTitle();
            String author = book.getAuthor();
            int launchYear = book.getLaunchYear();
            String category = book.getCategory();
            int pages = book.getPages();

            Object[] data = {title, author, launchYear, category, pages};

            bookTableModel.addRow(data);

        }

        tblBooks = new JTable(bookTableModel);
    }

    private void createEmployeeTable() throws IOException {
        employeeTableModel = new TableModel(Strings.employeeColumns, defaultRowCount);

        for (Employee employee : ParseDataController.getEmployees()) {
            String name = employee.getName();
            String phone = employee.getPhone();

            Object[] data = {name, phone};

            employeeTableModel.addRow(data);
        }

        tblEmployees = new JTable(employeeTableModel);
    }

    private void configComponents() {
        configureProgressBar();
    }

    private void configureProgressBar() {
        prgBar = new JProgressBar();

        prgBar.setMinimum(0);
        prgBar.setMaximum(100);

//        prgBar.setValue(50);
    }
}
