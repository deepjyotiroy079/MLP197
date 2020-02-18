package com.hexaware.MLP197.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.List;

// import com.hexaware.MLP197.persistence.EmployeeDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;

// import mockit.Expectations;
// import mockit.Mock;
// import mockit.MockUp;

// import mockit.Mocked;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeReportTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * testing employee report setters.
   * @throws ParseException for the dates
   */
  @Test
  public final void testEmployeeReportSetters() throws ParseException {
    EmployeeReport obj = new EmployeeReport();
    obj.setDepartment("DEVELOPMENT");
    obj.setCount(25);

    assertEquals("DEVELOPMENT", obj.getDepartment());
    assertEquals(25, obj.getCount());
  }
  /**
   * testing the employee report getters.
   */
  @Test
  public final void testEmployeeReportGetters() {
    EmployeeReport employeeReport = new EmployeeReport("DEVELOPMENT", 25);

    assertEquals(employeeReport.getDepartment(), new EmployeeReport("DEVELOPMENT", 25).getDepartment());
    assertEquals(employeeReport.getCount(), new EmployeeReport("DEVELOPMENT", 25).getCount());
  }
  /**
   * Test for employee report class.
   */
  @Test
  public final void testEmployeeReport() {
    final EmployeeReport employeeReport = new EmployeeReport("DEVELOPMENT", 25);

    assertEquals("DEVELOPMENT", employeeReport.getDepartment());
    assertEquals(25, employeeReport.getCount());

    final EmployeeReport empReport = null;
    assertFalse(employeeReport.equals(empReport));
  }
  /**
   * Tests the hashCode method of the employee report class.
   */
  @Test
  public final void testHashCode() {
    EmployeeReport employeeReport = new EmployeeReport("DEVELOPMENT", 25);
    assertEquals(employeeReport.hashCode(), new EmployeeReport("DEVELOPMENT", 25).hashCode());
  }
  /**
   * testing the equals method.
   */
  @Test
  public final void testEquals() {
    EmployeeReport employeeReport1 = new EmployeeReport("DEVELOPMENT", 25);
    EmployeeReport employeeReport2 = new EmployeeReport("DEVELOPMENT", 25);
    EmployeeReport employeeReport3 = new EmployeeReport("MARKETING", 5);
    assertEquals(employeeReport1, employeeReport2);
    assertNotEquals(employeeReport2, employeeReport3);
    assertNotEquals(employeeReport1, employeeReport3);
  }
}
