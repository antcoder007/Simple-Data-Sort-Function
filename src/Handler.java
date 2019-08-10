import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

public class Handler implements ResultSetHandler<List<Object[]>> {

	@Override
	public List<Object[]> handle(ResultSet arg) throws SQLException {
		List<Object[]> newList = new ArrayList<>(500);
		
		//Go through the table columns
		while (arg.next()) {
			/* Let's say you have to sort the data in column_1
			 * The first step is to extract the data and store it temporarily
			 * So we assign it to variables of the same name...
			 */
			String column_1 = arg.getString("column_1");
			int column_2 = arg.getInt("column_2");
			long column_3 = arg .getLong("column_3");

			if (column_1 != null) {
				/* Now we iterate through the rows in column_1
				 * here we split/sort the data as per our needs
				 * you can use regex here too and sort for whitespace
				 * and other required symbols
				 * Then we add the sorted data to a list as an object array...
				 */
				for (String column_num : column_1.split(",")) {
					newList.add(new Object[] { column_num.trim(), column_2, column_3 });
				}
			} else {
				/* If column_1 has null value then we add it as it is
				 * You can skip this step if you don't wish to add
				 * null data to your table...
				 */
				newList.add(new Object[] { column_1, column_2, column_3 });
			}
		}
		
		return newList;
	}
	
}
