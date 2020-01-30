package com.hexaware.MLP197.model;

import com.hexaware.MLP197.persistence.DbConnection;
import com.hexaware.MLP197.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.Date;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * 
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id. empFullName to store employee full name email to
   * store employee email empMobile to store employee mobile empDateOfJoining to
   * store employee date of joining empDesignation to store employee designation
   * empDepartment to store employee department empLeaveBalance to store employee
   * leave balance empManagerId to store employee's manager id
   */
  private int empId;
  private String empFullName;
  private String email;
  private Long empMobile;
  private String empDateOfJoining;
  private String empDesignation;
  private String empDepartment;
  private int empLeaveBalance;
  private int empManagerId;

  public Employee() {
  }

  /**
   * @param empId            to initialize employee id.
   * @param empFullName      to initialize employee full name.
   * @param email            to initialize employee email.
   * @param empMobile        to initialize employee mobile number.
   * @param empDateOfJoining to initialize employee date of joining.
   * @param empDesignation   to initialize employee designation.
   * @param empDepartment    to initialize employee department.
   * @param empLeaveBalance  to initialize employee leave balance.
   * @param empManagerId     to initialize employee manager id.
   */
  public Employee(final int empId, final String empFullName, final String email, final Long empMobile,
      final String empDateOfJoining, final String empDesignation, final String empDepartment, final int empLeaveBalance,
      final int empManagerId) {
    this.empDepartment = empDepartment;
    this.empLeaveBalance = empLeaveBalance;
    this.empId = empId;
    this.empFullName = empFullName;
    this.email = email;
    this.empMobile = empMobile;
    this.empDateOfJoining = empDateOfJoining;
    this.empDesignation = empDesignation;
    this.empManagerId = empManagerId;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(email, emp.email) && Objects.equals(empMobile, emp.empMobile)
        && Objects.equals(empDateOfJoining, emp.empDateOfJoining) && Objects.equals(empDesignation, emp.empDesignation)
        && Objects.equals(empDepartment, emp.empDepartment) && Objects.equals(empLeaveBalance, emp.empLeaveBalance)
        && Objects.equals(empManagerId, emp.empManagerId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, empDepartment, email, empDesignation, empMobile, empDateOfJoining,
        empManagerId, empLeaveBalance);
  }

  // /**
  // * @param argEmpId to initialize employee id.
  // */
  // public Employee(final int argEmpId) {
  // this.empId = argEmpId;
  // }

  /**
   * Gets the EmployeeId.
   * 
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * 
   * @return all employees' details
   */
  public static Employee[] listAll() {

    final List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * 
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  public static Employee findManager(final int empID) {
    return dao().findManager(empID);
  }
  /**
   * 
   * @return the employee full name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }

  /**
   * 
   * @param empFullName to set employee full name
   */
  public final void setEmpFullName(final String empFullName) {
    this.empFullName = empFullName;
  }

  /**
   * 
   * @return the employee email
   */
  public final String getEmail() {
    return email;
  }

  public final void setEmail(final String email) {
    this.email = email;
  }

  /**
   * 
   * @return the employee mobile number
   */
  public final Long getEmpMobile() {
    return empMobile;
  }

  public final void setEmpMobile(final Long empMobile) {
    this.empMobile = empMobile;
  }

  /**
   * 
   * @return the employee's date of joining
   */
  public final String getEmpDateOfJoining() {
    return empDateOfJoining;
  }

  public final void setEmpDateOfJoining(final String empDateOfJoining) {
    this.empDateOfJoining = empDateOfJoining;
  }

  /**
   * 
   * @return the employee designation
   */
  public final String getEmpDesignation() {
    return empDesignation;
  }

  public final void setEmpDesignation(final String empDesignation) {
    this.empDesignation = empDesignation;
  }

  /**
   * returns the employee's department
   * 
   * @return the employee department
   */
  public final String getEmpDepartment() {
    return empDepartment;
  }

  /**
   * to set the employee departments
   * 
   * @param empDepartment employee departments
   */
  public final void setEmpDepartment(final String empDepartment) {
    this.empDepartment = empDepartment;
  }

  /**
   * for getting employee's leave balance details
   * 
   * @return the employee's leave balance
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  public final void setEmpLeaveBalance(final int empLeaveBalance) {
    this.empLeaveBalance = empLeaveBalance;
  }

  /**
   * for getting employee's manager id
   * 
   * @return the get the employee manager id
   */
  public final int getEmpManagerID() {
    return empManagerId;
  }

  public final void setEmpManagerID(final int empManagerID) {
    this.empManagerId = empManagerID;
  }

  @Override
  public String toString() {
    return "Employee [email=" + email + ", empDateOfJoining=" + empDateOfJoining + ", empDepartment=" + empDepartment
        + ", empDesignation=" + empDesignation + ", empFullName=" + empFullName + ", empId=" + empId
        + ", empLeaveBalance=" + empLeaveBalance + ", empManagerID=" + empManagerId + ", empMobile=" + empMobile + "]";
  }


}
