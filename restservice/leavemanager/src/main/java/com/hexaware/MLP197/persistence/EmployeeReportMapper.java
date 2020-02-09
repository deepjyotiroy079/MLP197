package com.hexaware.MLP197.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP197.model.EmployeeReport;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeReportMapper implements ResultSetMapper<EmployeeReport> {
  /**
   * @param index the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final EmployeeReport map(final int index, final ResultSet rs,
          final StatementContext ctx) throws SQLException {

    return new EmployeeReport(rs.getString("EMP_DEPARTMENT"), rs.getInt("NUMBER_OF_EMPLOYEES"));
  }
}
