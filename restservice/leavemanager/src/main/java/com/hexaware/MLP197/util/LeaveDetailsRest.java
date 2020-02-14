package com.hexaware.MLP197.util;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP197.model.LeaveDetails;

/**
 * This class provides a REST interface for the leace details entity.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {
  /**
   * Returns the list of leave history of certain employees.
   * @param empId the employee id
   * @return the lsit of leave history
   */
  @GET
  @Path("{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<LeaveDetails> viewLeaveDetails(@PathParam("empId") final int empId) {
    System.out.println("Employee Leave History");
    final List<LeaveDetails> leaveHistory = LeaveDetails.leaveHistory(empId);
    if (leaveHistory == null) {
      throw new NotFoundException("No leave history available");
    }
    return leaveHistory;
  }
}

