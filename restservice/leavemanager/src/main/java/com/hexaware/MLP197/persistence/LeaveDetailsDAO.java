package com.hexaware.MLP197.persistence;

import com.hexaware.MLP197.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

/**
 * The DAO class for employee leave details.
 */

/**
 * The DAO class for employee.
 */
public interface LeaveDetailsDAO {
  /**
   * returns all the leave details.
   * @return the list of all leave details
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();
  /**
   * returns all the leave details of given employee.
   * @param empID the employee id
   * @return the leave details of employee
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails find(@Bind("empID") int empID);
  /**
   * returns leave details of particular employee.
   * @param empID the employee id
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS "
            + "WHERE EMP_ID IN(SELECT E.EMP_ID FROM EMPLOYEES E "
            + "JOIN EMPLOYEES M ON E.EMP_MANAGER_ID=M.EMP_ID)")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails view(@Bind("empID")int empID);
  /**
   * approving the leave details of the employee.
   * @param leaveId the leave id
   * @param status the leave status
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS=:status WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
   void approve(@Bind("leaveId")int leaveId, @Bind("status") String status);
  /**
   * denying the leave details of given employee.
   * @param leaveId the leave id
   * @param status the leave status
   * @param leaveComment the leave comment
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS=:status, LEAVE_COMMENT=:leaveComment WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
  void deny(@Bind("leaveId")int leaveId,
            @Bind("status") String status,
            @Bind("leaveComment") String leaveComment);
  /**
   * reducing the leave balance in the employee table after approval.
   * @param empID the employee id
   */
  @SqlUpdate("UPDATE EMPLOYEES SET EMP_LEAVE_BALANCE = "
            + "EMP_LEAVE_BALANCE - (SELECT (LEAVE_END_DATE "
            + "- LEAVE_START_DATE) "
            + "FROM LEAVE_DETAILS WHERE EMP_ID =:empId ORDER BY "
            + "LEAVE_APPLIED_ON DESC LIMIT 1) WHERE EMP_ID =:empId")
    void reduce(@Bind("empId")int empID);
   /**
    * inserting leave details into leave tables.
    * @param empId the leave id
    * @param leaveStartDate the leave start date
    * @param leaveEndDate the leave end date
    * @param leaveType the leave type
    * @param leaveReason the leave reason
    * @param leaveComment the leave comment
    */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(LEAVE_START_DATE, "
            + "LEAVE_END_DATE, LEAVE_TYPE, LEAVE_REASON, EMP_ID, LEAVE_COMMENT) "
            + "VALUES(:leaveStartDate, :leaveEndDate, :leaveType, :leaveReason, :empId, :leaveComment)")
  @Mapper(LeaveDetailsMapper.class)
    void applyLeaveDAO(@Bind("empId") int empId, @Bind("leaveStartDate") Date leaveStartDate,
            @Bind("leaveEndDate") Date leaveEndDate, @Bind("leaveType") String leaveType,
            @Bind("leaveReason") String leaveReason, @Bind("leaveComment") String leaveComment);
   /**
    * getting all the leave details for given employee.
    * @param empId the employee id
    * @return the list of leaves
    */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_DETAILS.EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> getLeaveHistory(@Bind("empId") int empId);

    /**
     * close with no args is used to close the connection.
     */
  void close();
}
