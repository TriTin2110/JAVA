import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View_Counter extends JFrame{
	public Counter countermodelCounter;
	private JButton jButtonUpButton;
	private JButton jButtonDownButton;
	private JLabel jButtonLabelButton;
	private JButton jButtonResButton;
	public View_Counter()
	{
		this.countermodelCounter = new Counter();
		this.init();
	}
	public void init() {
		this.setTitle("Đếm số");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		
		ActionListener actionListener = new Counter_Listener(this);
		jButtonUpButton = new JButton("Tăng");
		this.jButtonUpButton.addActionListener(actionListener);
		
		jButtonDownButton = new JButton("Giảm");
		this.jButtonDownButton.addActionListener(actionListener);
		jButtonLabelButton = new JLabel(this.countermodelCounter.getN()+"", JLabel.CENTER); 
		jButtonResButton = new JButton("Reset");
		this.jButtonResButton.addActionListener(actionListener);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButtonUpButton, BorderLayout.WEST);
		jPanel.add(jButtonLabelButton, BorderLayout.CENTER);
		jPanel.add(jButtonDownButton, BorderLayout.EAST);
		jPanel.add(jButtonResButton, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void tang()
	{
		this.countermodelCounter.Tang();
		this.jButtonLabelButton.setText(this.countermodelCounter.getN()+"");
	}
	public void giam()
	{
		this.countermodelCounter.Giam();
		this.jButtonLabelButton.setText(this.countermodelCounter.getN()+"");
	}
	public void reset()
	{
		this.countermodelCounter.Reset();
		this.jButtonLabelButton.setText(this.countermodelCounter.getN()+"");
	}
}
