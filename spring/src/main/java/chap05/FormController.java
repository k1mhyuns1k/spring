package chap05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@GetMapping("/form.do")
	public String form() {
		return "form";
	}
	
	/*
	 * 파라미터를 받는 방법
	 * 1. HttpServletRequest 객체로 받음. (name)
	 * 2. @RequestParam 으로 받음. (email) 
	 * 		=> 없는 값일 경우 required = false 작성해주면 에러가 나지 않음(default값이 true이기때문)
	 * 3. 커맨드 객체로 받음.
	 * 		=> 클래스로 만들어진 객체로, Parameter의 이름과 동일한 필드에 자동으로 값을 넣어줌.
	 * 		=> Vo 클래스 생성 후, 필드 및 게터세터 작성.
	 */
	
	@PostMapping("/send.do")
	public String send(HttpServletRequest req, @RequestParam("email") String email,
			@RequestParam(value = "tel", required = false) String tel,
			MemberVo vo) { // 3. 커맨드 객체로 받는 방법. 매개변수에 MemberVo 타입의 vo 변수를 작성.
		String name = req.getParameter("name");
		req.setAttribute("msg", name + "님, 안녕하세요.");
		req.setAttribute("msg2", "이메일 : " + email);
		req.setAttribute("tel", tel); // Parameter에 아예 존재하지 않는 값일 경우 당연히 오류.
		
		System.out.println(vo.getName() + " " + vo.getEmail() + " " + vo.getNo());
		
		
//		for(int i = 0; i < vo.getHobby().length; i++) {
//			System.out.print(vo.getHobby()[i] + " ");
//		}
		
		if(vo.getHobby() != null) {
			for(String hobby : vo.getHobby()) {
				System.out.print(hobby + " ");
			}
		} else {
			System.out.println("취미 없음.");
		}
		
		
		// 커맨드 객체 없이 취미값을 vo2의 hobby에 저장하려면?
		MemberVo vo2 = new MemberVo();
		
//		String[] hobby2 = new String[req.getParameterValues("hobby").length];
//		for(int i = 0; i < req.getParameterValues("hobby").length; i++) {
//			hobby2[i] = req.getParameterValues("hobby")[i];
//		}
		
		vo2.setHobby(req.getParameterValues("hobby"));
		return "send";
	}
	
	/*
	 * View에서 사용하기 위한 값을 Controller에서 저장하는 방법.
	 * -Request에 set
	 * -Session에 set
	 * -Model에 add
	 * -ModelAndView에 add
	 */
	
	// ModelAndView 객체.
	// Model + View
	@GetMapping("/test9.do")
	public ModelAndView test9() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "홍길동"); // 값도 Add
		mav.setViewName("test9"); // 뷰도 set
		
		return mav;
	}
	
	
	
}
