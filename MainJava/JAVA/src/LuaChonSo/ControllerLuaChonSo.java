package LuaChonSo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControllerLuaChonSo implements ActionListener {
	ViewLuaChon viewLuaChon;

	public ControllerLuaChonSo(ViewLuaChon viewLuaChon) {
		this.viewLuaChon = viewLuaChon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		this.viewLuaChon.inLuaChon(luaChon);
	}

}
