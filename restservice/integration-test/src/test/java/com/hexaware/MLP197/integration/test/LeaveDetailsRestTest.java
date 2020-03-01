package com.hexaware.MLP197.integration.test;

import java.net.URISyntaxException;
import java.util.HashMap;

import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LeaveDetailsRestTest {
  /**
   * testing apply leave.
   */
  @Test
	public void testApplyLeave() {
    Map<String, Object> jsonAsMap = new HashMap<>();
    jsonAsMap.put("empId", 2);
    jsonAsMap.put("leaveStartDate", "2020-02-27");
    jsonAsMap.put("leaveEndDate", "2020-02-27");
    jsonAsMap.put("leaveType", "EARNED_LEAVE");
    jsonAsMap.put("leaveReason", "General");
    jsonAsMap.put("leaveComment", "leave");

    given()
      .contentType(ContentType.JSON)
      .body(jsonAsMap)
      .post("http://localhost:8080/MLP197/api/leaveDetails/applyLeave")
      .then()
      .assertThat()
      .statusCode(200);
  }
  /**
   * testing deny leave
   */
  @Test
  public void testDenyLeave() throws AssertionError, URISyntaxException {
    Map<String, Integer> jsonAsMap = new HashMap<>();
    jsonAsMap.put("leaveId",3);
    jsonAsMap.put("empId", 1);
    given()
    .contentType(ContentType.JSON)
    .body(jsonAsMap)
    .post("http://localhost:8080/MLP197/api/leaveDetails/deny")
    .then()
    .assertThat()
    .statusCode(200);



  }
	}
@Test
public void testApproveLeave() throws AssertionError, URISyntaxException {
  Map<String, Integer> jsonAsMap = new HashMap<>();
  jsonAsMap.put("leaveId", 3);
  jsonAsMap.put("empId", 2);
  given()
  .contentType(ContentType.JSON)
  .body(jsonAsMap)
  .post("http://localhost:8080/MLP197/api/leaveDetails/approveLeave")
  .then()
  .assertThat()
  .statusCode(200);
}
}






