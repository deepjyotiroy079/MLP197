package com.hexaware.MLP197.model;

import com.hexaware.MLP197.persistence.DbConnection;
import com.hexaware.MLP197.persistence.LeaveDetailsDAO;
import java.util.Date;
import java.util.Objects;

/**
 * LeaveDetails
 * 
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

    public LeaveDetails() {
    }

    /**
     * constructer to initialize values
     * 
     * @param leaveId        to initialize leave id
     * @param leaveStartDate to initialize leave start date
     * @param leaveEndDate   to initialize leave end date
     * @param leaveType      to initialize leave type
     * @param leaveReason    to initialize leave reason
     * @param leaveStatus    to initialize leave status
     * @param leaveAppliedOn to initialize leave applied on
     * @param leaveComment   to initialize leave comment
     * @param empId          to initialize emp id
     */
    public LeaveDetails(final int leaveId, final Date leaveStartDate, final Date leaveEndDate, final String leaveType,
            final String leaveReason, final String leaveStatus, final Date leaveAppliedOn, final String leaveComment,
            final int empId) {
        this.leaveId = leaveId;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.leaveType = leaveType;
        this.leaveReason = leaveReason;
        this.leaveStatus = leaveStatus;
        this.leaveAppliedOn = leaveAppliedOn;
        this.leaveComment = leaveComment;
        this.empId = empId;
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
     * getting leave id
     * 
     * @return leaveId
     */
    public final int getLeaveId() {
        return leaveId;
    }

    /**
     * setting the leave id
     * 
     * @param leaveId
     */
    public final void setLeaveId(final int leaveId) {
        this.leaveId = leaveId;
    }

    /**
     * getting the leave start date
     * 
     * @return leavestartDate
     */
    public final Date getLeaveStartDate() {
        return leaveStartDate;
    }

    /**
     * setting the leaveStart date
     * 
     * @param leaveStartDate
     */
    public final void setLeaveStartDate(final Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    /**
     * getting the leave end date
     * 
     * @return leaveEnddate
     */
    public final Date getLeaveEndDate() {
        return leaveEndDate;
    }

    /**
     * setting the end date
     * 
     * @param leaveEndDate
     */
    public final void setLeaveEndDate(final Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    /**
     * getting the leave type
     * 
     * @return leaveType
     */
    public final String getLeaveType() {
        return leaveType;
    }

    /**
     * setting the leaveType
     * 
     * @param leaveType
     */
    public final void setLeaveType(final String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * getting the leave reason
     * 
     * @return leaveReason
     */
    public final String getLeaveReason() {
        return leaveReason;
    }

    /**
     * setting the leave reason
     * 
     * @param leaveReason
     */
    public final void setLeaveReason(final String leaveReason) {
        this.leaveReason = leaveReason;
    }

    /**
     * getting leave status
     * 
     * @return leaveStatus
     */
    public final String getLeaveStatus() {
        return leaveStatus;
    }

    /**
     * setting the leave status
     * 
     * @param leaveStatus
     */
    public final void setLeaveStatus(final String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    /**
     * getting the leave applied date
     * 
     * @return leaveAppliedOn
     */
    public final Date getLeaveAppliedOn() {
        return leaveAppliedOn;
    }

    /**
     * setting the Leave Applied date
     * 
     * @param leaveAppliedOn
     */
    public final void setLeaveAppliedOn(final Date leaveAppliedOn) {
        this.leaveAppliedOn = leaveAppliedOn;
    }

    /**
     * getting Leave comments from manager
     * 
     * @return leaveComment
     */
    public final String getLeaveComment() {
        return leaveComment;
    }

    /**
     * setting the Leave comment
     * 
     * @param leaveComment
     */
    public final void setLeaveComment(final String leaveComment) {
        this.leaveComment = leaveComment;
    }

    /**
     * getting Employee id
     * 
     * @return empId
     */
    public final int getEmpId() {
        return empId;
    }

    /**
     * setting the employee Id
     * 
     * @param empId
     */
    public final void setEmpId(final int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "LeaveDetails [empId=" + empId + ", leaveAppliedOn=" + leaveAppliedOn + ", leaveComment=" + leaveComment
                + ", leaveEndDate=" + leaveEndDate + ", leaveId=" + leaveId + ", leaveReason=" + leaveReason
                + ", leaveStartDate=" + leaveStartDate + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType
                + "]";
    }

    private static LeaveDetailsDAO dao() {
        final DbConnection db = new DbConnection();
        return db.getConnect().onDemand(LeaveDetailsDAO.class);
    }

    public static void leaveApply(
        final int empId,
        final Date leaveStartDate,
        final Date leaveEndDate,
        final String leaveType,
        final String leaveReason,
        final String leaveComment) {
        
        dao().applyLeaveDAO(empId, leaveStartDate, leaveEndDate, leaveType, leaveReason, leaveComment);
    }
}