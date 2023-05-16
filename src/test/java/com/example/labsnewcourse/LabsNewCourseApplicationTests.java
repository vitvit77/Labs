package com.example.labsnewcourse;

import com.example.labsnewcourse.model.RequestDTO;
import com.example.labsnewcourse.model.ResponseDTO;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {LabsNewCourseApplication.class, MyTestConfiguration.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LabsNewCourseApplicationTests {

	private String url;

	@BeforeAll
	private void init(@LocalServerPort int port) {
		this.url = Strings.concat("http://localhost:", String.valueOf(port));
	}

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void whenExecuteSumThenReturnCorrectResult() {
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setFirstValue(123);
		requestDTO.setSecondValue(234);
		ResponseDTO responseDTO = restTemplate.postForObject(
				Strings.concat(url, "/calculate/sum"), new HttpEntity<>(requestDTO), ResponseDTO.class
		);
		assert responseDTO != null;
		assertEquals(357, responseDTO.getResult());
	}

}
