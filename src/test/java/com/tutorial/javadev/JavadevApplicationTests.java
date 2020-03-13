package com.tutorial.javadev;

import com.tutorial.javadev.starter.User;
import com.tutorial.javadev.starter.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JavadevApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {

		User user = userRepository.save(new User("Demo","User"));
		Optional<User> searchUser = userRepository.findById(user.getId());

		assertNotNull(searchUser);
		assertEquals(user.getFirstName(),searchUser.get().getFirstName());

		System.out.println("user : " + user);
		System.out.println("searchUser : " + searchUser);
		System.out.println("searchUser.get() : " + searchUser.get());

	}

}
