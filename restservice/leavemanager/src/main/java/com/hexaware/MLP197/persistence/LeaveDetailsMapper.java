package com.hexaware.MLP197.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.MLP197.model.LeaveDetails;

/**
 * Mapper class to map from result set to LeaveDetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new LeaveDetails(rs.getInt("LEAVE_ID"),
                            rs.getDate("LEAVE_START_DATE"),
                            rs.getDate("LEAVE_END_DATE"),
                            rs.getInt("LEAVE_NUMBER_OF_DAYS"),
                            rs.getString("LEAVE_TYPE"),
                            rs.getString("LEAVE_REASON"),
                            rs.getString("LEAVE_STATUS"),
                            rs.getDate("LEAVE_APPLIED_ON"),
                            rs.getString("LEAVE_COMMENT"),
                            rs.getInt("EMP_ID"));
  }
}
