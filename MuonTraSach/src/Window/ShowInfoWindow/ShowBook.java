package Window.ShowInfoWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ModelBook;
import MyClass.SetAttribute;

public class ShowBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShowBook(ModelBook modelBook) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panelBookId = new JPanel();
		mainPanel.add(panelBookId);
		panelBookId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookId = new JLabel("Mã sách:");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookId.add(lblBookId);

		JLabel lblBookIdResult = new JLabel(modelBook.getIdBook());
		lblBookIdResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookId.add(lblBookIdResult);

		JPanel panelBookName = new JPanel();
		mainPanel.add(panelBookName);
		panelBookName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookName = new JLabel("Tên sách:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookName.add(lblBookName);

		JLabel lblBookNameResult = new JLabel(modelBook.getNameBook());
		lblBookNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookName.add(lblBookNameResult);

		JPanel panelBookKind = new JPanel();
		mainPanel.add(panelBookKind);
		panelBookKind.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookKind = new JLabel("Thể loại:");
		lblBookKind.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookKind.add(lblBookKind);

		JLabel lblBookKindResult = new JLabel(modelBook.getKindOfBook());
		lblBookKindResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookKind.add(lblBookKindResult);

		JPanel panelAuthorId = new JPanel();
		mainPanel.add(panelAuthorId);
		panelAuthorId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorID = new JLabel("Mã tác giả");
		lblAuthorID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorId.add(lblAuthorID);

		JLabel lblAuthorIdResult = new JLabel(modelBook.getAuthorID());
		lblAuthorIdResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorId.add(lblAuthorIdResult);

		JPanel panelStatus = new JPanel();
		mainPanel.add(panelStatus);
		panelStatus.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStatus = new JLabel("Trạng thái");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStatus.add(lblStatus);

		String status = modelBook.getStatus();
		JLabel lblStatusResult = new JLabel(status);
		lblStatusResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatusResult.setForeground(SetAttribute.setColor(status));
		panelStatus.add(lblStatusResult);

		JPanel panelQuantity = new JPanel();
		mainPanel.add(panelQuantity);
		panelQuantity.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblQuantity = new JLabel("Số lượng");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelQuantity.add(lblQuantity);

		JLabel lblQuantityResult = new JLabel(modelBook.getQuantity() + "");
		lblQuantityResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelQuantity.add(lblQuantityResult);

		JPanel panelPublicDay = new JPanel();
		mainPanel.add(panelPublicDay);
		panelPublicDay.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPublicDay = new JLabel("Ngày phát hành");
		lblPublicDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPublicDay.add(lblPublicDay);

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		JLabel lblPublicDayResult = new JLabel(df.format(modelBook.getPublicDay()));
		lblPublicDayResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPublicDay.add(lblPublicDayResult);

		JPanel panelSubmit = new JPanel();
		mainPanel.add(panelSubmit);
		panelSubmit.setLayout(new BoxLayout(panelSubmit, BoxLayout.X_AXIS));

		JButton btnSubmit = new JButton("OK");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSubmit.add(btnSubmit);

		// Đóng cửa sổ này khi người dùng ấn chọn nút Ok
		btnSubmit.addActionListener(e -> {
			this.dispose();
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Thông tin chi tiết của sách!");
	}

}