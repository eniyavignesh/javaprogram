package com.mph.lambda;

import java.util.Arrays;
import java.util.List;


public class LambdaEg {

	public static void main(String[] args) {
//		Runnable r = new MyTaskThread();
//		Thread thread = new Thread(r);
//		thread.start();
		
//		Runnable r1 = new Runnable() {
//			public void run() {
//				Task task = new Task();
//				task.connect();
				
		//	}
//		};
//		Thread t1 = new Thread(r1);
//		t1.start();
//		Runnable r = new Thread(r);
//		t1.start();
//		new Thread(() -> {
//			new Task().connect();
//			
//		}).start();
//		new Thread(new Task()::connect).start();
		
		User u1 = new User(11,"vicky1","vicky1@gmail.com");
		User u2 = new User(11,"var","var@gmail.com");
		User u3 = new User(12,"vvv","vvv@gmail.com");
		List<User> li = new ArrayList<User>();
		li.add(u1);
		li.add(u2);
		li.add(u3);
		System.out.println("User list :" + li);
		
		li.forEach(lis->System.out.print(lis));
		
		
	}
	
}
