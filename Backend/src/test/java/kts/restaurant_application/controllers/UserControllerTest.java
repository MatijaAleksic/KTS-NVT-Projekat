package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.constants.Constants;
import kts.restaurant_application.model.User;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserControllerTest {

    @Autowired
	private TestRestTemplate restTemplate;


    @Test
    public void testCreate() {
      User newAdmin = new User(100L, 0L, "a", "a", "uniqueUsername123", "123", new Date(), 100l, false);

      ResponseEntity<User> responseEntity = restTemplate.postForEntity(
				"/users", newAdmin, User.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    responseEntity = restTemplate.postForEntity(
      "/users", newAdmin, User.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }

    @Test
    public void testFindAll() {
        ResponseEntity<User[]> responseEntity = restTemplate
				.getForEntity("/users/", User[].class);

        User[] categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assert categories != null;
        assertEquals(Constants.NUM_OF_USERS, categories.length);
		assertEquals(Constants.ADMIN_USERNAME, categories[0].getUsername());
    }

    @Test
    public void testFindOne() {
        ResponseEntity<User> responseEntity = restTemplate
				.getForEntity("/users/1", User.class);

		User category = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(category);
		assertEquals(Constants.ADMIN_USERNAME, category.getUsername());
    }

    @Test
    public void testUpdate() {
        User newAdmin = new User(1L, 0L, "ime1", "a", "markoMarkovic@maildrop.cc", "123", new Date(), 100L, false);
		
		ResponseEntity<User> responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin, User.class);

        User response = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assert response != null;
        assertEquals(newAdmin.getUsername(), response.getUsername());

        User newAdmin2 = new User(1L, 0L, "ime2", "a", "markoMarkovic@maildrop.cc", "123", new Date(), 100L, false);
        //assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin2, User.class);
        User response2 = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assert response2 != null;
        assertNotEquals(response2.getFirstName(), response.getFirstName());

        User newAdmin3 = new User(50L, 0L, "a", "a", "uniqueUsername1234", "123", new Date(), 100L, false);
        responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin3, User.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    
    }
    
}
