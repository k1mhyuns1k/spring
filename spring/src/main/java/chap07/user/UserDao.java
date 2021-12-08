package chap07.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(UserVo vo) {
		return sqlSessionTemplate.insert("user.insert", vo);
	}
	
	public int idcheck(String id) {
		return sqlSessionTemplate.selectOne("user.idcheck", id);
	}
	
	public UserVo login(UserVo vo) {
		return sqlSessionTemplate.selectOne("user.login", vo);
	}
	
	public int insertSchool(SchoolVo vo) {
		return sqlSessionTemplate.insert("user.insertSchool", vo);
	}
}
