package absence.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoBase {
    protected Connection con = null;

    public void connect() {
        /* 既に接続済みの場合は何もせず終了 */
        if(con != null) {
            return;
        }

        /* DB接続 */
        InitialContext context = null;
        try {
            String jndi = "java:comp/env/jdbc/MySQL";
            context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup(jndi);
            con = dataSource.getConnection();
        } catch(NamingException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if(con != null) {
            try {
                con.close();
                con = null;
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
