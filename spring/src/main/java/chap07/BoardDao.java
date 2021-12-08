package chap07;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // ComponentScan으로 Package 다 묶어놔서 객체 생성해서 등록을 해줌.
public class BoardDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int count(BoardVo vo) {
		return sqlSessionTemplate.selectOne("board.count", vo);
	}
	
	public List<BoardVo> selectList(BoardVo vo) {
		return sqlSessionTemplate.selectList("board.selectList", vo);
	}
	
	public int insert(BoardVo vo) {
		int r = -1;
		
		try {
			r =  sqlSessionTemplate.insert("board.insert", vo); 
		} catch(Exception e) {
			r = 0;
			System.out.println(e.getMessage());
		}
		
		return r;
	}
	
	public BoardVo selectOne(int boardno) {
		return sqlSessionTemplate.selectOne("board.selectOne", boardno);
	}
	
	public BoardVo2 selectOne2(int boardno) {
		return sqlSessionTemplate.selectOne("board.selectOne2", boardno);
	}
	
	public int update(BoardVo vo) {
		int r = -1;
		
		try {
			r =  sqlSessionTemplate.update("board.update", vo); 
		} catch(Exception e) {
			r = 0;
			System.out.println(e.getMessage());
		}
		
		return r;
	}
	
	public int delete(BoardVo vo) {
		return sqlSessionTemplate.delete("board.delete", vo.getBoardno());
	}
}
