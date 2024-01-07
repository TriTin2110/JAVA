package Model;

import java.util.LinkedList;

public class QLXModel {
	private LinkedList<NguoiGui> nGui = new LinkedList<>();
	public QLXModel() {
		// TODO Auto-generated constructor stub
		this.nGui = new LinkedList<NguoiGui>();
	}
	public LinkedList<NguoiGui> getnGui() {
		return nGui;
	}
	public void setnGui(LinkedList<NguoiGui> nGui) {
		this.nGui = nGui;
	}
	public QLXModel(LinkedList<NguoiGui> nGui)
	{
		this.nGui = nGui;
	}
	public void insert(NguoiGui nguoiGui)
	{
		this.nGui.add(nguoiGui);
	}
	public void remove(NguoiGui nguoiGui)
	{
		this.nGui.remove(nguoiGui);
	}
	public void edit(NguoiGui nguoiGui)
	{
		this.nGui.remove(nguoiGui);
		this.nGui.add(nguoiGui);
	}
}
