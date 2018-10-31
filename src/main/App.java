package main;

import database.ParseDataController;
import dialogs.JOptionPaneMultiInput;
import models.Book;
import models.Employee;
import models.TableModel;
import resources.Strings;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.IOException;

public class App {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton btnInsertBook;
    private JTable tblBooks;
    private JTable tblEmployees;
    private JLabel lblStatus;
    private JButton btnEditSelectedBook;
    private JButton btnDeleteSelectedBook;
    private JButton btnInsertEmployee;
    private JButton btnEditSelectedEmployee;
    private JButton btnDeleteSelectedEmployee;

    private int defaultRowCount = 0;

    TableModel bookTableModel;
    TableModel employeeTableModel;

    Book selectedBook;
    Employee selectedEmployee;

    public static void main(String[] args) {
        JFrame frame = new JFrame(Strings.title_app);
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void getData() throws IOException {
        clearTables();

        insertBookTableData();
        insertEmployeeTableData();

        if (tblBooks.getRowCount() > 0 && tblEmployees.getRowCount() > 0)
            setStatus("Dados Atualizados");
        else
            setStatus("Erro ao Carregar Dados");
    }

    private void clearTables() {
        bookTableModel.setRowCount(0);
        employeeTableModel.setRowCount(0);
    }

    private void createUIComponents() throws IOException {
        bookTable();
        employeeTable();

        btnInsertBook();
        btnEditBook();
        btnDeleteBook();

        btnInsertEmployee();
        btnEditEmployee();
        btnDeleteEmployee();

        status();
    }

    private void bookTable() throws IOException {
        bookTableModel = new TableModel(Strings.bookColumns, defaultRowCount);

        insertBookTableData();

        tblBooks = new JTable(bookTableModel);

        tblBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblBooks.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = tblBooks.getSelectedRow();

                if (index != -1) {
                    String objectId = (String) tblBooks.getValueAt(index, 0);
                    String title = (String) tblBooks.getValueAt(index, 1);
                    String author = (String) tblBooks.getValueAt(index, 2);
                    int launchYear = (int) tblBooks.getValueAt(index, 3);
                    String category = (String) tblBooks.getValueAt(index, 4);
                    int pages = (int) tblBooks.getValueAt(index, 5);

                    selectedBook = new Book(objectId, title, author, launchYear, category, pages);
                }
            }
        });
    }

    private void insertBookTableData() throws IOException {
        for (Book book : ParseDataController.getBooks()) {
            String id = book.getObjectId();
            String title = book.getTitle();
            String author = book.getAuthor();
            int launchYear = book.getLaunchYear();
            String category = book.getCategory();
            int pages = book.getPages();

            Object[] data = {id, title, author, launchYear, category, pages};

            bookTableModel.addRow(data);
        }
    }

    private void employeeTable() throws IOException {
        employeeTableModel = new TableModel(Strings.employeeColumns, defaultRowCount);

        insertEmployeeTableData();

        tblEmployees = new JTable(employeeTableModel);

        tblEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblEmployees.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = tblEmployees.getSelectedRow();

                if (index != -1) {
                    String objectId = (String) tblEmployees.getValueAt(index, 0);
                    String name = (String) tblEmployees.getValueAt(index, 1);
                    String phone = (String) tblEmployees.getValueAt(index, 2);

                    selectedEmployee = new Employee(objectId, name, phone);
                }
            }
        });
    }

    private void insertEmployeeTableData() throws IOException {
        for (Employee employee : ParseDataController.getEmployees()) {
            String id = employee.getObjectId();
            String name = employee.getName();
            String phone = employee.getPhone();

            Object[] data = {id, name, phone};

            employeeTableModel.addRow(data);
        }
    }

    private void btnInsertBook() {
        btnInsertBook = new JButton();
        btnInsertBook.addActionListener(e -> {
            try {

                if (JOptionPaneMultiInput.showInsertBookDialog())
                    getData();
                else
                    setStatus("Não foi possível inserir o livro no banco de dados");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void btnEditBook() {
        btnEditSelectedBook = new JButton();
        btnEditSelectedBook.addActionListener(e -> {
            try {
                if (selectedBook != null) {
                    if (JOptionPaneMultiInput.showEditBookDialog(selectedBook)) {
                        getData();

                    } else
                        setStatus("Não foi possível editar o livro no banco de dados");

                } else
                    JOptionPane.showMessageDialog(null, "É necessário selecionar um item para editar!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void btnDeleteBook() {
        btnDeleteSelectedBook = new JButton();
        btnDeleteSelectedBook.addActionListener(e -> {
            try {
                if (selectedBook != null) {
                    if (JOptionPaneMultiInput.showDeleteBookDialog(selectedBook)) {
                        getData();

                    } else
                        setStatus("Não foi possível excluir o livro no banco de dados");

                } else
                    JOptionPane.showMessageDialog(null, "É necessário selecionar um item para editar!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void btnInsertEmployee() {
        btnInsertEmployee = new JButton();
        btnInsertEmployee.addActionListener(e -> {
            try {

                if (JOptionPaneMultiInput.showInsertEmployeeDialog())
                    getData();
                else
                    setStatus("Não foi possível inserir o funcionário no banco de dados");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void btnEditEmployee() {
        btnEditSelectedEmployee = new JButton();
        btnEditSelectedEmployee.addActionListener(e -> {
            try {
                if (selectedEmployee != null) {
                    if (JOptionPaneMultiInput.showEditEmployeeDialog(selectedEmployee)) {
                        getData();

                    } else
                        setStatus("Não foi possível editar o funcionário no banco de dados");

                } else
                    JOptionPane.showMessageDialog(null, "É necessário selecionar um item para editar!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void btnDeleteEmployee() {
        btnDeleteSelectedEmployee = new JButton();
        btnDeleteSelectedEmployee.addActionListener(e -> {
            try {
                if (selectedEmployee != null) {
                    if (JOptionPaneMultiInput.showDeleteEmployeeDialog(selectedEmployee)) {
                        getData();

                    } else
                        setStatus("Não foi possível excluir o funcionário no banco de dados");

                } else
                    JOptionPane.showMessageDialog(null, "É necessário selecionar um item para editar!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void status() {
        lblStatus = new JLabel();
    }

    private void setStatus(String text) {
        lblStatus.setText(text);
    }
}
