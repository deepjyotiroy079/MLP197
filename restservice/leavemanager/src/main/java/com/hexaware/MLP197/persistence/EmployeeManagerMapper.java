package com.hexaware.MLP197.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.MLP197.model.Employee;

/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeManagerMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new Employee(rs.getInt("M.EMP_ID"), rs.getString("M.EMP_FULL_NAME"), rs.getString("M.EMP_EMAIL"),
          rs.getLong("M.EMP_MOBILE"), rs.getString("M.EMP_DATE_OF_JOINING"), rs.getString("M.EMP_DESIGNATION"),
          rs.getString("M.EMP_DEPARTMENT"), rs.getInt("M.EMP_LEAVE_BALANCE"), rs.getInt("M.EMP_MANAGER_ID"));
  }
}
