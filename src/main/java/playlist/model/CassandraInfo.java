package playlist.model;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: stevelowenthal
 * Date: 10/3/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraInfo extends CassandraData {

  private String clusterName;
  private String cassandraVersion;

  public CassandraInfo(ServletContext context) {

    Row row = getSession(context).execute("select cluster_name, release_version from system.local").one();
    cassandraVersion = row.getString("release_version");
    clusterName = row.getString("cluster_name");

  }

  public String getClusterName() {
    return clusterName;
  }

  public String getCassandraVersion() {
    return cassandraVersion;
  }
}
