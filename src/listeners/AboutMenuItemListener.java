package listeners;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class AboutMenuItemListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        JOptionPane.showMessageDialog(null, "Aplicativo criado por\n\nDiego S. Seabra\ne\nFabrício Augusto Miranda dos Santos");
    }

    @Override
    public void menuDeselected(MenuEvent e) { }

    @Override
    public void menuCanceled(MenuEvent e) { }
}
