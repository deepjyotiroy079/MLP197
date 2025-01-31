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
   * returns all the leave details of given employee.
   * @param leaveId the employee id
   * @return the leave details of employee
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails viewLeaveByLd(@Bind("leaveId") int leaveId);
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
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS='APPROVED' WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
   void approve(@Bind("leaveId")int leaveId);
  /**
   * denying the leave details of given employee.
   * @param leaveId the leave id
   * @param leaveComment the leave comment
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS='DENIED', LEAVE_COMMENT=:leaveComment WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
  void deny(@Bind("leaveId")int leaveId,
            @Bind("leaveComment") String leaveComment);
  /**
   * getting total number of leaves.
   * @param empId empId
   * @return total leaves taken
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_NUMBER_OF_DAYS = (LEAVE_END_DATE - LEAVE_START_DATE) WHERE EMP_ID =:empId")
  @Mapper(LeaveDetailsMapper.class)
  int findTotalLeaves(@Bind("empId")int empId);
  /**
   * reducing the leave balance in the employee table after approval.
   * @param leaveId the leave id
   * @param empId the employee id
   */
  @SqlUpdate("UPDATE EMPLOYEES SET EMP_LEAVE_BALANCE = EMP_LEAVE_BALANCE - (SELECT LEAVE_NUMBER_OF_DAYS"
      + " FROM LEAVE_DETAILS WHERE LEAVE_ID =:leaveId)"
      + " WHERE EMP_ID = (SELECT EMP_ID FROM LEAVE_DETAILS WHERE LEAVE_ID=:leaveId)")
  void reduce(@Bind("leaveId")int leaveId, @Bind("empId")int empId);

  // /**
  //  * exhausting the leave balance.
  //  * @param empId leaveId
  //  */
  // @SqlUpdate("UPDATE EMPLOYEES SET EMP_LEAVE_BALANCE = 0 "
  //             + "WHERE EMP_ID =:empId")
  // @Mapper(LeaveDetailsMapper.class)
  // void exhaustingEarnedLeave(@Bind("empId")int empId);
   /**
    * inserting leave details into leave tables.
    * @param empId the leave id
    * @param leaveStartDate the leave start date
    * @param leaveEndDate the leave end date
    * @param leaveNumberOfDays the leave number of days
    * @param leaveType the leave type
    * @param leaveReason the leave reason
    */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(LEAVE_START_DATE, "
            + "LEAVE_END_DATE, LEAVE_NUMBER_OF_DAYS, LEAVE_TYPE, LEAVE_REASON, EMP_ID) "
            + "VALUES(:leaveStartDate, :leaveEndDate, :leaveNumberOfDays,:leaveType, "
            + ":leaveReason, :empId)")
  @Mapper(LeaveDetailsMapper.class)
    void applyLeaveDAO(@Bind("empId") int empId, @Bind("leaveStartDate") Date leaveStartDate,
            @Bind("leaveEndDate") Date leaveEndDate, @Bind("leaveNumberOfDays") int leaveNumberOfDays,
            @Bind("leaveType") String leaveType,
            @Bind("leaveReason") String leaveReason);
   /**
    * getting all the leave details for given employee.
    * @param empId the employee id
    * @return the list of leaves
    */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_DETAILS.EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> getLeaveHistory(@Bind("empId") int empId);
  /**
   * Returning all pending leaveDetails under a particular manager.
   * @param mgrId the manager Id
   * @return the list pending leaves under a manager
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_STATUS = 'PENDING'"
      + "AND EMP_ID IN (SELECT E.EMP_ID FROM EMPLOYEES E, EMPLOYEES M WHERE E.EMP_MANAGER_ID =:mgrId)")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pendingDetails(@Bind("mgrId") int mgrId);

  /**
   * listing leave details by id.
   * @param leaveId the leave id
   * @return the leave details for given id
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails displayLeaveById(@Bind("leaveId") int leaveId);
    /**
     * close with no args is used to close the connection.
     */
  void close();
}
