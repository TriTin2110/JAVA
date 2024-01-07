package GiaoDien.XuLySuKienChuot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControllerXuLySuKienChuot implements MouseListener, MouseMotionListener {
	ViewXuLySuKienChuot viewXuLySuKienChuot;

	public ControllerXuLySuKienChuot(ViewXuLySuKienChuot viewXuLySuKienChuot) {
		this.viewXuLySuKienChuot = viewXuLySuKienChuot;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.viewXuLySuKienChuot.demSoLanClick();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.viewXuLySuKienChuot.xacDinhNamTrong("True");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.viewXuLySuKienChuot.xacDinhNamTrong("False");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		this.viewXuLySuKienChuot.xacDinhToaDo(e.getX(), e.getY());
	}

}
