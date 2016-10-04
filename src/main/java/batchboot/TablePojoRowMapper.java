package batchboot;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TablePojoRowMapper implements RowMapper<TablePojo> {

	@Override
	public TablePojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		TablePojo row = new TablePojo();
		row.setId(rs.getInt("id"));
		row.setDescr(rs.getString("descr"));
		return row;
	}
}
