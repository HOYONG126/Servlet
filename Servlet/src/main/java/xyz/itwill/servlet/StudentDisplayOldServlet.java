package xyz.itwill.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Student 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하여 응답하는 서블릿
//=>JDBC 프로그램을 작성하기 위해선 JDBC 관련 라이브러리 파일(ojdbc 라이브러리)을 프로젝트에 빌드처리
@WebServlet("/old.itwill")
public class StudentDisplayOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDisplayOldServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//JDBC 관련 객체를 저장하기 위한 변수 선언
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.OracleDriver 클래스를 읽어 메모리에 저장
			//=>OracleDriver 객체가 생성되어 DriverManager 클래스의 JDBC Driver로 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DriverManager 클래스에 등록된 JD
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url,username,password);
			
			//3.Connection 객체로부터 SQL 명령이 저장된 PreparedStatement 객체를 반환받아 저장
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			//4. PreparedStatement 객체에 저장된 SQL 명령을 DBMS 서버에 전달하여 실행한 후 실행
			rs=pstmt.executeQuery();
			
			//5.반환받은 실행결과를 사용자에게 제공
			out.println("<!DOCTYPE ");
			
		}catch (ClassNotFoundException e) {
			System.out.println("[에러]오라클드라이버 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
}
