package dialogs;

import database.Parse;
import database.ParseDataController;
import main.App;
import models.Book;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JOptionPaneMultiInput {

    static JPanel pane;
    static JFrame frame;
    static JTextField titleField;
    static JTextField authorField;
    static JTextField pagesField;
    static JTextField launchField;
    static JTextField categoryField;

    static int codLivro = 0;

    private static void createBookFields() {
        frame = new JFrame("");

        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        titleField = new JTextField(10);
        authorField = new JTextField(10);
        pagesField = new JTextField(10);
        launchField = new JTextField(10);
        categoryField = new JTextField(10);

        pane.add(new JLabel("Título"));
        pane.add(titleField);

        pane.add(new JLabel("Autor"));
        pane.add(authorField);

        pane.add(new JLabel("Páginas"));
        pane.add(pagesField);

        pane.add(new JLabel("Categoria"));
        pane.add(categoryField);

        pane.add(new JLabel("Ano de Lançamento"));
        pane.add(launchField);

    }

    public static Boolean showInsertBookDialog() throws IOException {

        createBookFields();

        pane.add(new JLabel("Inserir Livro?"));

        int insertOption = JOptionPane.showConfirmDialog(frame, pane, "Cadastro de Livros", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (insertOption == JOptionPane.YES_OPTION) {
            if (titleField.getText().equals("") || authorField.getText().equals("") ||
                    pagesField.getText().equals("") || launchField.getText().equals("") ||
                    categoryField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "É necessário preencher todos os campos!");
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

        pane.add(new JLabel("Editar Livro?"));

        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        launchField.setText(String.valueOf(book.getLaunchYear()));
        categoryField.setText(book.getCategory());
        pagesField.setText(String.valueOf(book.getPages()));

        int editOption = JOptionPane.showConfirmDialog(frame, pane, "Edição de Livro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (editOption == JOptionPane.YES_OPTION) {
            if (titleField.getText().equals("") || authorField.getText().equals("") ||
                    pagesField.getText().equals("") || launchField.getText().equals("") ||
                    categoryField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "É necessário preencher todos os campos!");
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
}
