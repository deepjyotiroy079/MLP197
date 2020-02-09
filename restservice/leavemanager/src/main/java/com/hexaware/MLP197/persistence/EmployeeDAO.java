package com.hexaware.MLP197.persistence;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP197.model.Employee;
import com.hexaware.MLP197.model.EmployeeReport;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEES E, EMPLOYEES M WHERE E.EMP_MANAGER_ID = M.EMP_ID")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEES WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * returns all the manager details.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT M.* FROM EMPLOYEES E "
            + "JOIN EMPLOYEES M ON "
            + "E.EMP_MANAGER_ID = M.EMP_ID "
            + "WHERE E.EMP_ID = :empID")
  @Mapper(EmployeeManagerMapper.class)
  Employee findManager(@Bind("empID") int empID);
  /**
   * inserts leave details.
   * @param leaveStartDate the leave starting date
   * @param leaveEndDate the leave ending date
   * @param leaveType the leave type
   * @param empId the employee id
   * @param leaveComment the leave comment
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS"
            + "(LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_TYPE,EMP_ID,LEAVE_COMMENT) "
            + "VALUES(:leaveStartDate,:leaveEndDate,:leaveType,:empId,:leaveComment)")
  void applyLeaveDAO(@Bind("leaveStartDate") Date leaveStartDate,
      @Bind("leaveEndDate") Date leaveEndDate, @Bind("leaveType") String leaveType, @Bind("empId") int empId,
      @Bind("leaveComment") String leaveComment);
  // /**
  //  * displays the employee details of employee working in given department.
  //  * @param department the department name
  //  * @return the list of employees working in given department
  //  */
  // @SqlQuery("SELECT * FROM EMPLOYEES "
  //          + "WHERE EMP_DEPARTMENT = :department")
  // @Mapper(EmployeeMapper.class)
  // List<Employee> employeesByDepartment(@Bind("department") String department);
  /**
   * returns the list of all the employees working under a given manager.
   * @param argsManagerId the manager id
   * @return the list of employees
   */
  @SqlQuery("SELECT * FROM EMPLOYEES WHERE EMP_MANAGER_ID = :managerId")
  @Mapper(EmployeeMapper.class)
  List<Employee> findEmployeeViaManager(@Bind("managerId") int argsManagerId);
  /**
   * returns mapping of department with the employee count.
   * @return the mapping of department and the employee count
   */
  @SqlQuery("SELECT EMP_DEPARTMENT, COUNT(EMP_ID) AS NUMBER_OF_EMPLOYEES FROM EMPLOYEES GROUP BY EMP_DEPARTMENT")
  @Mapper(EmployeeReportMapper.class)
  List<EmployeeReport> getEmployeeReport();
  /**
   * close with no args is used to close the connection.
   */
  void close();
}
