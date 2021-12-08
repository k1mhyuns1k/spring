package chap05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * RestAPI Controller
 */

@RestController
public class ApiController {

	@GetMapping("/api/test")
	public MemberVo test() {
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong@gmail.com");
		vo.setNo(1);
		
		return vo;
	}
	
	/*
	 * Parameter를 받는 4번째 방법
	 * @PathVariable
	 * /api/list/1 -> 1페이지
	 * /api/list/2 -> 2페이지
	 */
	@GetMapping("/api/list/{page}/{searchWord}") // 경로처럼 생겼지만, page와 searchWord는 파라미터
	public List<MemberVo> list(@PathVariable int page, 
			@PathVariable String searchWord) {
		System.out.println("page : " + page);
		System.out.println("searchWord : " + searchWord);
		
		List<MemberVo> list =  new ArrayList<MemberVo>();
		
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong@gmail.com");
		vo.setNo(1);
		
		list.add(vo);
		list.add(vo);
		
		return list;
	}
}
