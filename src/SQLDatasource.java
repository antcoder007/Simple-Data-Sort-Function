import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class SQLDatasource {

	private static final BasicDataSource basicDataSource;
	/* Here you set your database driver
	 * I'm using MySql
	 * If you want to use Microsoft SQL Server
	 * or anything else, then edit the DB_DRIVER 
	 * here accordingly and also add the required
	 * dependency in the pom.xml file...
	 */
	static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private SQLDatasource() {
	}

	static {
		/* Here you have two options
		 * either use a properties file and
		 * get the necessary variables
		 * or set environment variable like I've done it...
		 */
		String url = System.getenv().get("DATASOURCE_URL");
		String username = System.getenv().get("USER_LOGIN");
		String password = System.getenv().get("SUPER_SECRET_PASSWORD");
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DB_DRIVER);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setUrl(url);
	}

	public static DataSource getInstance() {
		return basicDataSource;
	}
}