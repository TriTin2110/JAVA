package model;

import java.util.LinkedList;

public class QLX_Model {
	private LinkedList<NguoiGui> dsnguoiGui;
	public QLX_Model()
	{
		this.dsnguoiGui = new LinkedList<NguoiGui>();
	}
	public LinkedList<NguoiGui> getNguoiGui() {
		return dsnguoiGui;
	}
	public void setNguoiGui(LinkedList<NguoiGui> nguoiGui) {
		this.dsnguoiGui = nguoiGui;
	}
	public QLX_Model(LinkedList<NguoiGui> nguoiGui) {
		this.dsnguoiGui = nguoiGui;
	}
	public void Them(NguoiGui nguoiGui)
	{
		dsnguoiGui.add(nguoiGui);
	}
	public void Xoa(NguoiGui nguoiGui)
	{
		dsnguoiGui.remove(nguoiGui);
	}
	public void Edit(NguoiGui nguoiGui)
	{
		dsnguoiGui.remove(nguoiGui);
		dsnguoiGui.add(nguoiGui);
	}
}
