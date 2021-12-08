package chap01;

public class Greeter {

	private String name;
	
	public String greet() {
		return name + "님 안녕하세요!";
	}
	
	public void setName(String name) {
		this.name = name;               // 필드에다가 매개변수에 있는 값을 set.
	}
}
