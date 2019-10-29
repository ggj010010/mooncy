package First;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField IDText;
	private JTextField PWText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDText = new JTextField();
		IDText.setBounds(201, 165, 116, 21);
		contentPane.add(IDText);
		IDText.setColumns(10);
		
		PWText = new JTextField();
		PWText.setBounds(201, 212, 116, 21);
		contentPane.add(PWText);
		PWText.setColumns(10);
		
		



		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = "";
				String Pw="";
				 ID = IDText.getText();
				 Pw = PWText.getText();

				LoginDAO Logindao = new LoginDAO();
				int check = Logindao.select2(ID, Pw);
				if(check==1) {
					dispose();
					}
			}
		});
		btnNewButton.setBounds(332, 164, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ID,PW\uBD84\uC2E4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "본사에 문의해주세요.\n본사번호 : 010-8991-3464", "분실 메시지", JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnNewButton_1.setBounds(332, 211, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("MoonCy");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(221, 80, 163, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(168, 168, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setBounds(168, 215, 57, 15);
		contentPane.add(lblNewLabel_2);
	}
}
