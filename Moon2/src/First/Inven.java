package First;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class Inven extends JFrame {

	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_10;
	DefaultTableModel model = new DefaultTableModel();
	   String Date, Year, Month, Day, Time, Time2;
	   Vector data = new Vector<>();
	    Vector columnNames = new Vector<>();

	   private JTable table;

	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				
//				
//				
//				try {
//					Inven frame = new Inven();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Inven(int x, int y,String ID) {
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(x, y, 441, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 10, 223, 412);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\uB538        \uAE30");
		panel.add(label);
		
		textField_0 = new JTextField();
		textField_0.setText("0");
		textField_0.setColumns(10);
		panel.add(textField_0);
		
		JLabel label_1 = new JLabel("\uC624   \uB80C   \uC9C0");
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("\uBC14   \uB098   \uB098");
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("\uD0A4        \uC704");
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("\uD30C \uC778 \uC560 \uD50C");
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JLabel label_5 = new JLabel("\uD55C   \uB77C   \uBD09");
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		JLabel label_6 = new JLabel("\uC218        \uBC15");
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		JLabel label_7 = new JLabel("\uD1A0   \uB9C8   \uD1A0");
		panel.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setColumns(10);
		panel.add(textField_7);
		
		JLabel label_8 = new JLabel("\uC0AC        \uACFC");
		panel.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		JLabel label_9 = new JLabel("\uB9DD        \uACE0");
		panel.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setColumns(10);
		panel.add(textField_9);
		
		JLabel label_13 = new JLabel("\uC5BC         \uC74C");
		panel.add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setColumns(10);
		panel.add(textField_10);
		
		JLabel label_10 = new JLabel("\uBE68         \uB300");
		panel.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setColumns(10);
		panel.add(textField_11);
		
		JLabel label_11 = new JLabel("\uB69C         \uAED1");
		panel.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setColumns(10);
		panel.add(textField_12);
		
		JLabel label_12 = new JLabel("            \uCEF5");
		panel.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setColumns(10);
		panel.add(textField_13);
		
		//DB
		 DAO dao = new DAO();
         ArrayList<DTO> b = dao.select2(ID);
         
         for (DTO beans : b) {
        	 textField_0.setText(Integer.toString(beans.ddalgi));
        	 textField_1.setText(Integer.toString(beans.orange));
        	 textField_2.setText(Integer.toString(beans.banana));
        	 textField_3.setText(Integer.toString(beans.kiwi));
        	 textField_4.setText(Integer.toString(beans.pine));
        	 textField_5.setText(Integer.toString(beans.hanla));
        	 textField_6.setText(Integer.toString(beans.suback));
        	 textField_7.setText(Integer.toString(beans.tomato));
        	 textField_8.setText(Integer.toString(beans.apple));
        	 textField_9.setText(Integer.toString(beans.mango));
        	 textField_10.setText(Integer.toString(beans.ice));
        	 textField_11.setText(Integer.toString(beans.bbalde));
        	 textField_12.setText(Integer.toString(beans.dduggung));
        	 textField_13.setText(Integer.toString(beans.cup));

             System.out.println(beans.banana);
           
          }
         setVisible(true);
	}
	
}
