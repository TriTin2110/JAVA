package Window.ShowInfoWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ModelAuthor;

public class ShowAuthor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShowAuthor(ModelAuthor modelAuthor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panelAuthorId = new JPanel();
		mainPanel.add(panelAuthorId);
		panelAuthorId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorId = new JLabel("Mã tác giả:");
		lblAuthorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorId.add(lblAuthorId);

		JLabel lblAuthorIdResult = new JLabel(modelAuthor.getId());
		lblAuthorIdResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorId.add(lblAuthorIdResult);

		JPanel panelAuthorName = new JPanel();
		mainPanel.add(panelAuthorName);
		panelAuthorName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorName = new JLabel("Tên tác giả:");
		lblAuthorName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorName.add(lblAuthorName);

		JLabel lblAuthorNameResult = new JLabel(modelAuthor.getName());
		lblAuthorNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorName.add(lblAuthorNameResult);

		JPanel panelAuthorAge = new JPanel();
		mainPanel.add(panelAuthorAge);
		panelAuthorAge.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorAge = new JLabel("Tuổi tác giả:");
		lblAuthorAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorAge.add(lblAuthorAge);

		JLabel lblAuthorAgeResult = new JLabel(modelAuthor.getAge() + "");
		lblAuthorAgeResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorAge.add(lblAuthorAgeResult);

		JPanel panelAuthorPhone = new JPanel();
		mainPanel.add(panelAuthorPhone);
		panelAuthorPhone.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorPhone = new JLabel("Số điện thoại tác giả:");
		lblAuthorPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorPhone.add(lblAuthorPhone);

		JLabel lblAuthorPhoneResult = new JLabel(modelAuthor.getPhone());
		lblAuthorPhoneResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorPhone.add(lblAuthorPhoneResult);

		JPanel panelAuthorCountry = new JPanel();
		mainPanel.add(panelAuthorCountry);
		panelAuthorCountry.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorCountry = new JLabel("Quốc gia tác giả:");
		lblAuthorCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorCountry.add(lblAuthorCountry);

		JLabel lblAuthorCountryResult = new JLabel(modelAuthor.getCountry());
		lblAuthorCountryResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorCountry.add(lblAuthorCountryResult);

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
		this.setTitle("Thông tin chi tiết của tác giả!");
	}

}