package absence.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import absence.beans.LoginInfoBeans;

public class UserDao extends DaoBase {
    private final String loginSQL = "SELECT `students`.`student_id`, `students`.`student_name`, `students`.`class_code`, `courses`.`course_name`, `classes`.`grade`, `classes`.`class_name` FROM `students` INNER JOIN `classes` ON `students`.`class_code` = `classes`.`class_code` INNER JOIN `courses` ON `classes`.`course_code` = `courses`.`course_code` WHERE `student_id` = ? AND `student_password` = ?;";

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
                loginInfoBeans.setClassId(rs.getString("class_code"));
                loginInfoBeans.setClassName(rs.getString("course_name") + rs.getString("grade") + rs.getString("class_name"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return loginInfoBeans;
    }
}
