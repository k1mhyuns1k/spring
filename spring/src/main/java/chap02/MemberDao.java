package chap02;

/*
 * ~~Dao는 Data 처리를 위한 클래스.
 * DAO(Data Access Object)
 * ex) insert, select, update, delete.. 
 */
public class MemberDao {

	// DB에 회원을 등록하는 메서드.
	public int insert(String name) {
		// DB에 저장.
		System.out.println(name + " 저장!!!");
		return 1; // 성공시 1 return
	}
}
