package com.hexaware.MLP197.persistence;

import com.hexaware.MLP197.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

/**
 * The DAO class for employee.
 */
public interface LeaveDetailsDAO {
  /**
   * return all the details of all the employees.
   * 
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEES")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();


  @SqlUpdate("INSERT INTO LEAVE_DETAILS(LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE, LEAVE_REASON, EMP_ID, LEAVE_COMMENT) "+
              "VALUES(:leaveStartDate, :leaveEndDate, :leaveType, :leaveReason, :empId, :leaveComment)")
  @Mapper(LeaveDetailsMapper.class)
  void applyLeaveDAO(@Bind("empId") int empId, @Bind("leaveStartDate") Date leaveStartDate,
      @Bind("leaveEndDate") Date leaveEndDate, @Bind("leaveType") String leaveType,
      @Bind("leaveReason") String leaveReason, @Bind("leaveComment") String leaveComment);

  /**
   * close with no args is used to close the connection.
   */
  void close();
}
