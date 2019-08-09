import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;


/* Create an instance of query runner so that
 *   we don't have to call it over and over again in 
 *  different classes...
 */
public class SingletonQueryrunner {

	private final static DataSource dataSource;
	private static QueryRunner run;

	static {
		dataSource = SQLDatasource.getInstance();
	}

	public static QueryRunner getInstance() {
		if (run == null) {
			synchronized (SingletonQueryrunner.class) {
				run = new QueryRunner(dataSource);
			}
		}
		return run;
	}

}
