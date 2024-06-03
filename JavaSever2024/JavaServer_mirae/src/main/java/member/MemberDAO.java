package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> getAll() {
		List<Member> memberList = new ArrayList<>();
		open();
		
		try {
			pstmt = conn.prepareStatement("SELECT * from members");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setUserName(rs.getString("userName"));
				m.setCompany(rs.getString("company"));
				m.setBirthday(rs.getDate("birthday"));
				m.setEmail(rs.getString("email"));
				memberList.add(m);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return memberList;
	}
	
	public void insert(Member m){
		
		open();
		try {
			
			String sql = "INSERT INTO members(userName, company, birthday, email) "
					+ "values(?, ?, ? ,?)";
			// 이어서 프로그램함 2024.5.27
			
			// 신규 멤버를 members 테이블에 추가함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName()); // 위에 SQL문 USERNAME에 해당
			pstmt.setString(2, m.getCompany());
			pstmt.setDate(3, (Date) m.getBirthday());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

}
