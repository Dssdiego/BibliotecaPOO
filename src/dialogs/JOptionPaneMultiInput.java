package dialogs;

import database.ParseDataController;
import models.Book;
import models.Employee;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JOptionPaneMultiInput {

    /* Books */
    static JPanel bookPane;
    static JFrame bookFrame;

    static JTextField titleField;
    static JTextField authorField;
    static JTextField pagesField;
    static JTextField launchField;
    static JTextField categoryField;

    /* Employees */
    static JPanel employeePane;
    static JFrame employeeFrame;

    static JTextField nameField;
    static JTextField phoneField;

    private static void createBookFields() {
        bookFrame = new JFrame("");

        bookPane = new JPanel();
        bookPane.setLayout(new GridLayout(0, 2, 2, 2));

        titleField = new JTextField(10);
        authorField = new JTextField(10);
        pagesField = new JTextField(10);
        launchField = new JTextField(10);
        categoryField = new JTextField(10);

        bookPane.add(new JLabel("Título"));
        bookPane.add(titleField);

        bookPane.add(new JLabel("Autor"));
        bookPane.add(authorField);

        bookPane.add(new JLabel("Páginas"));
        bookPane.add(pagesField);

        bookPane.add(new JLabel("Categoria"));
        bookPane.add(categoryField);

        bookPane.add(new JLabel("Ano de Lançamento"));
        bookPane.add(launchField);

    }

    public static Boolean showInsertBookDialog() throws IOException {

        createBookFields();

        bookPane.add(new JLabel("Inserir Livro?"));

        int insertOption = JOptionPane.showConfirmDialog(bookFrame, bookPane, "Cadastro de Livros", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (insertOption == JOptionPane.YES_OPTION) {
            if (titleField.getText().equals("") || authorField.getText().equals("") ||
                    pagesField.getText().equals("") || launchField.getText().equals("") ||
                    categoryField.getText().equals("")) {
                JOptionPane.showMessageDialog(bookFrame, "É necessário preencher todos os campos!");
                return false;
            } else {
                return ParseDataController.insertBook(titleField.getText(),
                        authorField.getText(),
                        pagesField.getText(),
                        launchField.getText(),
                        categoryField.getText());
            }
        }

        return false;
    }

    public static Boolean showEditBookDialog(Book book) throws IOException {
        createBookFields();

        bookPane.add(new JLabel("Editar Livro?"));

        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        launchField.setText(String.valueOf(book.getLaunchYear()));
        categoryField.setText(book.getCategory());
        pagesField.setText(String.valueOf(book.getPages()));

        int editOption = JOptionPane.showConfirmDialog(bookFrame, bookPane, "Edição de Livro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (editOption == JOptionPane.YES_OPTION) {
            if (titleField.getText().equals("") || authorField.getText().equals("") ||
                    pagesField.getText().equals("") || launchField.getText().equals("") ||
                    categoryField.getText().equals("")) {
                JOptionPane.showMessageDialog(bookFrame, "É necessário preencher todos os campos!");
                return false;
            } else {
                return ParseDataController.editBook(book.getObjectId(),
                        titleField.getText(),
                        authorField.getText(),
                        pagesField.getText(),
                        launchField.getText(),
                        categoryField.getText());
            }
        }

        return false;
    }

    public static Boolean showDeleteBookDialog(Book book) throws IOException {
        int deleteOption = JOptionPane.showConfirmDialog(null, "Deseja deletar o Livro " + book.getTitle() + " (" + book.getAuthor() + ")", "Exclusão de Livro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (deleteOption == JOptionPane.YES_OPTION) {
            return ParseDataController.deleteBook(book.getObjectId());
        }

        return false;
    }

    private static void createEmployeeFields() {
        employeeFrame = new JFrame("");

        employeePane = new JPanel();
        employeePane.setLayout(new GridLayout(0, 2, 2, 2));

        nameField = new JTextField(10);
        phoneField = new JTextField(10);

        employeePane.add(new JLabel("Nome"));
        employeePane.add(nameField);

        employeePane.add(new JLabel("Telefone"));
        employeePane.add(phoneField);
    }

    public static Boolean showInsertEmployeeDialog() throws IOException {

        createEmployeeFields();

        employeePane.add(new JLabel("Inserir Funcionário?"));

        int insertOption = JOptionPane.showConfirmDialog(employeeFrame, employeePane, "Cadastro de Funcionários", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (insertOption == JOptionPane.YES_OPTION) {
            if (nameField.getText().equals("") || phoneField.getText().equals("")) {
                JOptionPane.showMessageDialog(employeeFrame, "É necessário preencher todos os campos!");
                return false;
            } else {
                return ParseDataController.insertEmployee(nameField.getText(),
                        phoneField.getText());
            }
        }

        return false;
    }

    public static Boolean showEditEmployeeDialog(Employee employee) throws IOException {

        createEmployeeFields();

        employeePane.add(new JLabel("Editar Funcionário?"));

        nameField.setText(employee.getName());
        phoneField.setText(employee.getPhone());

        int editOption = JOptionPane.showConfirmDialog(employeeFrame, employeePane, "Edição de Funcionário", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (editOption == JOptionPane.YES_OPTION) {
            if (nameField.getText().equals("") || phoneField.getText().equals("")) {
                JOptionPane.showMessageDialog(employeeFrame, "É necessário preencher todos os campos!");
                return false;
            } else {
                return ParseDataController.editEmployee(employee.getObjectId(),
                        nameField.getText(),
                        phoneField.getText());
            }
        }

        return false;
    }

    public static Boolean showDeleteEmployeeDialog(Employee employee) throws IOException {
        int deleteOption = JOptionPane.showConfirmDialog(null, "Deseja deletar o Funcionário " + "\"" + employee.getName() + "\"" + "?", "Exclusão de Funcionário", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (deleteOption == JOptionPane.YES_OPTION) {
            return ParseDataController.deleteEmployee(employee.getObjectId());
        }

        return false;
    }
}
