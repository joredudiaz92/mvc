package com.mvc.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void mainMethodTest() {
		ExampleApplication.main(new String[] {"--spring.profiles.active=test"});
	}
}
