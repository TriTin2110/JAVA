package GiaoDien.BarMenu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewMenu extends JFrame {
	JLabel jLabel = new JLabel("", JLabel.CENTER);

	public ViewMenu() {
		// TODO Auto-generated constructor stub
		this.init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("Thử nghiệm menu!");
		this.setSize(800, 600);
		this.setLocale(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		ControllerMenu controllerMenu = new ControllerMenu(this);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenuFile = new JMenu("Tập tin");
		JMenuItem jMenuMo = new JMenuItem("Mở");
		jMenuMo.addActionListener(controllerMenu);
		JMenuItem jMenuThoat = new JMenuItem("Thoát");
		jMenuThoat.addActionListener(controllerMenu);
		jMenuFile.add(jMenuMo);
		jMenuFile.add(jMenuThoat);

		JMenu jMenuHelp = new JMenu("Trợ giúp");
		JMenuItem jMenuItemXinChao = new JMenuItem("Giới thiệu");
		jMenuItemXinChao.addActionListener(controllerMenu);
		jMenuHelp.add(jMenuItemXinChao);

		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuHelp);
		this.add(jMenuBar, BorderLayout.NORTH);
		this.add(jLabel, BorderLayout.CENTER);
	}

	void xuLyLuaChon(String luaChon) {
		this.jLabel.setText(luaChon);
	}
}
