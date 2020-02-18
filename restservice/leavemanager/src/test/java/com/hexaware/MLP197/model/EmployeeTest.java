package com.hexaware.MLP197.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;

import com.hexaware.MLP197.persistence.EmployeeDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;

import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * testing employee setters.
   * @throws ParseException for the dates
   */
  @Test
  public final void testEmployeeSetters() throws ParseException {
    Employee obj = new Employee();
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    obj.setEmpId(1);
    obj.setEmpFullName("amruta");
    obj.setEmail("amruta@gmail.com");
    obj.setEmpMobile(1234567891L);
    obj.setEmpDateOfJoining("2018-02-07");
    obj.setEmpDesignation("Trainee");
    obj.setEmpDepartment("Testing");
    obj.setEmpLeaveBalance(10);
    obj.setEmpManagerID(2);

    assertEquals(1, obj.getEmpId());
    assertEquals("amruta", obj.getEmpFullName());
    assertEquals("amruta@gmail.com", obj.getEmail());
    assertEquals(new Long(1234567891L), obj.getEmpMobile());
    assertEquals("2018-02-07", obj.getEmpDateOfJoining());
    assertEquals("Trainee", obj.getEmpDesignation());
    assertEquals("Testing", obj.getEmpDepartment());
    assertEquals(10, obj.getEmpLeaveBalance());
    assertEquals(2, obj.getEmpManagerID());
  }
  /**
   * testing the employee getters.
   */
  @Test
  public final void testEmployeeGetters() {
    Employee employee = new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2);

    assertEquals(employee.getEmpId(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpId());
    assertEquals(employee.getEmpFullName(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpFullName());
    assertEquals(employee.getEmail(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmail());
    assertEquals(employee.getEmpMobile(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpMobile());
    assertEquals(employee.getEmpDateOfJoining(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpDateOfJoining());
    assertEquals(employee.getEmpDesignation(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpDesignation());
    assertEquals(employee.getEmpDepartment(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpDepartment());
    assertEquals(employee.getEmpLeaveBalance(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpLeaveBalance());
    assertEquals(employee.getEmpManagerID(), new Employee(1, "amruta", "amruta@gmail.com", 1234567891L,
        "2018-02-07", "Trainee", "Testing", 10, 2).getEmpManagerID());
  }
  /**
   * Test for employee class.
   */
  @Test
  public final void testEmployee() {
    final Employee emp = new Employee(1, "Rita", "rita@gmail.com", 9802030703L, "2010-02-05", "Traine", "Hexavarsity",
        50, 10);
    assertEquals(1, emp.getEmpId());
    assertEquals("Rita", emp.getEmpFullName());
    assertEquals("rita@gmail.com", emp.getEmail());
    assertEquals(new Long(9802030703L), emp.getEmpMobile());
    assertEquals("2010-02-05", emp.getEmpDateOfJoining());
    assertEquals("Traine", emp.getEmpDesignation());
    assertEquals("Hexavarsity", emp.getEmpDepartment());
    assertEquals(50, emp.getEmpLeaveBalance());
    assertEquals(10, emp.getEmpManagerID());
    final Employee emp2 = null;
    assertFalse(emp.equals(emp2));
    final LeaveDetails ld = null;
    assertFalse(emp.equals(ld));
  }
  /**
   * Tests the hashCode method of the employee class.
   */
  @Test
  public final void testHashCode() {
    Employee emp1 = new Employee(2, "Deepjyoti Roy", "deepjyotiroy079@gmail.com", 9999888823L, "2020-02-04",
          "Trainee", "Hexavarsity", 14, 1);
    assertEquals(emp1.hashCode(), new Employee(2, "Deepjyoti Roy",
          "deepjyotiroy079@gmail.com", 9999888823L, "2020-02-04",
          "Trainee", "Hexavarsity", 14, 1).hashCode());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee emp1 = new Employee(2, "Deepjyoti Roy", "deepjyotiroy079@gmail.com", 9999888823L, "2020-02-04",
          "Trainee", "Hexavarsity", 14, 1);

    new Expectations() {
      {
        dao.find(2); result = emp1;
      }
    };

    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };

    Employee e = Employee.listById(2);
    assertEquals(emp1, e);
  }
}
