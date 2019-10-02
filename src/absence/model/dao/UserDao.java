package absence.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import absence.beans.LoginInfoBeans;

public class UserDao extends DaoBase {
    private final String loginSQL = "SELECT `student_id`, `student_name` FROM `students` WHERE `student_id` = ? AND `student_password` = ?;";

    public LoginInfoBeans getBy(String userId, String password) {
        /* DB接続できていない場合はnullを返す */
        if(con == null) {
            System.out.println("データベースに接続していません。");
            return null;
        }

        /* SQL実行 */
        PreparedStatement stmt = null;
        LoginInfoBeans loginInfoBeans = null;
        try {
            stmt = con.prepareStatement(loginSQL);
            stmt.setString(1, userId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                loginInfoBeans = new LoginInfoBeans();

                loginInfoBeans.setUserId(rs.getString("student_id"));
                loginInfoBeans.setUserName(rs.getString("student_name"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return loginInfoBeans;
    }
}
