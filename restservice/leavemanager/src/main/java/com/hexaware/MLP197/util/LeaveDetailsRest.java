package com.hexaware.MLP197.util;

// import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP197.model.LeaveDetails;
/**
 * This class provides a REST interface for the leaveDetail entity.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {
  /**
   * Returns a specific employee leave history.
   * @param empId the id of the employee
   * @return leave history
   */
  @GET
  @Path("/leaveHistory/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<LeaveDetails> leaveHistory(@PathParam("empId") final int empId) {
    final List<LeaveDetails> empl = LeaveDetails.leaveHistory(empId);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + empId);
    }
    return empl;
  }
  /**
   * Returns leaveStatus of Employee.
   * @param leaveDetails of Employee
   * @return leaveStatus
   */
  @POST
  @Path("/deny")
  @Consumes(MediaType.APPLICATION_JSON)
  public final String denyById(final LeaveDetails leaveDetails) {
    return LeaveDetails.denyById(leaveDetails.getLeaveId(), leaveDetails.getLeaveComment());
  }
   /**
    * applying leave.
    * @param leaveDetails leave details object
    * @return the success string
    */
  @POST
  @Path("/applyLeave")
  @Consumes(MediaType.APPLICATION_JSON)
  public final String applyLeave(final LeaveDetails leaveDetails) {
    return LeaveDetails.leaveApply(leaveDetails.getEmpId(),
                                   leaveDetails.getLeaveStartDate(),
                                   leaveDetails.getLeaveEndDate(),
                                   leaveDetails.getLeaveNoOfDays(),
                                   leaveDetails.getLeaveType().toString(),
                                   leaveDetails.getLeaveReason());
  }
  /**
   * @param leaveDetails leaveDetails object.
   * @return approves.
   */
  @POST
  @Path("/approveLeave")
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approveLeave(final LeaveDetails leaveDetails) {
    int ld = leaveDetails.getLeaveNoOfDays();
    Date d1 = leaveDetails.getLeaveEndDate();
    Date d2 = leaveDetails.getLeaveStartDate();
    long day = leaveDetails.daysBetween(d1, d2);
    if (ld == day) {
      LeaveDetails.reducingLeaveBalance(leaveDetails.getLeaveId(), leaveDetails.getEmpId());
      return LeaveDetails.approveById(leaveDetails.getLeaveId());
    } else {
      return "enter correct leave no of days";
    }

  }
  /**
   * viewing pending leaveDetails under a manager.
   * @param mgrId manager id
   * @return list of pending leaves
   */
  @GET
  @Path("/viewPendingLeaves/{mgrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<LeaveDetails> viewPendingLeaves(@PathParam("mgrId") final int mgrId) {
    final List<LeaveDetails> mgr = LeaveDetails.viewPendingLeaves(mgrId);
    if (mgr == null) {
      throw new NotFoundException("No such Manager ID: " + mgrId);
    }
    return mgr;
  }
  /**
   * viewing leave details by id.
   * @param leaveId the leave id
   * @return leave detail
   */
  @GET
  @Path("/leave/{leaveId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails viewLeaveDetails(@PathParam("leaveId") final int leaveId) {
    final LeaveDetails leave = LeaveDetails.viewLeaveById(leaveId);
    if (leave == null) {
      throw new NotFoundException("No such Leave ID: " + leaveId);
    }
    return leave;
  }
}
