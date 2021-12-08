package chap07.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public boolean insert(UserVo vo, HttpServletRequest req) {
		boolean r = false;
		int cnt = userDao.insert(vo);
		
		// school 데이터 등록
		// UserVo 객체에는 userno가 저장된 상태
		// 학교 정보를 배열로 받아오기
//		String[] school = req.getParameterValues("school");
//		String[] year = req.getParameterValues("year");
//		SchoolVo schoolVo = new SchoolVo();
//		schoolVo.setUserno(vo.getUserno());
//		
//		for(int i = 0; i < school.length; i++) {
//			schoolVo.setSchool(school[i]);
//			schoolVo.setYear(school[i]);
//			cnt += userDao.insertSchool(schoolVo);
//			
//		}
		// 배열 필드 사용
		SchoolVo schoolvo = new SchoolVo();
		schoolvo.setUserno(vo.getUserno());
		
		for(int i = 0; i < vo.getSchool().length; i++) {
			schoolvo.setSchool(vo.getSchool()[i]);
			schoolvo.setYear(vo.getYear()[i]);
			cnt += userDao.insertSchool(schoolvo);
		}
		
		// cnt : 배열의 길이 + 1
//		if(cnt == school.length + 1) {
//			r = true;
//		}
		
		if(cnt == vo.getSchool().length + 1) {
			r = true;
		}
		return r;
	}

	@Override
	public int idcheck(String id) {
		return userDao.idcheck(id);
	}

	@Override
	public boolean login(UserVo vo, HttpSession sess) {
		UserVo uv = userDao.login(vo);
		if(uv != null) {
			sess.setAttribute("loginInfo", uv);
			return true;
		}
		return false;
	}

}
