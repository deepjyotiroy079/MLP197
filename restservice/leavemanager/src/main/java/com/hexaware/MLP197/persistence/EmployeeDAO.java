package com.hexaware.MLP197.persistence;

import com.hexaware.MLP197.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO {
  /**
   * return all the details of all the employees.
   * 
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEES E, EMPLOYEES M WHERE E.EMP_MANAGER_ID = M.EMP_ID")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * 
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEES WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  @SqlQuery("SELECT M.* FROM EMPLOYEES E "+
            "JOIN EMPLOYEES M ON E.EMP_MANAGER_ID = M.EMP_ID WHERE E.EMP_ID = :empID")
  @Mapper(EmployeeManagerMapper.class)
  Employee findManager(@Bind("empID") int empID);
  
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_TYPE,EMP_ID,LEAVE_COMMENT)VALUES(:leaveStartDate,:leaveEndDate,:leaveType,:empId,:leaveComment)")
  void applyLeaveDAO(@Bind("leaveStartDate") Date leaveStartDate,
      @Bind("leaveEndDate") Date leaveEndDate, @Bind("leaveType") String leaveType,@Bind("empId") int empId,
      @Bind("leaveComment") String leaveComment);

  /**
   * close with no args is used to close the connection.
   */
  void close();
}
