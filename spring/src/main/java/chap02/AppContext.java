package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // spring 설정 파일이라고 표시.
public class AppContext {
	
	// MemberController를 Bean으로 등록.
	@Bean
	public MemberController memberController() {
		MemberController con = new MemberController();
		con.setService(memberService());
		return con;
	}
	
	// MemberDao를 Bean으로 등록.
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	// MemberService를 Bean으로 등록.
	@Bean
	public MemberService memberService() {
		// MemberDao 객체를 주입
//		MemberService service = new MemberService();
//		service.setDao(memberDao());
//		return service;
		
		return new MemberService().setDao(memberDao());
	}
	
}
