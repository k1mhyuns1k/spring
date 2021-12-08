package chap06;

import java.sql.Timestamp;

public class BoardVo extends Parameter {
	
	// 필드는 초기화를 시켜주지 않으면, 기본 자료형 규칙에 따른 초기값 설정이 됨.
	private int boardno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private String filename;
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
