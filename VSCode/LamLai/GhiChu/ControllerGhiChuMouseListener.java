package GhiChu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerGhiChuMouseListener implements MouseListener {
        ViewGhiChu viewGhiChu;

        public ControllerGhiChuMouseListener(ViewGhiChu viewGhiChu) {
                this.viewGhiChu = viewGhiChu;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
        }

        @Override
        public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.isPopupTrigger()) {
                        this.viewGhiChu.jPopupMenu.show(this.viewGhiChu.jTextArea, e.getX(), e.getY());
                }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.isPopupTrigger()) {
                        this.viewGhiChu.jPopupMenu.show(this.viewGhiChu.jTextArea, e.getX(), e.getY());
                }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
        }

        @Override
        public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
        }

}
