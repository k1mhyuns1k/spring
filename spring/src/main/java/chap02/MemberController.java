package chap02;

/*
 * Controller가 하는 역할.
 * Client의 요청을 받아서, 요청에 해당하는 Logic을 처리(Service)하고, 화면을 응답(View). (req -> res)
 */
public class MemberController {
	MemberService service;
	
	// MemberService 객체를 주입 받음.
	public void setService(MemberService service) {
		this.service = service;
	}
	
	// 등록 폼에서 저장 버튼을 클릭하면, 전송되는 위치.
	public String insert(String name) {
		
		if(service.insert(name) > 0) {
			// 등록 성공시 처리.
		} else {
			// 등록 실패시 처리.
		}
		
		return "응답";
	}
}
