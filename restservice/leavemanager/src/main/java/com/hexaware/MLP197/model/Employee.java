package com.hexaware.MLP197.model;

import java.util.List;
import java.util.Objects;

import com.hexaware.MLP197.persistence.DbConnection;
import com.hexaware.MLP197.persistence.EmployeeDAO;
// import com.hexaware.MLP197.model.EmployeeReport;

/**
 * Employee class to store employee personal details.
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

  /**
   * No argument employee constructor.
   */
  public Employee() {
  }

  /**
   * @param argEmpId            to initialize employee id.
   * @param argEmpFullName      to initialize employee full name.
   * @param argEmail            to initialize employee email.
   * @param argEmpMobile        to initialize employee mobile number.
   * @param argEmpDateOfJoining to initialize employee date of joining.
   * @param argEmpDesignation   to initialize employee designation.
   * @param argEmpDepartment    to initialize employee department.
   * @param argEmpLeaveBalance  to initialize employee leave balance.
   * @param argEmpManagerId     to initialize employee manager id.
   */
  public Employee(final int argEmpId, final String argEmpFullName, final String argEmail, final Long argEmpMobile,
      final String argEmpDateOfJoining, final String argEmpDesignation, final String argEmpDepartment,
        final int argEmpLeaveBalance, final int argEmpManagerId) {
    this.empDepartment = argEmpDepartment;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empId = argEmpId;
    this.empFullName = argEmpFullName;
    this.email = argEmail;
    this.empMobile = argEmpMobile;
    this.empDateOfJoining = argEmpDateOfJoining;
    this.empDesignation = argEmpDesignation;
    this.empManagerId = argEmpManagerId;
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
    return Objects.hash(empId, empFullName, empDepartment, email, empDesignation, empMobile,
    empDateOfJoining, empManagerId, empLeaveBalance);
  }

  // /**
  // * @param argEmpId to initialize employee id.
  // */
  // public Employee(final int argEmpId) {
  // this.empId = argEmpId;
  // }

  /**
   * Gets the EmployeeId.
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
   * @return all employees' details
   */
  public static Employee[] listAll() {
    final List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * @param argEmpID to set emp id
   * @return Employee
   */
  public static Employee findManager(final int argEmpID) {
    return dao().findManager(argEmpID);
  }
  /**
   * @return the employee full name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }

  /**
   * @param argEmpFullName to set employee full name
   */
  public final void setEmpFullName(final String argEmpFullName) {
    this.empFullName = argEmpFullName;
  }

  /**
   * @return the employee email
   */
  public final String getEmail() {
    return email;
  }

  /**
  * @param argEmail to set emp email
  */
  public final void setEmail(final String argEmail) {
    this.email = argEmail;
  }
  /**
  * @return the employee mobile number.
  */
  public final Long getEmpMobile() {
    return empMobile;
  }
  /**
  * @param argEmpMobile to set emp mobile
  */
  public final void setEmpMobile(final Long argEmpMobile) {
    this.empMobile = argEmpMobile;
  }

  /**
   * @return the employee's date of joining
   */
  public final String getEmpDateOfJoining() {
    return empDateOfJoining;
  }

  /**
   * @param argEmpDateOfJoining to set emp date of joining.
   */
  public final void setEmpDateOfJoining(final String argEmpDateOfJoining) {
    this.empDateOfJoining = argEmpDateOfJoining;
  }

  /**
   * @return the employee designation
   */
  public final String getEmpDesignation() {
    return empDesignation;
  }

  /**
   * @param argEmpDesignation to set emp designation
   */
  public final void setEmpDesignation(final String argEmpDesignation) {
    this.empDesignation = argEmpDesignation;
  }

  /**
   * returns the employee's department.
   * @return the employee department
   */
  public final String getEmpDepartment() {
    return empDepartment;
  }

  /**
   * to set the employee departments.
   * @param argEmpDepartment employee departments
   */
  public final void setEmpDepartment(final String argEmpDepartment) {
    this.empDepartment = argEmpDepartment;
  }

  /**
   * for getting employee's leave balance details.
   * @return the employee's leave balance
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }
  /**
   * @param argEmpLeaveBalance to set emp leave balance
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * for getting employee's manager id.
   * @return the get the employee manager id
   */
  public final int getEmpManagerID() {
    return empManagerId;
  }
  /**
   * @param empManagerID to set manager id
   */
  public final void setEmpManagerID(final int empManagerID) {
    this.empManagerId = empManagerID;
  }

  @Override
  public final String toString() {
    return "Employee [email=" + email + ", empDateOfJoining=" + empDateOfJoining + ", empDepartment=" + empDepartment
        + ", empDesignation=" + empDesignation + ", empFullName=" + empFullName + ", empId=" + empId
        + ", empLeaveBalance=" + empLeaveBalance + ", empManagerID=" + empManagerId + ", empMobile=" + empMobile + "]";
  }
  // /**
  //  * returns all the employees from given department....
  //  * @param argsDepartmentName the department name
  //  * @return the list of employees working in the given department
  //  */
  // public static Employee[] getEmployeesByDepartment(final String argsDepartmentName) {
  //   final List<Employee> es = dao().employeesByDepartment(argsDepartmentName);
  //   return es.toArray(new Employee[es.size()]);
  // }
  /**
   * to return list of employees working uder a manager.
   * @param argsManagerId the manager id
   * @return the list of employees working under given manager
   */
  public static List<Employee> findByManager(final int argsManagerId) {
    return dao().findEmployeeViaManager(argsManagerId);
  }
  /**
   * function to return the mapping of department and employee count.
   * @return the mapping of employee and department
   */
  public static List<EmployeeReport> getEmployeeDetails() {
    // return dao().getEmployeeReport();
    return  dao().getEmployeeReport();
    // System.out.println(rpt.size());
    // return rpt;
  }
  /**
   * returning leaveBalance.
   * @param argEmpId employee id
   * @return leaveBalance
   */
  public static int findingEmpLeaveBalance(final int argEmpId) {
    return dao().findLeaveBalance(argEmpId);
  }
}
