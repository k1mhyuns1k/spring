package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForJava {

	public static void main(String[] args) {
		// 설정 파일을 읽어 와서, Bean 등록.
		
		// greeter라는 이름으로 객체(Bean)를 컨테이너에 등록. (싱글톤으로 등록)
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		// Bean을 가져오기.
		Greeter g = (Greeter)ctx.getBean("greeter");
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
	}

}
