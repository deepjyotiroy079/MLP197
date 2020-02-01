package com.hexaware.MLP197.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.hexaware.MLP197.persistence.DbConnection;
import com.hexaware.MLP197.persistence.LeaveDetailsDAO;

/**
 * LeaveDetails.
 * @author MLP197
 */
public class LeaveDetails {
    /**
     * leaveId to store leave id leaveStartDate store start date of the leave.
     * leaveEndDate store end date of the leave leaveType to store leaveType of the.
     * leave leaveReason to store the reason of the leave leaveStatus to store
     * status of the leave. leaveAppliedOn to store date on which the leave was
     * applied. leaveComment to store the comments given by the manager empId to
     * store the employee.
     */
  private int leaveId;
  private Date leaveStartDate;
  private Date leaveEndDate;
  private String leaveType;
  private String leaveReason;
  private String leaveStatus;
  private Date leaveAppliedOn;
  private String leaveComment;
  private int empId;

    /**
     * No argument constructor.
     */
  public LeaveDetails() {
  }

    /**
     * constructer to initialize values.
     * @param argLeaveId        to initialize leave id.
     * @param argLeaveStartDate to initialize leave start date.
     * @param argLeaveEndDate   to initialize leave end date.
     * @param argLeaveType      to initialize leave type.
     * @param argLeaveReason    to initialize leave reason.
     * @param argLeaveStatus    to initialize leave status.
     * @param argLeaveAppliedOn to initialize leave applied on.
     * @param argLeaveComment   to initialize leave comment.
     * @param argEmpId          to initialize emp id.
     */
  public LeaveDetails(final int argLeaveId, final Date argLeaveStartDate, final Date argLeaveEndDate,
        final String argLeaveType, final String argLeaveReason, final String argLeaveStatus,
         final Date argLeaveAppliedOn, final String argLeaveComment, final int argEmpId) {
    this.leaveId = argLeaveId;
    this.leaveStartDate = argLeaveStartDate;
    this.leaveEndDate = argLeaveEndDate;
    this.leaveType = argLeaveType;
    this.leaveReason = argLeaveReason;
    this.leaveStatus = argLeaveStatus;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveComment = argLeaveComment;
    this.empId = argEmpId;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LeaveDetails emp = (LeaveDetails) obj;
    if (Objects.equals(leaveId, emp.leaveId) && Objects.equals(leaveStartDate, emp.leaveStartDate)
            && Objects.equals(leaveEndDate, emp.leaveEndDate) && Objects.equals(leaveType, emp.leaveType)
            && Objects.equals(leaveStatus, emp.leaveStatus) && Objects.equals(leaveReason, emp.leaveReason)
            && Objects.equals(empId, emp.empId) && Objects.equals(leaveComment, emp.leaveComment)
            && Objects.equals(leaveAppliedOn, emp.leaveAppliedOn)) {
      return true;
    }
    return false;
  }

  @Override
    public final int hashCode() {
    return Objects.hash(leaveId, leaveStartDate, leaveEndDate, leaveType, leaveStatus, leaveReason, empId,
    leaveComment, leaveAppliedOn);
  }

    /**
     * getting leave id.
     * @return leaveId.
     */
  public final int getLeaveId() {
    return leaveId;
  }

    /**
     * setting the leave id.
     * @param argLeaveId to set the leaveId.
     */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

    /**
     * getting the leave start date.
     * @return leavestartDate.
     */
  public final Date getLeaveStartDate() {
    return leaveStartDate;
  }

    /**
     * setting the leaveStart date.
     * @param argLeaveStartDate to set the Leave start date.
     */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate = argLeaveStartDate;
  }

    /**
     * getting the leave end date.
     * @return leaveEnddate.
     */
  public final Date getLeaveEndDate() {
    return leaveEndDate;
  }

    /**
     * setting the end date.
     * @param argLeaveEndDate to set the leave end date.
     */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = argLeaveEndDate;
  }

    /**
     * getting the leave type.
     * @return leaveType.
     */
  public final String getLeaveType() {
    return leaveType;
  }

    /**
     * setting the leaveType.
     * @param argLeaveType to set the leave type.
     */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = argLeaveType;
  }

    /**
     * getting the leave reason.
     * @return leaveReason.
     */
  public final String getLeaveReason() {
    return leaveReason;
  }

    /**
     * setting the leave reason.
     * @param argLeaveReason to set the leave reason.
     */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

    /**
     * getting leave status.
     * @return leaveStatus.
     */
  public final String getLeaveStatus() {
    return leaveStatus;
  }

    /**
     * setting the leave status.
     * @param argLeaveStatus to set the leave status.
     */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

    /**
     * getting the leave applied date.
     * @return leaveAppliedOn.
     */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

    /**
     * setting the Leave Applied date.
     * @param argLeaveAppliedOn to set the leave applied on.
     */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

    /**
     * getting Leave comments from manager.
     * @return leaveComment.
     */
  public final String getLeaveComment() {
    return leaveComment;
  }

    /**
     * setting the Leave comment.
     * @param argLeaveComment to set the leave comment.
     */
  public final void setLeaveComment(final String argLeaveComment) {
    this.leaveComment = argLeaveComment;
  }

    /**
     * getting Employee id.
     * @return empId.
     */
  public final int getEmpId() {
    return empId;
  }

    /**
     * setting the employee Id.
     * @param argEmpId to set the employee id.
     */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

    // private static LeaveDetailsDAO dao() {
    //     final DbConnection db = new DbConnection();
    //     return db.getConnect().onDemand(LeaveDetailsDAO.class);
    // }
    /**
     * @param empID to set empid.
     * @return empid.
     */
  public static LeaveDetails listById(final int empID) {
    return dao().find(empID);
  }
    /**
     * @param leaveId to set leave id.
     * @param status to set status of leave.
     */
  public static void approveById(final int leaveId, final String status) {
    dao().approve(leaveId, status);
  }
  /**
   * @param leaveId to set leaveid.
   * @param status to set status of leave.
   * @param leaveComment to set leave comment.
   */
  public static void denyById(final int leaveId, final String status, final String leaveComment) {
    dao().deny(leaveId, status, leaveComment);
  }
  /**
   * @param empId to set empid.
   */
  public static void reducingLeaveBalance(final int empId) {
    dao().reduce(empId);
  }
  @Override
  public final String toString() {
    return "LeaveDetails [empId=" + empId + ", leaveAppliedOn=" + leaveAppliedOn + ", leaveComment=" + leaveComment
            + ", leaveEndDate=" + leaveEndDate + ", leaveId=" + leaveId + ", leaveReason=" + leaveReason
                + ", leaveStartDate=" + leaveStartDate + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType
                + "]";
  }
    /**
     * @return LeaveDetailsDAO.
     */
  private static LeaveDetailsDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

    /**
     * @param argEmpId to set the arg emp id.
     * @param argLeaveStartDate to set the arg leave start date.
     * @param argLeaveEndDate to set the arg leave end date.
     * @param argLeaveType to set the arg leave type.
     * @param argLeaveReason to set the arg leave reason.
     * @param argLeaveComment to set the arg leave comment.
     */
  public static void leaveApply(final int argEmpId, final Date argLeaveStartDate, final Date argLeaveEndDate,
      final String argLeaveType, final String argLeaveReason, final String argLeaveComment) {

    dao().applyLeaveDAO(argEmpId, argLeaveStartDate, argLeaveEndDate, argLeaveType, argLeaveReason, argLeaveComment);
  }
    /**
     * @param argEmpId to set arg emp id.
     * @return empid.
     */
  public static LeaveDetails[] leaveHistory(final int argEmpId) {
    final List<LeaveDetails> es = dao().getLeaveHistory(argEmpId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
}
