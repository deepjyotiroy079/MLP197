package com.hexaware.MLP197.model;

import java.text.ParseException;
import com.hexaware.MLP197.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

//import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;

/**
 * Test class for LeaveDetails.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * test for setters.
   * @throws ParseException throws error.
   */
  @Test
  public final void testLeaveDetailsSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    LeaveDetails ld = new  LeaveDetails();
    ld.setLeaveId(1);
    ld.setLeaveStartDate(sdf.parse("2021-09-12"));
    ld.setLeaveEndDate(sdf.parse("2021-09-14"));
    ld.setLeaveNoOfDays(20);
    ld.setLeaveType("sick leave");
    ld.setLeaveReason("fever");
    ld.setLeaveStatus("approved");
    ld.setLeaveAppliedOn(sdf.parse("2021-09-12"));
    ld.setLeaveComment("take care");
    ld.setEmpId(1);

    assertEquals(1, ld.getLeaveId());
    assertEquals(sdf.parse("2021-09-12"), ld.getLeaveStartDate());
    assertEquals(sdf.parse("2021-09-14"), ld.getLeaveEndDate());
    assertEquals(20, ld.getLeaveNoOfDays());
    assertEquals("sick leave", ld.getLeaveType());
    assertEquals("fever", ld.getLeaveReason());
    assertEquals("approved", ld.getLeaveStatus());
    assertEquals(sdf.parse("2021-09-12"), ld.getLeaveAppliedOn());
    assertEquals("take care", ld.getLeaveComment());
    assertEquals(1, ld.getEmpId());
  }
  /**
   * testing getter for leave details.
   * @throws ParseException for the dates
   */
  @Test
  public final void testLeaveDetailsGetter() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld = new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1);

    assertEquals(ld.getLeaveId(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveId());

    assertEquals(ld.getLeaveStartDate(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveStartDate());

    assertEquals(ld.getLeaveEndDate(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveEndDate());

    assertEquals(ld.getLeaveType(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveType());

    assertEquals(ld.getLeaveReason(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveReason());

    assertEquals(ld.getLeaveStatus(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveStatus());

    assertEquals(ld.getLeaveAppliedOn(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveAppliedOn());

    assertEquals(ld.getLeaveComment(), new LeaveDetails(1, sdf.parse("2020-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getLeaveComment());

    assertEquals(ld.getEmpId(), new LeaveDetails(1, sdf.parse("2021-09-12"), sdf.parse("2021-09-14"), 20,
          "sick leave", "fever", "approved", sdf.parse("2021-02-09"), "take care", 1).getEmpId());
  }
/**
 * Test for LeaveDetails class.
 * @throws ParseException for LeaveDetails
 */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sd = sdf.parse("2021-02-05");
    Date ed = sdf.parse("2021-02-07");
    Date ad = sdf.parse("2021-02-04");
    LeaveDetails e100 = new LeaveDetails(1, sdf.parse("2021-02-05"),
            sdf.parse("2021-02-07"), 20, "Sick", "Not well", "Pending", sdf.parse("2021-02-04"), "no", 4);
    assertEquals(1, e100.getLeaveId());
    assertEquals(sd, e100.getLeaveStartDate());
    assertEquals(ed, e100.getLeaveEndDate());
    assertEquals(20, e100.getLeaveNoOfDays());
    assertEquals("Sick", e100.getLeaveType());
    assertEquals("Not well", e100.getLeaveReason());
    assertEquals("Pending", e100.getLeaveStatus());
    assertEquals(ad, e100.getLeaveAppliedOn());
    assertEquals("no", e100.getLeaveComment());
    assertEquals(4, e100.getEmpId());
    LeaveDetails e101 = null;
    assertFalse(e100.equals(e101));
    Employee e1 = null;
    assertFalse(e100.equals(e1));
  }
  /**
   * @param dao database access object.
   */
  @Test
  public final void testapproveById(@Mocked final LeaveDetailsDAO dao) {
    final String message = "Leave Approved";
    // new Expectations() {
    //   {
    //     dao.approve(1, "APPROVED");
    //   }
    // };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    assertEquals(message, LeaveDetails.approveById(1));
  }
  /**
   * @param dao database access object.
   */
  @Test
  public final void testreducingLeaveBalance(@Mocked final LeaveDetailsDAO dao) {
    final String message = "Leave Balance reduced";
    new Expectations() {
      {
        dao.reduce(1, 2);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    assertEquals(message, LeaveDetails.reducingLeaveBalance(1, 2));
  }
  /**
   * testing the hashcode for leave details.
   * @throws ParseException for date format
   */
  @Test
  public final void testHashCode() throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = sdf.parse("2021-02-05");
    final Date endDate = sdf.parse("2021-02-07");
    final Date appliedOn = sdf.parse("2021-02-01");

    final LeaveDetails leaveDetails = new LeaveDetails(1, startDate, endDate, 20, "OPTIONAL_LEAVE", "SICK", "PENDING",
        appliedOn, "take_leave", 2);
    assertEquals(leaveDetails.hashCode(),
        new LeaveDetails(1, startDate, endDate, 20, "OPTIONAL_LEAVE", "SICK", "PENDING", appliedOn, "take_leave", 2)
            .hashCode());
  }
  /**
   * testing the equals method.
   * @throws ParseException for dates
   */
  @Test
  public final void testEqualsMethod() throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = sdf.parse("2021-02-05");
    final Date endDate = sdf.parse("2021-02-07");
    final Date appliedOn = sdf.parse("2021-02-01");
    LeaveDetails ld1 = new LeaveDetails(1, startDate, endDate, 20, "OPTIONAL_LEAVE", "SICK", "PENDING",
            appliedOn, "take_leave", 2);
    LeaveDetails ld2 = new LeaveDetails(1, startDate, endDate, 20, "OPTIONAL_LEAVE", "SICK", "PENDING",
            appliedOn, "take_leave", 2);
    LeaveDetails ld3 = new LeaveDetails(2, startDate, endDate, 20, "EARNED_LEAVE", "SICK", "PENDING",
            appliedOn, "take_leave", 3);
    assertEquals(ld1, ld2);
    assertNotEquals(ld2, ld3);
    assertNotEquals(ld1, ld3);
  }
  /**
   * testing viewing the leave history.
   * @param dao the database access object
   * @throws ParseException for the dates
   */
  @Test
  public final void testViewingLeaveHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = sdf.parse("2021-01-21");
    final Date endDate = sdf.parse("2021-01-22");
    final Date appliedOn = sdf.parse("2021-01-30");

    new Expectations() {
      {
        final List<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        ld.add(new LeaveDetails(1, startDate, endDate, 20,
              "OPTIONAL_LEAVE", "SICK", "PENDING", appliedOn, "take_leave", 2));

        dao.getLeaveHistory(2); result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> leaveDetails = LeaveDetails.leaveHistory(2);
    assertEquals(1, leaveDetails.size());
    assertEquals(new LeaveDetails(1, startDate, endDate, 20, "OPTIONAL_LEAVE",
          "SICK", "PENDING", appliedOn, "take_leave", 2), leaveDetails.get(0));
  }
  /**
   * Test for denying the leave.
   * @param dao database access object.
   */
  @Test
  public final void testdenyById(@Mocked final LeaveDetailsDAO dao) {
    final String message = "Leave Denied";
    // new Expectations() {
    //   {
    //     dao.deny(4, "DENIED", "NO LEAVE");
    //   }
    // };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    assertEquals(message, LeaveDetails.denyById(4, "NO LEAVE"));
  }
  /**
   * testing apply leave functionality.
   * @param dao the leave details dao object
   * @throws ParseException for the dates
   */
  @Test
  public final void testLeaveApply(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String message = "LEAVE APPLIED SUCCESSFULLY";
    // new Expectations() {
    //   {
    //     dao.applyLeaveDAO(1, sdf.parse("2020-02-26"), sdf.parse("2020-02-29"), "EARNED_LEAVE",
    //         "tour", "leave");
    //   }
    // };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    assertEquals(message, LeaveDetails.leaveApply(1, sdf.parse("2020-03-03"), sdf.parse("2020-03-13"), 3,
                "EARNED_LEAVE", "tour"));
  }
}
