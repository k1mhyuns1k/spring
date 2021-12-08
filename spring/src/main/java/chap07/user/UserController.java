package chap07.user;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/regist.do")
	public String regist() {
		return "user/regist";
	}
	
	@PostMapping("/user/regist.do")
	public String regist(Model model, UserVo vo, HttpServletRequest req) {
		log.info("등록 전 userno : " + vo.getUserno());
		boolean r = userService.insert(vo, req);
		log.info("등록 후 userno : " + vo.getUserno());
		
		if(r == true) {
			model.addAttribute("msg", "정상적으로 가입되었습니다.");
			model.addAttribute("url", "/spring/board/index.do");
		} else {
			model.addAttribute("msg", "가입 오류.");
			model.addAttribute("url", "regist.do");
		}
		
		return "include/result";
	}
	
	@GetMapping("/user/idcheck.do")
	public String idcheck(Model model, @RequestParam String id) {
		int r = userService.idcheck(id);
		model.addAttribute("ret", r);
		return "include/result";
	}
	
	@RequestMapping("/user/login.do")
	public String login(@CookieValue(value = "cookieId", required = false) Cookie cookie, UserVo vo) {
		if(cookie != null) { // 이전에 아이디 저장을 체크하고 로그인 한 적이 있음.
			vo.setId(cookie.getValue());
//			vo.setCheckId("check");
		}
		return "user/login";
	}
	
	@RequestMapping("/user/loginProcess.do")
	public String loginProcess(UserVo vo, HttpSession sess, Model model, HttpServletResponse res) {
		
		if(userService.login(vo, sess)) {
			// 쿠키 객체 생성.
			Cookie cookie = new Cookie("cookieId", vo.getId()); 
			
			if("check".equals(vo.getCheckId())) { // 사용자가 "아이디저장"에 체크.
				cookie.setMaxAge(60 * 60); 
			} else {
				cookie.setMaxAge(0); // 즉시 만료.
			}
			res.addCookie(cookie); // response 객체에 쿠키를 추가.
			
			return "redirect:/board/index.do";
		} else {
			model.addAttribute("msg", "아이디, 비밀번호가 올바르지 않습니다.");
			model.addAttribute("url", "login.do");
		}
		return "include/result";
	}
	
	@RequestMapping("/user/logout.do")
	public String logout(UserVo vo, HttpSession sess, Model model) {
		sess.invalidate();
//		sess.removeAttribute("loginInfo");
		model.addAttribute("msg", "로그아웃 처리되었습니다.");
		model.addAttribute("url", "/spring/board/index.do");
		
		return "include/result";
	}
}
