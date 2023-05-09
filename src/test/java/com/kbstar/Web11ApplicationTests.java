package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class Web08ApplicationTests {
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
		String rawPassword = "333333333333333333";
		String encPassword = encoder.encode(rawPassword);
		log.info("암호화 된 비번" + encPassword);
		boolean result = encoder.matches(rawPassword,encPassword);
		log.info(result+"");
	}

}

//[2023-05-02 09:37:00] INFO  com.kbstar.Web08ApplicationTests - 암호화 된 비번$2a$10$uFRxfhFGE1j.AsoXc94tzegygjccpgR9VqmaZJ9cQspjSeTBuOIte
//[2023-05-02 09:37:01] INFO  com.kbstar.Web08ApplicationTests - true
//rawPassword = "333333333333333333"; 일때 결과값