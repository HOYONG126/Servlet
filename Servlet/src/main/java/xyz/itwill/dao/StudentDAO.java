package xyz.itwill.dao;

//DAO(Data Access Object)클래스 :테이블에 행삽입
//실행하고 실행결과를 Java 객체로(값) 매핑하여 반환하는 기능를 제공하는 클래스
// => 싱글톤 클래스(프로그램에 객체를 하나만 생성하여 제공하는 클래스)
//STUDENT 테이블에 학생정보를 삽입,삭제,변경,검색하는 기능을 제공

public class StudentDAO {
	private static StudentDAO _dao;
	public StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	static {
		_dao=new StudentDAO();
	}
	public static StudentDAO getDAO() {
		return _dao;
	}
}
