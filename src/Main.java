import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class Main {
	private static QueryRunner run = SingletonQueryrunner.getInstance();
	

	public static void main(String[] args) throws SQLException {

		// Select unsorted data form the first table
		String sql = "SELECT `column_1`, `column_2`, `column_3` FROM `table_name_1`";
		
		// Create a list of object array
		List<Object[]> data = run.query(sql, new Handler());
		
		// Insert the sorted data into another table
		String newSql = "INSERT INTO `table_name_2` (column_1, column_2, column_3) VALUES (?,?,?)";

		// Run batch insert
		run.batch(newSql, data.toArray(new Object[0][0]));
		
	}
}
