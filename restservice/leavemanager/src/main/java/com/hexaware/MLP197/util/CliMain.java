package com.hexaware.MLP197.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.hexaware.MLP197.model.Employee;
import com.hexaware.MLP197.model.LeaveDetails;

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
    System.out.println("1. List All Employees Info.");
    System.out.println("2. Display Employee Info.");
    System.out.println("3. Apply leave.");
    System.out.println("4. Viewing Manager Info.");
    System.out.println("5. Viewing Leave History.");
    System.out.println("6. Exit");
    
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
            applyLeave();
            break;
        case 4:
            listManagerDetail();
            break;
        case 5:
            listLeaveHistory();
        case 6:
            // halt since normal exit throws a stacktrace due to jdbc threads not responding
            Runtime.getRuntime().halt(0);
        default:
            System.out.println("Choose either 1, 2 or 3");
        }
        mainMenu();
    }

    /**
     * Listing leave History
     */
    private void listLeaveHistory() {
        System.out.println("Leave History");
        System.out.println("--------------");
        System.out.println("Enter the employee ID");
        int empId = input.nextInt();
        LeaveDetails leaveDetails[] = LeaveDetails.leaveHistory(empId);
        if(leaveDetails == null) {
            System.out.println("Sorry, No records found for this emp id");
        } else {
            for (LeaveDetails ld : leaveDetails) {
                System.out.println("Leave History Details");
                System.out.println("---------------------");
                System.out.println("Leave ID : "+ld.getLeaveId());
                System.out.println("Leave Start Date : "+ld.getLeaveStartDate());
                System.out.println("Leave End Date : "+ld.getLeaveEndDate());
                System.out.println("Leave Type : "+ld.getLeaveType());
                System.out.println("Leave Reason : "+ld.getLeaveReason());
                System.out.println("Leave Status : "+ld.getLeaveReason());

            }
        }
    }

    /**
     * Listing manager details of particular employee
     */
    private void listManagerDetail() {
        System.out.println("Enter the employee id : ");
        int empId = input.nextInt();
        Employee manager = Employee.findManager(empId);

        if (manager == null) {
            System.out.println("Sorry, No manager exists");
        } else {
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
     * listing single employee
     */
    private void listEmployeeDetail() {
        System.out.println("Enter an Employee Id");
        int empId = option.nextInt();
        Employee employee = Employee.listById(empId);
        if (employee == null) {
            System.out.println("Sorry, No such employee");
        } else {
            System.out.println("Employee Details");
            System.out.println("---------------");
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
     * Listing all the employees details
     */
    private void listEmployeesDetails() {
        Employee[] employee = Employee.listAll();
        for (Employee e : employee) {
            System.out.println("Employee Id" + e.getEmpId());
            System.out.println("Employee Full Name : " + e.getEmpFullName());
            System.out.println("Employee Email : " + e.getEmail());
            System.out.println("Employee Mobile : " + e.getEmpMobile());
            System.out.println("Date of Joining : " + e.getEmpDateOfJoining());
            System.out.println("Employee Designation : " + e.getEmpDesignation());
            System.out.println("Employee Department : " + e.getEmpDepartment());
            System.out.println("Employee Leave Balance : " + e.getEmpLeaveBalance());
        }
    }

    public void denyLeave(int employeeid) {
        System.out.println("employee id" + employeeid);
        System.out.println("Denied");
        System.out.println("Comments");
    }

    public void approveLeave(int employeeId) {
        System.out.println("employee id:" + employeeId);
        System.out.println("approved");
        System.out.println("type comments:");

    }

    /**
     * Function to Apply leave
     * 
     * @throws ParseException
     */
    public void applyLeave() throws ParseException {

        System.out.println("enter employee id");
        int empId = option.nextInt();

        System.out.println("Enter the start date : ");
        String startDate = input.next();
        Date parsedStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);

        System.out.println("Enter the end date : ");
        String endDate = input.next();
        Date parsedEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        System.out.println("Select leave type");
        System.out.println("1. optional leave");
        System.out.println("2. maternity leave");
        System.out.println("3. paternity leave");
        int leavechoice = option.nextInt();
        String leaveType = "";
        switch (leavechoice) {
        case 1:
            leaveType = "OPTIONAL_LEAVE";
            break;
        case 2:
            leaveType = "MATERNITY_LEAVE";
            break;
        case 3:
            leaveType = "PATERNITY_LEAVE";
            break;
        default:
            System.out.println("INVALID_CHOICE");
            System.exit(0);
        }

        System.out.println("enter the reason for leave");
        String leaveReason = option.next();

        System.out.println("Enter the leave Comment");
        String leaveComment = option.next();
        LeaveDetails.leaveApply(empId, parsedStartDate, parsedEndDate, leaveType, leaveReason, leaveComment);
        System.out.println("leave applied successfully");
        System.exit(0);

    }

    public void listLeaveDetails(int leaveId, int employeeId, Date leaveStartDate, Date leaveEndDate, String leaveType,
            String leaveStatus, Date leaveAppliedOn) {
        System.out.println("leave Id:" + leaveId);
        System.out.println("Employee Id:" + employeeId);
        System.out.println("Leave Start date:" + leaveStartDate);
        System.out.println("Leave End Date" + leaveEndDate);
        System.out.println("leave Type:" + leaveType);
        System.out.println("leave Status:" + leaveStatus);
        System.out.println("leave Applied on :" + leaveAppliedOn);
    }

    /**
     * The main entry point.
     * 
     * @param ar the list of arguments
     * @throws ParseException
     */
    public static void main(final String[] args) throws ParseException {
        final CliMain mainObj = new CliMain();
        mainObj.mainMenu();
    }

}
