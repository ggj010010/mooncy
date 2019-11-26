package First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DAO { /* * DAO(Data Access Object - 데이터 접근 객체) 데이터베이스에 관련된 작업을 전문적으로 담당하는 객체이다. * */
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
    /*String user = "moon"; 
    String pw = "3464";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";*/
	private static final String DRIVER  = "oracle.jdbc.driver.OracleDriver";
	//private static final String URL = "jdbc:oracle:thin:@10.50.208.41:1521:xe";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mooncy"; 
	private static final String PW = "mooncy";

	public DAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void select1() {
		String sql = "select * from customers";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				   String empno = rs.getString(1);
	                System.out.println(empno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
	}

	public ArrayList<DTO> select2(String ID) {
		ArrayList<DTO> list = new ArrayList<DTO>();
		String sql = "select * from PRODUCT where m_id ='"+ID+"'";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				DTO dto = new DTO();
				dto.setDdalgi(rs.getInt("ddalgi"));
				dto.setApple(rs.getInt("apple"));
				dto.setBanana(rs.getInt("banana"));
				dto.setBbalde(rs.getInt("bbalde"));
				dto.setCup(rs.getInt("cup"));
				dto.setDduggung(rs.getInt("dduggung"));
				dto.setHanla(rs.getInt("hanla"));
				dto.setIce(rs.getInt("ice"));
				dto.setKiwi(rs.getInt("kiwi"));
				dto.setMango(rs.getInt("mango"));
				dto.setOrange(rs.getInt("orange"));
				dto.setPine(rs.getInt("pine"));
				dto.setSuback(rs.getInt("suback"));
				dto.setTomato(rs.getInt("tomato"));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return null;
	}
	public void  Update(String[] arg, String ID) {
		System.out.println("asda");
		
//		String sql = "update PRODUCT set "+arg[0].split(",")[0]+"";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			for(int i = 0; i < arg.length; i++) {
				System.out.println(arg[i].split(",")[0]);
				System.out.println(arg[i].split(",")[1]);
				if(arg[i].split(",")[0].equals("딸기")) {
					System.out.println("aaa");
					String sql = "update"
							+ " PRODUCT "
							+ "set"
							+ " ddalgi = ddalgi -"+arg[i].split(",")[1]+"*2,"
									+ " ice = ice-"+arg[i].split(",")[1]+","
											+ " bbalde = bbalde - "+arg[i].split(",")[1]+","
													+ " dduggung = dduggung-"+arg[i].split(",")[1]+" ,"
															+ " cup = cup-"+arg[i].split(",")[1]+" "
																	+ "where m_id='"+ID+"'";
					System.out.println(sql);
					
					rs = stmt.executeQuery(sql);
	
				}
			if(arg[i].split(",")[0].equals("오렌지")) {
					System.out.println("aaa");
					String sql = "update PRODUCT set orange = orange -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
					rs = stmt.executeQuery(sql);		
			}
		if(arg[i].split(",")[0].equals("바나나")) {
				System.out.println("aaa");
				String sql = "update PRODUCT set banana = banana -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
				rs = stmt.executeQuery(sql);		
			}
		if(arg[i].split(",")[0].equals("키위")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set kiwi = kiwi -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("파인애플")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set pine = pine -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("한라봉")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set hanla = hanla -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("수박")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set suback = suback -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("토마토")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set tomato = tomato -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("사과")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set apple = apple -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("망고")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set mango = mango -"+arg[i].split(",")[1]+"*2,  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("딸바")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set ddalgi = ddalgi -"+arg[i].split(",")[1]+",banana=banana-"+arg[i].split(",")[1]+",  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
		if(arg[i].split(",")[0].equals("오한")) {
			System.out.println("aaa");
			String sql = "update PRODUCT set orange = orange -"+arg[i].split(",")[1]+",hanla=hanla-"+arg[i].split(",")[1]+",  ice = ice-"+arg[i].split(",")[1]+", bbalde = bbalde - "+arg[i].split(",")[1]+", dduggung = dduggung-"+arg[i].split(",")[1]+" , cup = cup-"+arg[i].split(",")[1]+" where m_id='"+ID+"'";
			rs = stmt.executeQuery(sql);		
		}
	}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		
	}
	public void  insert_sale(String ID, String name, int money, int count) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String sql = "insert into sale values((select nvl(TO_NUMBER(MAX(s_no)+1),1) from sale), '"+ID+"', '"+name+"', '"+money+"', '"+count+"', '"+format.format(d)+"')";
		System.out.println(sql);
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		
	}
	public int order_select(String ID,  String name) {
		ArrayList<DTO> list = new ArrayList<DTO>();
		String sql = "select * from p_order where m_id ='"+ID+"' and p_name = '"+ name + "' and o_check = '0'";
		System.out.println(sql);
		int a = 0;
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				DTO dto = new DTO();
				dto.setP_name(rs.getString("p_name"));
				list.add(dto);
				a = 1;
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return a;
	}
	public void  insert_order(String ID, String name, int count) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String sql = "insert into p_order values((select nvl(TO_NUMBER(MAX(o_no)+1),1) from p_order), '"+ID+"', '0', '"+name+"', '"+count+"', sysdate)";
		System.out.println(sql);
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		
	}
	
	public void close(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
