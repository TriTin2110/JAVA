import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter_Listener implements ActionListener{
	private View_Counter vct;

	public Counter_Listener(View_Counter vct)
	{
		this.vct = vct;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String vctString = e.getActionCommand();
		if(vctString == "Tăng")
		{
			vct.tang();
		}
		else if(vctString == "Giảm"){
			vct.giam();
		}
		else {
			vct.reset();
		}
	}
	
}
