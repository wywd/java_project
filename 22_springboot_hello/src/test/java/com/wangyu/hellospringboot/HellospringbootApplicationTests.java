package com.wangyu.hellospringboot;

import com.wangyu.hellospringboot.pojo.Dog;
import com.wangyu.hellospringboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HellospringbootApplicationTests {

	@Autowired
	private Dog dog;

	@Autowired
	private Person person;

	@Test
	void contextLoads() {
		System.out.println(dog);
		System.out.println(person);
	}

}
