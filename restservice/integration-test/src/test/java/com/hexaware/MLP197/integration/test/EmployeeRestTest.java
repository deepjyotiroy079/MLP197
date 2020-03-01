package com.hexaware.MLP197.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {
	/**
	 * testing listing all the employees.
	 * 
	 * @throws AssertionError     the assert error
	 * @throws URISyntaxException the URI Syntax Exception
	 */
	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees")).getBody()
				.as(Employee[].class);
		for (Employee e : res) {
			switch (e.getEmpId()) {
			case 2:
				assertEquals(new Employee(2, "DEEPJYOTI ROY", "deepjyotir@hexaware.com", 9999888831L, "2016-12-10", "TRAINEE",
						"HEXAVARSITY", 0, 1), e);
				break;
			case 3:
				assertEquals(new Employee(3, "TANISHQ ROY", "tanishqr@hexaware.com", 9999488831L, "2019-12-10", "TRAINEE",
						"HEXAVARSITY", 8, 1), e);
				break;
			case 5:
				assertEquals(new Employee(5, "ALEX GARETTE", "alexg@hexaware.com", 9999488854L, "2019-12-10", "DEVELOPER",
						"INNOVATION", 17, 4), e);
				break;
			case 6:
				assertEquals(new Employee(6, "BILLY GARETTE", "billyg@hexaware.com", 9999488811L, "2019-12-11", "TESTER",
						"TESTING", 24, 4), e);
				break;
			default:
				fail("Unknown employee with id:" + e);
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException {
		Employee res = given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/employees/listemployee/1")).getBody().as(Employee.class);
		assertEquals(new Employee(1, "DEEPJYOTI ROY", "deepjyotir@hexaware.com", 9999888831L, "2019-12-10", "TRAINEE",
		   "HEXAVARSITY", 12, 2), res);
	}

	@Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/9999")).then().assertThat()
				.statusCode(404);
	}

	@Test
	public void testFindManager() throws URISyntaxException {
		Employee manager = given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/employees/manager/2")).getBody().as(Employee.class);
		assertEquals(new Employee(1, "MURUGAN", "murugan@hexaware.com", 9999888834L, "2009-01-01", "MANAGER", "HEXAVARSITY", 12, 0), manager);
    
	}
}
