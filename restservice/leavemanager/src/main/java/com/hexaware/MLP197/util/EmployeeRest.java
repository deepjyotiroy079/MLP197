package com.hexaware.MLP197.util;


import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP197.model.Employee;

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
    final Employee[] employees = Employee.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("id") final int id) {
    System.out.println("Employee details by id");
    final Employee empl = Employee.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return empl;
  }
  /**
   * Returns manager details of specific Employee.
   * @param empId the employee id
   * @return the manager details
   */
  @GET
  @Path("/managerdetails/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee viewManagerDetails(@PathParam("empId") final int empId) {
    System.out.println("Manager Details of given employee : ");
    final Employee manager = Employee.findManager(empId);
    if (manager == null) {
      throw new NotFoundException("No manager exists of this employee ");
    }
    return manager;
  }
}
