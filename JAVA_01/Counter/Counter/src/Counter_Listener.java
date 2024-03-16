import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter_Listener implements ActionListener {
    private Counter_Viewer ctv;

    public Counter_Listener(Counter_Viewer ctv) {
        this.ctv = ctv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String cString = e.getActionCommand();
        if (cString == "Tăng") {
            ctv.Tang();
        } else if (cString == "Giảm") {
            ctv.Giam();
        } else {
            ctv.Reset();
        }
    }

}
