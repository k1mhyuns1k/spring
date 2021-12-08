package chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Controller가 Bean에 등록되어있어야, url 매핑을 할 수 있음.
@RequestMapping("/member") // 전체 method에 대한 공통 경로. ---> /spring/memeber/test.do
public class TestController {

	@GetMapping("/test.do")
	public String test(Model model) {
		model.addAttribute("test", "테스트"); // request에 setAttribute 동일
		return "/test"; // view 경로 = prefix와 suffix 사이의 값
	}
	
	@PostMapping("/test2.do")
	public String test2(Model model) {
		model.addAttribute("test", "테스트"); // request에 setAttribute 동일
		return "/test"; // view 경로 = prefix와 suffix 사이의 값
	}
	
	/*
	 * url Mapping
	 * GetMapping : get 방식만 가능
	 * PostMapping : post 방식만 가능
	 * RequestMapping : 모든 매핑 가능
	 */
	
	@RequestMapping("/test3.do")
	public String test3(Model model) {
		model.addAttribute("test", "테스트"); // request에 setAttribute 동일
		return "/test"; // view 경로 = prefix와 suffix 사이의 값
	}
	
	// RequestMapping method를 직접 지정
	@RequestMapping(value = "/test4.do", method = RequestMethod.GET) // value 는 원래 생략되어있음(디폴트값), 근데 2개 이상일경우는 무조건 작성해주어야함.
	public String test4(Model model) {
		model.addAttribute("test", "테스트"); // request에 setAttribute 동일
		return "/test"; // view 경로 = prefix와 suffix 사이의 값
	}
	
	/*
	 * 포워딩 / 리다이렉트
	 * forwarding : 하나의 요청. 주소가 바뀌지 않음.
	 * redirect : 두개의 요청. 주소가 바뀜.
	 */
	
	// redirect
	// test5.do -> test4.do
	@GetMapping("/test5.do")
	public String test5() {
		return "redirect:/test4.do";
	}
	
	// return이 없으면(void) 매핑된 url과 동일한 경로의 jsp가 포워딩.
	@GetMapping("/test6.do")
	public void test6() {
		
	}
	
	// Servlet으로 응답.
	@GetMapping("/test7.do")
	public void test7(HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('정상적으로 저장되었습니다.')");
		out.println("</script>");
	}
}
