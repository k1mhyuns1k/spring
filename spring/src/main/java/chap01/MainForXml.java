package chap01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForXml {

	public static void main(String[] args) {
		// xml 설정 파일을 읽어오기.
		// ClassPath : 클래스가 있는 경로.
		// Server(운영환경)에서는 /WEB-INF/classes, Local(개발환경)에서는 target/classes
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("chap01/beans.xml");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		System.out.println(g.greet());
	}

}
