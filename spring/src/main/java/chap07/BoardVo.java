package chap07;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo extends Parameter {
	
	// 필드는 초기화를 시켜주지 않으면, 기본 자료형 규칙에 따른 초기값 설정이 됨.
	private int boardno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private String filename;
	private int userno;
	

}
