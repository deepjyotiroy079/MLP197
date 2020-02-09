package com.hexaware.MLP197.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
// import java.util.Map;
// import java.util.Locale;
import java.util.Scanner;

import com.hexaware.MLP197.model.Employee;
import com.hexaware.MLP197.model.LeaveDetails;
import com.hexaware.MLP197.model.EmployeeReport;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  private Scanner input = new Scanner(System.in, "UTF-8");

  private void mainMenu() throws ParseException {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. View Manager Details");
    System.out.println("4. Approve / Deny Leave");
    System.out.println("5. View Leave History");
    System.out.println("6. Applying for leave");
    System.out.println("7. Listing Employees by Manager");
    System.out.println("8. Employee Reports");
    // System.out.println("9. Leave Details Reports");
    // System.out.println("7. View Employees by Department");
    System.out.println("9. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }

  private void mainMenuDetails(final int selectedOption) throws ParseException {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        listManagerDetail();
        break;
      case 4:
        approveOrDeny();
        break;
      case 5:
        listLeaveHistory();
        break;
      case 6:
        applyLeave();
        break;
      case 7:
        listEmployeeByManager();
        break;
      case 8:
        employeeReport();
        break;
      // case 9:
      //   leaveDetailsReport();
      //   break;
      // case 7:
      //   listEmployeesByDepartment();
      //   break;
      case 9:
      // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6, 7 or 8");
    }
    mainMenu();
  }
  // private void leaveDetailsReport() {
  // }
  private void employeeReport() {
    System.out.println("--------------------------------");
    System.out.println("\tEMPLOYEE REPORTS");
    System.out.println("--------------------------------");
    // System.out.println(Employee.getEmployeeDetails());
    List<EmployeeReport> reports = Employee.getEmployeeDetails();
    // int empCount = (int)
    // System.out.println(reports.size());
    // System.out.println("Total Number of Employees : " + Integer.valueEmployee.getEmployeeCount());
    for (EmployeeReport employee : reports) {
      System.out.println("Department : " + employee.getDepartment() + " Count : " + employee.getCount());
    }
    // for (Map.Entry<String, Integer> entry : reports.entrySet()) {
    //   System.out.println("Department Name : " + entry.getKey() + " | Count : " + entry.getValue());
    // }
  }

  private void listEmployeeByManager() {
    System.out.println("Enter the manager ID : ");
    int managerId = input.nextInt();
    List<Employee> employees = Employee.findByManager(managerId);
    if (employees.size() == 0) {
      System.out.println("No such manager exists");
    } else {
      for (Employee e : employees) {
        System.out.println("----------------");
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("----------------");
        System.out.println("Employee Full Name : " + e.getEmpFullName());
        System.out.println("Employee Email : " + e.getEmail());
        System.out.println("Employee Mobile : " + e.getEmpMobile());
        System.out.println("Date of Joining : " + e.getEmpDateOfJoining());
        System.out.println("Employee Designation : " + e.getEmpDesignation());
        System.out.println("Employee Department : " + e.getEmpDepartment());
        System.out.println("");
      }
    }
  }

  // private void listEmployeesByDepartment() {
  //   System.out.println("Enter the department name : ");
  //   String dept = input.next();
  //   String department = dept.toUpperCase(Locale.getDefault());
  //   Employee[] employees = Employee.getEmployeesByDepartment(department);
  //   if (employees.length == 0) {
  //     System.out.println("No Such department exists");
  //   } else {
  //     for (Employee e : employees) {
  //       System.out.println("----------------");
  //       System.out.println("EMPLOYEE DETAILS");
  //       System.out.println("----------------");
  //       System.out.println("Employee Full Name : " + e.getEmpFullName());
  //       System.out.println("Employee Email : " + e.getEmail());
  //       System.out.println("Employee Mobile : " + e.getEmpMobile());
  //       System.out.println("Date of Joining : " + e.getEmpDateOfJoining());
  //       System.out.println("Employee Designation : " + e.getEmpDesignation());
  //       System.out.println("Employee Department : " + e.getEmpDepartment());
  //       System.out.println("");
  //     }
  //   }
  // }
  /**
   * listing single employee.
   */
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println("----------------");
      System.out.println("EMPLOYEE DETAILS");
      System.out.println("----------------");
      System.out.println("Employee ID : " + employee.getEmpId());
      System.out.println("Employee Full Name : " + employee.getEmpFullName());
      System.out.println("Employee Email : " + employee.getEmail());
      System.out.println("Employee Mobile : " + employee.getEmpMobile());
      System.out.println("Date of Joining : " + employee.getEmpDateOfJoining());
      System.out.println("Employee Designation : " + employee.getEmpDesignation());
      System.out.println("Employee Department : " + employee.getEmpDepartment());
      System.out.println("Employee Leave Balance : " + employee.getEmpLeaveBalance());
    }
  }
    /**
     * Listing all the employee details.
    */
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    if (employee.length == 0) {
      System.out.println("No employees exists.");
    } else {
      for (Employee e : employee) {
        System.out.println("----------------");
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("----------------");
        System.out.println("Employee Id : " + e.getEmpId());
        System.out.println("Employee Full Name : " + e.getEmpFullName());
        System.out.println("Employee Email : " + e.getEmail());
        System.out.println("Employee Mobile : " + e.getEmpMobile());
        System.out.println("Date of Joining : " + e.getEmpDateOfJoining());
        System.out.println("Employee Designation : " + e.getEmpDesignation());
        System.out.println("Employee Department : " + e.getEmpDepartment());
        System.out.println("Employee Leave Balance : " + e.getEmpLeaveBalance());
      }
    }
  }
    /**
     * Listing leave History.
     */
  private void listLeaveHistory() {
    System.out.println("Enter the employee ID");
    int empId = input.nextInt();
    List<LeaveDetails> leaveDetails = LeaveDetails.leaveHistory(empId);
    if (leaveDetails.size() == 0) {
      System.out.println("Sorry, No records found for this emp id");
    } else {
      for (LeaveDetails ld : leaveDetails) {
        System.out.println("---------------------");
        System.out.println("Leave History Details");
        System.out.println("---------------------");
        System.out.println("Leave ID : " + ld.getLeaveId());
        System.out.println("Leave Start Date : " + ld.getLeaveStartDate());
        System.out.println("Leave End Date : " + ld.getLeaveEndDate());
        System.out.println("Leave Type : " + ld.getLeaveType());
        System.out.println("Leave Reason : " + ld.getLeaveReason());
        System.out.println("Leave Status : " + ld.getLeaveReason());
      }
    }
  }
    /**
     * Listing Manager Details.
     */
  private void listManagerDetail() {
    System.out.println("Enter the employee id : ");
    int empId = input.nextInt();
    Employee manager = Employee.findManager(empId);

    if (manager == null) {
      System.out.println("Sorry, No manager exists");
    } else {
      System.out.println("---------------");
      System.out.println("Manager Details");
      System.out.println("---------------");
      System.out.println("Manager ID : " + manager.getEmpId());
      System.out.println("Manager Full Name : " + manager.getEmpFullName());
      System.out.println("Manager Email : " + manager.getEmail());
      System.out.println("Manager Mobile : " + manager.getEmpMobile());
      System.out.println("Date of Joining : " + manager.getEmpDateOfJoining());
      System.out.println("Manager Designation : " + manager.getEmpDesignation());
      System.out.println("Manager Department : " + manager.getEmpDepartment());
    }

  }
  /**
   * no argument.
   */
  public final void viewLeaveByEmpId() {
    System.out.println("Enter the employee Id");
    int empId = input.nextInt();
    LeaveDetails leaveDetails = LeaveDetails.listById(empId);
    if (leaveDetails == null) {
      System.out.println("There is no record");
    } else {
      System.out.println("----------------");
      System.out.println("LEAVE DETAILS");
      System.out.println("----------------");
      System.out.println("Leave_ID : " + leaveDetails.getLeaveId());
      System.out.println("Leave_START_DATE : " + leaveDetails.getLeaveStartDate());
      System.out.println("Leave_END_DATE : " + leaveDetails.getLeaveEndDate());
      System.out.println("Leave_TYPE : " + leaveDetails.getLeaveType());
      System.out.println("Leave_REASON : " + leaveDetails.getLeaveReason());
      System.out.println("Leave_STATUS: " + leaveDetails.getLeaveStatus());
      System.out.println("Leave_APPLIED_ON : " + leaveDetails.getLeaveAppliedOn());
    }
  }
  /**
   * no argument.
   */
  public final void approveOrDeny() {
    System.out.println("Enter the Leave Id");
    int leaveId = input.nextInt();
    System.out.println("Enter the employee Id");
    int empId = input.nextInt();
    System.out.println("1 Approve 2 denied");
    String status = "";
    int choice = input.nextInt();
    switch (choice) {
      case 1:
        status = "APPROVED";
        LeaveDetails.approveById(leaveId, status);
        LeaveDetails.reducingLeaveBalance(empId);
        break;
      case 2:
        status = "DENIED";
        input.nextLine();
        System.out.println("Enter comments");
        String leaveComment = input.nextLine();
        LeaveDetails.denyById(leaveId, status, leaveComment);
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }
   /**
    * @throws ParseException throws exception.
    */
  public final void applyLeave() throws ParseException {

    System.out.println("enter employee id");
    int empId = option.nextInt();

    System.out.println("Enter the start date : ");
    String startDate = input.next();
    Date parsedStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);

    System.out.println("Enter the end date : ");
    String endDate = input.next();
    Date parsedEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    System.out.println("Select leave type : ");
    System.out.println("1. Earned Leave");
    System.out.println("2. Maternity Leave");
    System.out.println("3. Paternity Leave");
    int leavechoice = option.nextInt();
    String leaveType = "";
    switch (leavechoice) {
      case 1:
        leaveType = "EARNED_LEAVE";
        break;
      case 2:
        leaveType = "MATERNITY_LEAVE";
        break;
      case 3:
        leaveType = "PATERNITY_LEAVE";
        break;
      default:
        System.out.println("INVALID_CHOICE");
        // System.exit(0);
        Runtime.getRuntime().halt(0);
    }

    System.out.println("Enter the reason for leave : ");
    String leaveReason = option.next();

    System.out.println("Enter the leave Comment : ");
    String leaveComment = option.next();
    System.out.println("--------------------------");
    System.out.println(LeaveDetails.leaveApply(empId, parsedStartDate, parsedEndDate,
          leaveType, leaveReason, leaveComment));
    System.out.println("--------------------------");
    // System.exit(0);
    Runtime.getRuntime().halt(0);
  }
  /**
   * @param leaveId to set leave id.
   * @param employeeId to set employee id.
   * @param leaveStartDate to set leave start date.
   * @param leaveEndDate to set leave end date.
   * @param leaveType to set leave type.
   * @param leaveStatus to set leave status.
   * @param leaveAppliedOn to set leave applied on.
   */
  public final void listLeaveDetails(final int leaveId, final int employeeId,
      final Date leaveStartDate, final Date leaveEndDate, final String leaveType,
      final String leaveStatus, final Date leaveAppliedOn) {
    System.out.println("leave Id:" + leaveId);
    System.out.println("Employee Id:" + employeeId);
    System.out.println("Leave Start date:" + leaveStartDate);
    System.out.println("Leave End Date" + leaveEndDate);
    System.out.println("leave Type:" + leaveType);
    System.out.println("leave Status:" + leaveStatus);
    System.out.println("leave Applied on :" + leaveAppliedOn);
  }
  /**
   * @param args args is used as a parameter.
   * @throws ParseException throws parsed exception.
   */
  public static void main(final String[] args) throws ParseException {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }

}
