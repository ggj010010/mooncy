package First;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.NumberFormat;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.SystemColor;

public class FirstScreen2 extends JFrame {
	private JPanel contentPane;

	int [] count =  {0,0,0,0,0,0,0,0,0,0,0,0};

	int [] price = {3000,2300,2300,3000,3700,4500,3000,2700,2500,3900,2700,3700};
	int [] sumPrice = {3000,2300,2300,3000,3700,4500,3000,2700,2500,3900,2700,3700};
	int allPrice=0;

	private JLabel tf1;	
	private JLabel tf2;
	private JLabel tf3;
	private JLabel tf4;
	private JLabel tf5;
	private JLabel tf6;
	private JLabel tf7;
	private JLabel tf8;
	private JLabel tf9;
	private JLabel tf10;
	private JLabel tf11;
	private JLabel tf12;

	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstScreen2 frame = new FirstScreen2();
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
	public FirstScreen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 704);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\uC7AC\uACE0");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("\uC7AC\uACE0\uBCF4\uAE30");
		mnNewMenu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(655, 539, 204, 74);
		contentPane.add(panel);

		JLabel all = new JLabel("\uCD1D   \uC561");
		all.setFont(new Font("굴림", Font.PLAIN, 53));
		panel.add(all);


		JLabel [] TextFrame = {tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12};
		
		JLabel tf2 = new JLabel("\uC624\uB80C\uC9C0 2.300");
		tf2.setBounds(108, 33, 121, 15);
		contentPane.add(tf2);
		
		JLabel tf3 = new JLabel("\uBC14\uB098\uB098 2.300");
		tf3.setBounds(213, 33, 121, 15);
		contentPane.add(tf3);
		
		JLabel tf4 = new JLabel("\uD0A4\uC6CC 3,000");
		tf4.setBounds(327, 30, 121, 15);
		contentPane.add(tf4);
		
		JLabel tf5 = new JLabel("\uD30C\uC778\uC560\uD50C 3,700");
		tf5.setBounds(12, 125, 121, 15);
		contentPane.add(tf5);
		
		JLabel tf6 = new JLabel("\uD55C\uB77C\uBD09 4,500");
		tf6.setBounds(125, 125, 121, 15);
		contentPane.add(tf6);
		
		JLabel tf7 = new JLabel("\uC218\uBC15 3,000");
		tf7.setBounds(234, 125, 121, 15);
		contentPane.add(tf7);
		
		JLabel tf8 = new JLabel("\uD1A0\uB9C8\uD1A0 2,700");
		tf8.setBounds(339, 125, 121, 15);
		contentPane.add(tf8);
		
		JLabel tf9 = new JLabel("\uC0AC\uACFC 2,500");
		tf9.setBounds(31, 237, 121, 15);
		contentPane.add(tf9);
		
		JLabel tf10 = new JLabel("\uB9DD\uACE0 3,900");
		tf10.setBounds(125, 237, 121, 15);
		contentPane.add(tf10);
		
		JLabel tf11 = new JLabel("\uB538\uBC14 2,700");
		tf11.setBounds(234, 237, 121, 15);
		contentPane.add(tf11);
		
		JLabel tf12 = new JLabel("\uC624\uD55C 3,700");
		tf12.setBounds(339, 237, 121, 15);
		contentPane.add(tf12);



		JButton btnNewButton = new JButton("+");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(tf1.getText());
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				//2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만 
				//삽입 삭제를 하기 위해 해당 방법을 사용합니다
				table = new JTable(m); //

				//3. 결과적으로는 JScrollPane를 추가합니다.
				JScrollPane sc = new JScrollPane(table);

				//4. 컴포넌트에  Table 추가
				getContentPane().add(sc);
				int flag=0;
				DecimalFormat format = new DecimalFormat("###,###");
				//테이블에 데이터 추가하기
				//원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
				//모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
				if(count[0]==0) {
					m.insertRow(0, new Object[] {tf1.getText().split(" ")[0], ++count[0],format.format(price[0])});
					allPrice += price[0];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf1.getText().split(" ")[0])) {
							m.setValueAt(++count[0], i, 1);
							sumPrice[0] += price[0];
							allPrice += price[0];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[0]),i,2);

							all.setText(format.format(allPrice));
							flag=1;
							break;
						}
					}
				}
				//추가를 마치고 데이터 갱신을 알립니다.
				table.updateUI();

			}
		});
		btnNewButton.setBounds(31, 69, 46, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[1]==0) {
					m.insertRow(0, new Object[] {tf2.getText().split(" ")[0], ++count[1],format.format(price[1])});
					allPrice += price[1];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf2.getText().split(" ")[0])) {
							m.setValueAt(++count[1], i, 1);
							sumPrice[1] += price[1];
							allPrice += price[1];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[1]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();

			}
		});
		btnNewButton_1.setBounds(138, 69, 46, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[2]==0) {
					m.insertRow(0, new Object[] {tf3.getText().split(" ")[0], ++count[2],format.format(price[2])});
					allPrice += price[2];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf3.getText().split(" ")[0])) {
							m.setValueAt(++count[2], i, 1);
							sumPrice[2] += price[2];
							allPrice += price[1];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[2]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_2.setBounds(234, 69, 46, 36);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[3]==0) {
					m.insertRow(0, new Object[] {tf4.getText().split(" ")[0], ++count[3],format.format(price[3])});
					allPrice += price[3];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf4.getText().split(" ")[0])) {
							m.setValueAt(++count[3], i, 1);
							sumPrice[3] += price[3];
							allPrice += price[3];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[3]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_3.setBounds(339, 69, 46, 36);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[4]==0) {
					m.insertRow(0, new Object[] {tf5.getText().split(" ")[0], ++count[4],format.format(price[4])});
					allPrice += price[4];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf5.getText().split(" ")[0])) {
							m.setValueAt(++count[4], i, 1);
							sumPrice[4] += price[4];
							allPrice += price[4];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[4]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_4.setBounds(31, 166, 46, 36);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("+");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[5]==0) {
					m.insertRow(0, new Object[] {tf6.getText().split(" ")[0], ++count[5],format.format(price[5])});
					allPrice += price[5];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf6.getText().split(" ")[0])) {
							m.setValueAt(++count[5], i, 1);
							sumPrice[5] += price[5];
							allPrice += price[5];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[5]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_5.setBounds(138, 166, 46, 36);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("+");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[6]==0) {
					m.insertRow(0, new Object[] {tf7.getText().split(" ")[0], ++count[6],format.format(price[6])});
					allPrice += price[6];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf7.getText().split(" ")[0])) {
							m.setValueAt(++count[6], i, 1);
							sumPrice[6] += price[6];
							allPrice += price[6];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[6]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_6.setBounds(234, 166, 46, 36);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("+");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[7]==0) {
					m.insertRow(0, new Object[] {tf8.getText().split(" ")[0], ++count[7],format.format(price[7])});
					allPrice += price[7];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf8.getText().split(" ")[0])) {
							m.setValueAt(++count[7], i, 1);
							sumPrice[7] += price[7];
							allPrice += price[7];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[7]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_7.setBounds(339, 166, 46, 36);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("+");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[8]==0) {
					m.insertRow(0, new Object[] {tf9.getText().split(" ")[0], ++count[8],format.format(price[8])});
					allPrice += price[8];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf9.getText().split(" ")[0])) {
							m.setValueAt(++count[8], i, 1);
							sumPrice[8] += price[8];
							allPrice += price[8];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[8]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_8.setBounds(31, 273, 46, 42);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("+");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[9]==0) {
					m.insertRow(0, new Object[] {tf10.getText().split(" ")[0], ++count[9],format.format(price[9])});
					allPrice += price[9];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf10.getText().split(" ")[0])) {
							m.setValueAt(++count[9], i, 1);
							sumPrice[9] += price[9];
							allPrice += price[9];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[9]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		btnNewButton_9.setBounds(138, 273, 46, 42);
		contentPane.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("\uCDE8\uC18C");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<TextFrame.length;i++) {


				}
			}
		});
		btnNewButton_10.setBounds(31, 342, 69, 74);
		contentPane.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("\uACC4\uC0B0");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_11.setBounds(138, 342, 69, 74);
		contentPane.add(btnNewButton_11);

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel m=(DefaultTableModel)table.getModel();
				//2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만 
				//삽입 삭제를 하기 위해 해당 방법을 사용합니다
				table = new JTable(m); //

				//3. 결과적으로는 JScrollPane를 추가합니다.
				JScrollPane sc = new JScrollPane(table);

				//4. 컴포넌트에  Table 추가
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				//테이블에 데이터 추가하기
				//원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
				//모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
				if(count[0]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf1.getText().split(" ")[0])) {
							System.out.println("i"+i);
						
							m.setValueAt(--count[0], i, 1);
							sumPrice[0] -= price[0];
							allPrice -= price[0];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[0]),i,2);

							all.setText(format.format(allPrice));
							table.updateUI();


						}
					}
				}else if(count[0]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf1.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[0];
							System.out.println(allPrice);
							count[0] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
				//추가를 마치고 데이터 갱신을 알립니다.
				

			}
		});
		button_1.setBounds(73, 69, 46, 36);
		contentPane.add(button_1);

		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[1]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf2.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[1], i, 1);
							sumPrice[1] -= price[1];
							allPrice -= price[1];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[1]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[1]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf2.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[1];
							System.out.println(allPrice);
							count[1] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_2.setBounds(183, 69, 46, 36);
		contentPane.add(button_2);

		JButton button_3 = new JButton("-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[2]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf3.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[2], i, 1);
							sumPrice[2] -= price[2];
							allPrice -= price[2];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[2]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[2]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf3.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[2];
							System.out.println(allPrice);
							count[2] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_3.setBounds(277, 69, 46, 36);
		contentPane.add(button_3);

		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[3]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf4.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[3], i, 1);
							sumPrice[3] -= price[3];
							allPrice -= price[3];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[3]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[2]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf4.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[3];
							System.out.println(allPrice);
							count[3] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_4.setBounds(379, 69, 46, 36);
		contentPane.add(button_4);

		JButton button_5 = new JButton("-");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[4]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf5.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[4], i, 1);
							sumPrice[4] -= price[4];
							allPrice -= price[4];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[4]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[4]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf5.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[4];
							System.out.println(allPrice);
							count[4] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_5.setBounds(73, 166, 46, 36);
		contentPane.add(button_5);

		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[5]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf6.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[5], i, 1);
							sumPrice[5] -= price[5];
							allPrice -= price[5];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[5]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[5]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf6.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[5];
							System.out.println(allPrice);
							count[5] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_6.setBounds(179, 166, 46, 36);
		contentPane.add(button_6);

		JButton button_7 = new JButton("-");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[6]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf7.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[6], i, 1);
							sumPrice[6] -= price[6];
							allPrice -= price[6];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[6]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[6]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf7.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[6];
							System.out.println(allPrice);
							count[6] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_7.setBounds(277, 166, 46, 36);
		contentPane.add(button_7);

		JButton button_8 = new JButton("-");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[7]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf8.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[7], i, 1);
							sumPrice[7] -= price[7];
							allPrice -= price[7];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[7]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[7]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf8.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[7];
							System.out.println(allPrice);
							count[7] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_8.setBounds(379, 166, 46, 36);
		contentPane.add(button_8);

		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[8]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf9.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[8], i, 1);
							sumPrice[8] -= price[8];
							allPrice -= price[8];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[8]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[8]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf9.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[8];
							System.out.println(allPrice);
							count[8] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_9.setBounds(73, 273, 46, 42);
		contentPane.add(button_9);

		JButton button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[9]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf10.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[9], i, 1);
							sumPrice[9] -= price[9];
							allPrice -= price[9];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[9]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[9]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf10.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[9];
							System.out.println(allPrice);
							count[9] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_10.setBounds(183, 273, 46, 42);
		contentPane.add(button_10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(655, 23, 204, 490);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("굴림", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\uC74C   \uB8CC", "\uC218   \uB7C9", "\uAC00   \uACA9"
				}
				));
		scrollPane.setViewportView(table);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[10]==0) {
					m.insertRow(0, new Object[] {tf11.getText().split(" ")[0], ++count[10],format.format(price[10])});
					allPrice += price[10];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf11.getText().split(" ")[0])) {
							m.setValueAt(++count[10], i, 1);
							sumPrice[10] += price[10];
							allPrice += price[10];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[10]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		button.setBounds(241, 273, 46, 42);
		contentPane.add(button);

		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[10]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf11.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[10], i, 1);
							sumPrice[10] -= price[10];
							allPrice -= price[10];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[10]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[10]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf11.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[10];
							System.out.println(allPrice);
							count[10] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_11.setBounds(286, 273, 46, 42);
		contentPane.add(button_11);

		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(count[11]==0) {
					m.insertRow(0, new Object[] {tf12.getText().split(" ")[0], ++count[11],format.format(price[11])});
					allPrice += price[11];
					all.setText(format.format(allPrice));
				}else {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf12.getText().split(" ")[0])) {
							m.setValueAt(++count[11], i, 1);
							sumPrice[11] += price[11];
							allPrice += price[11];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[11]),i,2);
							all.setText(format.format(allPrice));
							break;
						}
					}
				}
				table.updateUI();
			}
		});
		button_12.setBounds(339, 273, 46, 42);
		contentPane.add(button_12);

		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);
				DecimalFormat format = new DecimalFormat("###,###");
				if(count[11]>1) {
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf12.getText().split(" ")[0])) {
							System.out.println("i"+i);	
							m.setValueAt(--count[11], i, 1);
							sumPrice[11] -= price[11];
							allPrice -= price[11];
							System.out.println(allPrice);
							m.setValueAt(format.format(sumPrice[11]),i,2);
							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}else if(count[11]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf12.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[11];
							System.out.println(allPrice);
							count[11] = 0;

							all.setText(format.format(allPrice));
							table.updateUI();
						}
					}
				}
			}
		});
		button_13.setBounds(384, 273, 46, 42);
		contentPane.add(button_13);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(482, 192, 104, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel tf1 = new JLabel("\uB538\uAE30 3,000");
		tf1.setBounds(25, 81, 56, 15);
		panel_1.add(tf1);
		



	}
	public void PriceALL( JTextField [] TextFrame) {

	}
}