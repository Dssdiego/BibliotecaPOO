import database.Parse;
import listeners.AboutMenuItemListener;
import resources.Dimens;
import resources.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;

public class MainScreen extends JFrame implements ActionListener, KeyListener {
    JMenuBar menuBar;
    JMenu file, newFile, consultFile, about;
    JMenuItem bookItem, employeeItem, exitItem;
    JLabel lblCode = new JLabel("<html><h1 align='center'>Gerenciador de Biblioteca</h1></html>");

    public static void main(String[] args) throws IOException {
//        MainScreen fr = new MainScreen();
//        fr.setVisible(true);

        JSONObject obj = new JSONObject();

        obj.put("nome", "X-Tudão");

        Parse.editObject("Estoque", obj.toJSONString(), "aZvVjc4QZN");
//        Parse.postObject("Estoque", obj.toJSONString());
    }

    private MainScreen() {
        setLayout(new FlowLayout());
        setSize(Dimens.window_width,Dimens.window_height);
        setTitle(Strings.title_app);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(this);

        createMenu();
    }

    private void createMenu() {
        menuBar = new JMenuBar();

        file = new JMenu(Strings.menu_file);
//        file.addMenuListener(new MenuItemListener());
        menuBar.add(file);

        newFile = new JMenu(Strings.menu_new);
        file.add(newFile);

        bookItem = new JMenuItem(new AbstractAction(Strings.menu_book) {
            public void actionPerformed(ActionEvent e) {
                System.out.println("New Book Action");
            }
        });
        newFile.add(bookItem);

        employeeItem = new JMenuItem("Funcionário");
        newFile.add(employeeItem);

        consultFile = new JMenu("Consultar");
        file.add(consultFile);

        bookItem = new JMenuItem("Livro");
        consultFile.add(bookItem);

        employeeItem = new JMenuItem("Funcionário");
        consultFile.add(employeeItem);

        exitItem = new JMenuItem("Sair");
        exitItem = new JMenuItem(new AbstractAction(Strings.menu_exit) {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        file.add(exitItem);

        about = new JMenu(Strings.menu_about);
        about.addMenuListener(new AboutMenuItemListener());
        menuBar.add(about);

        this.setJMenuBar(menuBar);
    }

    private void exit() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
