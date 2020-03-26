package com.hexaware.MLP197.util;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP197.model.Employee;
import com.hexaware.MLP197.model.EmployeeReport;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = Employee.listEmployees();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param empId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/listemployee/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("empId") final int empId) {
    final Employee empl = Employee.listById(empId);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + empId);
    }
    return empl;
  }
  /**
   * @param empId returns empid.
   * @return empid.
   */
  @GET
  @Path("/manager/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee findEmpManager(@PathParam("empId") final int empId) {
    final Employee empl = Employee.findManager(empId);
    if (empl == null) {
      throw new NotFoundException("No such Manager ID: " + empId);
    }
    return empl;
  }

  /**
   * Returns list of employees under a department.
   * @return list of departments with employees number
   */
  @GET
  @Path("/listDepartments")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<EmployeeReport> employeeListByDepartment() {
    System.out.println("Departments List");
    final List<EmployeeReport> emp = Employee.getEmployeeDetails();
    return emp;
  }
}
