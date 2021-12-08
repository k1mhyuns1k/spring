package chap04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // spring 설정 파일이라고 표시.
@ComponentScan(basePackages = {"chap04"}) // basePackages의 배열 값(Package)를 스캔해서 Bean 등록.
public class AppContext {

/*
	// MemberController를 Bean으로 등록.
	@Bean
	public MemberController memberController() {
		MemberController con = new MemberController();
//		con.setService(memberService());
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
		
//		return new MemberService().setDao(memberDao());
		return new MemberService();
	}
*/	
}
