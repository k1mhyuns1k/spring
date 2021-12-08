package chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * ~~Service 클래스는 Logic을 담당하는 클래스.
 * Controller가 특정 기능을 실행하기 위해서, 호출.
 */

@Component
public class MemberService {

	// 자동 주입 (실무에서 가장 많이 쓰이는 케이스)
	// Spring이 Type이 같은 Bean(객체)으로 주입.
	@Autowired
	MemberDao dao; // dao 객체를 주입받을 필드를 선언.
	
	// 주입 방법(1. Setter 메서드, 2. 생성자, 3. 자동 주입)
	// Setter Method
//	public MemberService setDao(MemberDao dao) {
//		this.dao = dao;
//		return this;
//	}
	
	
	
	/* 회원 등록 기능을 수행하는 메서드
	 * 여기서는 ~~Dao의 어떠한 메서드를 호출, 비즈니스 Logic을 수행. 
	 */
	public int insert(String name) {
		int r = dao.insert(name);
		return r;
	}
}
