package GhiChu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainGhiChu {
        public static void main(String[] args) {
                try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        new ViewGhiChu();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}
