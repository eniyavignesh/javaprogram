package mvnfrist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mvnfrist.Welcome;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Welcome.xml");
		ApplicationContext c = new ClassPathXmlApplicationContext("c.xml");
		Welcome wel = (Welcome)context.getBean("welc");
		
		System.out.println(wel.sayHi());
		System.out.println(wel.num());

	}

}
