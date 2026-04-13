package com.example.hello.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

	public static void main(String[] args){
		System.out.println("Hello, World!");
	}

	@Test
	void contextLoads() {
		System.out.println("Hello, World!");
	}

}
