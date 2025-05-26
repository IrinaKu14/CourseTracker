package ru.jafix.ct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class CoursetrackerApplicationTests {
//	@Autowired
//	private Environment environment;

	@Test
	void contextLoads() {
		//System.out.println(environment.getProperty("test.prop"));
	}

}
