package com.hexaware.MLP197.util;

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
    return LeaveDetails.denyById(leaveDetails.getLeaveId(),
           leaveDetails.getLeaveStatus(), leaveDetails.getLeaveComment());
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
                                   leaveDetails.getLeaveType().toString(),
                                   leaveDetails.getLeaveReason(),
                                   leaveDetails.getLeaveComment());
  }
  /**
   * @param leaveDetails leaveDetails object.
   * @return approves.
   */
  @POST
  @Path("/approveLeave")
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approveLeave(final LeaveDetails leaveDetails) {
    return LeaveDetails.approveById(leaveDetails.getLeaveId(), leaveDetails.getLeaveStatus());
  }
}
