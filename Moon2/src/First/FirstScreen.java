package First;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;

import First.Inven;


public class FirstScreen extends JFrame {
	private JPanel contentPane;

	int [] count =  {0,0,0,0,0,0,0,0,0,0,0,0};
	int [] cnt =  {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int menu_flag[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int [] price = {3000,2300,2300,3000,3700,4500,3000,2700,2500,3900,2700,3700};
	int [] sumPrice = {3000,2300,2300,3000,3700,4500,3000,2700,2500,3900,2700,3700};
	int allPrice=0;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField tf9;
	private JTextField tf10;
	private JTextField tf11;
	private JTextField tf12;
	ArrayList<DTO> b;
	private JTable table;
	Object [][] product;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					FirstScreen frame = new FirstScreen();
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
	public FirstScreen(String ID) {
		DAO dao = new DAO();
		b = dao.select2(ID);

		for (DTO beans : b) {
			cnt[0] = beans.ddalgi;
			cnt[1] =  beans.orange;
			cnt[2] =  beans.banana;
			cnt[3] =  beans.kiwi;
			cnt[4] =  beans.pine;
			cnt[5] =  beans.hanla;
			cnt[6] =  beans.suback;
			cnt[7] =  beans.tomato;
			cnt[8] =  beans.apple;
			cnt[9] =  beans.mango;
			cnt[10] =  beans.ice;
			cnt[11] =  beans.bbalde;
			cnt[12] =  beans.dduggung;
			cnt[13] =  beans.cup;

		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 498);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\uC7AC\uACE0");
		menuBar.add(mnNewMenu);



		JMenuItem menuItem = new JMenuItem("\uC7AC\uACE0\uBCF4\uAE30");
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Inven(getX()+724, getY(),ID);            
			}

		});

		mnNewMenu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(460, 342, 204, 74);
		contentPane.add(panel);

		JLabel all = new JLabel("\uCD1D   \uC561");
		all.setFont(new Font("굴림", Font.PLAIN, 53));
		panel.add(all);

		tf1 = new JTextField();
		tf1.setForeground(Color.WHITE);
		tf1.setCaretColor(Color.BLACK);
		tf1.setBackground(Color.RED);
		tf1.setBounds(38, 23, 69, 36);
		contentPane.add(tf1);
		tf1.setColumns(10);
		tf1.setText("\uB538\uAE30 3,000");

		tf2 = new JTextField();
		tf2.setForeground(Color.DARK_GRAY);
		tf2.setBackground(Color.ORANGE);
		tf2.setColumns(10);
		tf2.setBounds(136, 23, 78, 36);
		tf2.setText("\uC624\uB80C\uC9C0 2,300");
		contentPane.add(tf2);

		tf3 = new JTextField();
		tf3.setDisabledTextColor(Color.WHITE);
		tf3.setForeground(Color.GRAY);
		tf3.setBackground(Color.YELLOW);
		tf3.setColumns(10);
		tf3.setBounds(226, 23, 84, 36);
		tf3.setText("\uBC14\uB098\uB098 2,300");
		contentPane.add(tf3);

		tf4 = new JTextField();
		tf4.setForeground(Color.DARK_GRAY);
		tf4.setBackground(Color.GREEN);
		tf4.setColumns(10);
		tf4.setBounds(346, 23, 69, 36);
		tf4.setText("\uD0A4\uC704 3,000");
		contentPane.add(tf4);

		tf5 = new JTextField();
		tf5.setForeground(Color.GRAY);
		tf5.setBackground(Color.CYAN);
		tf5.setColumns(10);
		tf5.setBounds(24, 115, 95, 36);
		tf5.setText("\uD30C\uC778\uC560\uD50C 3,700");
		contentPane.add(tf5);

		tf6 = new JTextField();
		tf6.setForeground(Color.WHITE);
		tf6.setBackground(Color.BLUE);
		tf6.setColumns(10);
		tf6.setBounds(136, 115, 78, 36);
		tf6.setText("\uD55C\uB77C\uBD09 4,500");
		contentPane.add(tf6);

		tf7 = new JTextField();
		tf7.setForeground(Color.WHITE);
		tf7.setBackground(Color.MAGENTA);
		tf7.setColumns(10);
		tf7.setBounds(241, 115, 69, 36);
		tf7.setText("\uC218\uBC15 3,000");
		contentPane.add(tf7);

		tf8 = new JTextField();
		tf8.setForeground(Color.WHITE);
		tf8.setBackground(Color.PINK);
		tf8.setColumns(10);
		tf8.setBounds(337, 115, 78, 36);
		tf8.setText("\uD1A0\uB9C8\uD1A0 2,700");
		contentPane.add(tf8);

		tf9 = new JTextField();
		tf9.setForeground(Color.WHITE);
		tf9.setBackground(Color.LIGHT_GRAY);
		tf9.setColumns(10);
		tf9.setBounds(38, 227, 69, 36);
		tf9.setText("\uC0AC\uACFC 2,500");
		contentPane.add(tf9);

		tf10 = new JTextField();
		tf10.setForeground(Color.WHITE);
		tf10.setBackground(Color.DARK_GRAY);
		tf10.setColumns(10);
		tf10.setBounds(145, 227, 69, 36);
		tf10.setText("\uB9DD\uACE0 3,900");
		contentPane.add(tf10);


		JTextField [] TextFrame = {tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12};




		JButton btnNewButton = new JButton("+");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				if(cnt[10]-1>= 0) {
					if(cnt[0]-2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[0] = cnt[0] - 2;
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
									b = dao.select2(ID);

									break;
								}
							}
						}
						//추가를 마치고 데이터 갱신을 알립니다.
						table.updateUI();

					}
					else {
						JOptionPane.showMessageDialog(null, "딸기의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[1] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[1] = cnt[1] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "오렌지의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				System.out.println("con"+count[2]);
				if(cnt[10]-1>= 0) {
					if(cnt[2]-2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[2] = cnt[2] - 2;
						System.out.println("aa"+cnt[2]);
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
					else {
						JOptionPane.showMessageDialog(null, "바나나의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[3] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[3] = cnt[3] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "키위의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[4] - 2 >=0) {
						cnt[10] = cnt[10] - 1;
						cnt[4] = cnt[4] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "파인애플의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[5] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[5] = cnt[5] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "한라봉의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[6] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[6] = cnt[6] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "수박의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[7] -2 >= 0) {
						cnt[10] = cnt[10] - 1;
						cnt[7] = cnt[7] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "토마토의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[8] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[8] = cnt[8] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "사과의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
				if(cnt[10]-1>= 0) {
					if(cnt[9] -2>=0) {
						cnt[10] = cnt[10] - 1;
						cnt[9] = cnt[9] - 2;
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
									b = dao.select2(ID);
									break;
								}
							}
						}
						table.updateUI();
					}
					else {
						JOptionPane.showMessageDialog(null, "망고의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_9.setBounds(138, 273, 46, 42);
		contentPane.add(btnNewButton_9);
		//취소
		JButton btnNewButton_10 = new JButton("\uCDE8\uC18C");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				m.setNumRows(0);
				all.setText("총   액");
				for(int i=0;i<12;i++) {
					sumPrice[i]=0;

					count[i]=0;
				}
				allPrice=0;
				b = dao.select2(ID);
				for (DTO beans : b) {
					cnt[0] = beans.ddalgi;
					cnt[1] =  beans.orange;
					cnt[2] =  beans.banana;
					cnt[3] =  beans.kiwi;
					cnt[4] =  beans.pine;
					cnt[5] =  beans.hanla;
					cnt[6] =  beans.suback;
					cnt[7] =  beans.tomato;
					cnt[8] =  beans.apple;
					cnt[9] =  beans.mango;
					cnt[10] =  beans.ice;
					cnt[11] =  beans.bbalde;
					cnt[12] =  beans.dduggung;
					cnt[13] =  beans.cup;

				}
			}
		});
		btnNewButton_10.setBounds(31, 342, 69, 74);
		contentPane.add(btnNewButton_10);

		//계산
		JButton btnNewButton_11 = new JButton("\uACC4\uC0B0");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				if(all.getText()=="총   액") {
					JOptionPane.showMessageDialog(null, "메뉴를 추가후 결제해주세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);


				}
				if(all.getText()!="총   액") {
					result = JOptionPane.showConfirmDialog(null, all.getText()+"원입니다. \n계산하시겟습니까?","계산 메시지", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);



					if(result==0) {

						DefaultTableModel m=(DefaultTableModel)table.getModel();


						int nRow = m.getRowCount();

						String [] sale = new String[nRow];
						for(int i = 0; i < nRow; i++) {
							sale[i] = m.getValueAt(i, 0)+","+m.getValueAt(i, 1);
							System.out.println(sale[i]);

							String sp1 = m.getValueAt(i, 2).toString().split(",")[0];
							String sp2 = m.getValueAt(i, 2).toString().split(",")[1];
							String sp3 = sp1+sp2;
							int money = Integer.parseInt(sp3);
							//판매 테이블에 입력
							dao.insert_sale(ID, m.getValueAt(i, 0).toString(), money, Integer.parseInt(m.getValueAt(i, 1).toString()));
						}
						dao.Update(sale,ID);
						all.setText("총   액");
						m.setNumRows(0);
						for(int i=0;i<12;i++) {
							sumPrice[i]=0;

							count[i]=0;
						}
						allPrice=0;
					}
					else if (result==1) {

					}
				}


				//				table = new JTable(m); //
				//				JScrollPane sc = new JScrollPane(table);
				//				getContentPane().add(sc);
				b = dao.select2(ID);
				for (DTO beans : b) {
					cnt[0] = beans.ddalgi;
					cnt[1] =  beans.orange;
					cnt[2] =  beans.banana;
					cnt[3] =  beans.kiwi;
					cnt[4] =  beans.pine;
					cnt[5] =  beans.hanla;
					cnt[6] =  beans.suback;
					cnt[7] =  beans.tomato;
					cnt[8] =  beans.apple;
					cnt[9] =  beans.mango;
					cnt[10] =  beans.ice;
					cnt[11] =  beans.bbalde;
					cnt[12] =  beans.dduggung;
					cnt[13] =  beans.cup;

				}

				/*
				 * cnt[0] = beans.ddalgi; cnt[1] = beans.orange; cnt[2] = beans.banana; cnt[3] =
				 * beans.kiwi; cnt[4] = beans.pine; cnt[5] = beans.hanla; cnt[6] = beans.suback;
				 * cnt[7] = beans.tomato; cnt[8] = beans.apple; cnt[9] = beans.mango; cnt[10] =
				 * beans.ice; cnt[11] = beans.bbalde; cnt[12] = beans.dduggung; cnt[13] =
				 * beans.cup;
				 */
				String menu[] = new String[15];
				menu[0] = "딸기"; menu[1] = "오렌지"; menu[2] = "바나나"; menu[3] = "키위"; menu[4] = "파인애플";
				menu[5] = "한라봉"; menu[6] = "수박"; menu[7] = "토마토"; menu[8] = "사과"; menu[9] = "망고";
				menu[10] = "얼음, 뚜껑, 빨대, 컵";

				
				for(int i = 0; i < cnt.length-4; i++) {
					
					if(cnt[i] < 11 ) {
						int check = dao.order_select(ID, menu[i]);
							if(check == 1) {
								
							}
							else {
								boolean a = true;
								while(a) {
									String m = JOptionPane.showInputDialog(null, menu[i]+"의 제고가 10개 이하입니다.제고를 요청하시겠습니까?(개수)", 
											"제고요청", JOptionPane.QUESTION_MESSAGE);

									System.out.println(m);
									if(m == null) {
										a = false;
									}
									else if(m.equals("") || m.equals("0")) {
										JOptionPane.showMessageDialog(null, "개수를 다시 입력해주세요", "경고 메시지", JOptionPane.WARNING_MESSAGE);
										a = true;
									}
									else {

										dao.insert_order(ID, menu[i], Integer.parseInt(m));
										menu_flag[i] = 1;
										System.out.println(menu_flag[i]);
										a = false;
									}
								}
							}
							
						
					}
					else {
						menu_flag[i] = 0;
					}
				}


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

							cnt[0] = cnt[0] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[0] = cnt[0] + 2;
							cnt[10] = cnt[10] + 1;
							break;
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
							cnt[1] = cnt[1] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[1] = cnt[1] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[2] = cnt[2] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[2] = cnt[2] + 2;
							cnt[10] = cnt[10] + 1;
							break;
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
							cnt[3] = cnt[3] + 2;
							cnt[10] = cnt[10] + 1;
						}
					}
				}else if(count[3]==1){
					int nRow = m.getRowCount(), nCol = m.getColumnCount();
					for (int i = 0 ; i < nRow ; i++) {
						if(m.getValueAt(i, 0).equals(tf4.getText().split(" ")[0])) {
							m.removeRow(i);
							allPrice -= price[3];
							System.out.println(allPrice);
							count[3] = 0;
							cnt[3] = cnt[3] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[4] = cnt[4] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[4] = cnt[4] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[5] = cnt[5] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[5] = cnt[5] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[6] = cnt[6] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[6] = cnt[6] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[7] = cnt[7] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[7] = cnt[7] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[8] = cnt[8] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[8] = cnt[8] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
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
							cnt[9] = cnt[9] + 2;
							cnt[10] = cnt[10] + 1;
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
							cnt[9] = cnt[9] + 2;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
						}
					}
				}
			}
		});
		button_10.setBounds(183, 273, 46, 42);
		contentPane.add(button_10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(460, 23, 204, 293);
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

		tf11 = new JTextField();
		tf11.setText("\uB538\uBC14 2,700");
		tf11.setForeground(Color.WHITE);
		tf11.setColumns(10);
		tf11.setBackground(Color.DARK_GRAY);
		tf11.setBounds(248, 227, 69, 36);
		contentPane.add(tf11);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(cnt[10]-1>= 0) {
					if(cnt[0]-1>=0 || cnt[2] -1>=0) {
						if(cnt[0]-1>=0) {
							if(cnt[2]-1>=0) {
								cnt[0] = cnt[0] - 1;
								cnt[2] = cnt[2] - 1;
								cnt[10] = cnt[10] - 1;
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
							else {
								JOptionPane.showMessageDialog(null, "바나나의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
							}
						}						
						else {
							JOptionPane.showMessageDialog(null, "딸기의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "딸기와 바나나의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
							cnt[2] = cnt[2] + 1;
							cnt[0] = cnt[0] + 1;
							cnt[10] = cnt[10] + 1;
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
							cnt[2] = cnt[2] + 1;
							cnt[0] = cnt[0] + 1;
							cnt[10] = cnt[10] + 1;
							break;
						}
					}
				}
			}
		});
		button_11.setBounds(286, 273, 46, 42);
		contentPane.add(button_11);

		tf12 = new JTextField();
		tf12.setText("\uC624\uD55C 3,700 ");
		tf12.setForeground(Color.WHITE);
		tf12.setColumns(10);
		tf12.setBackground(Color.DARK_GRAY);
		tf12.setBounds(346, 227, 69, 36);
		contentPane.add(tf12);

		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				table = new JTable(m); //
				JScrollPane sc = new JScrollPane(table);
				getContentPane().add(sc);

				DecimalFormat format = new DecimalFormat("###,###");
				if(cnt[10]-1>= 0) {
					if(cnt[1] -1 >=0 || cnt[5] -1>=0) {
						if(cnt[1]-1>=0) {
							if(cnt[5]-1>=0) {
								cnt[1] =	cnt[1]-1;
								cnt[5] =cnt[5]-1;
								cnt[10] = cnt[10] - 1;
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
											b = dao.select2(ID);
											break;
										}
									}
								}
								table.updateUI();
							}
							else {
								JOptionPane.showMessageDialog(null, "한라봉의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
							}
						}						
						else {
							JOptionPane.showMessageDialog(null, "오렌지의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "오렌자와 한라봉의 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "얼.빨.뚜.컵 재고가 없습니다", "재고없음", JOptionPane.PLAIN_MESSAGE);
				}
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
							cnt[1] = cnt[1] + 1;
							cnt[5] = cnt[5] + 1;
							cnt[10] = cnt[10] + 1;
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
							cnt[1] = cnt[1] + 1;
							cnt[5] = cnt[5] + 1;
							cnt[10] = cnt[10] + 1;
							all.setText(format.format(allPrice));
							table.updateUI();
							break;
						}
					}
				}
			}
		});
		button_13.setBounds(384, 273, 46, 42);
		contentPane.add(button_13);


	}
	public void PriceALL( JTextField [] TextFrame) {

	}
}