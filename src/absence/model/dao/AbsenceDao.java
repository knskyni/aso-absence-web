package absence.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import absence.beans.AbsenceBeans;

public class AbsenceDao extends DaoBase {
    public final String getListSQL = "SELECT `student_id`, `absence_date`, `company_name`, `reason` FROM `absences` WHERE `student_id` = ? ORDER BY `absence_id` DESC;";
    public final String insertAbsenceSQL = "INSERT INTO `absences`(`student_id`, `absence_date`, `company_name`, `reason`) VALUES (?, ?, ?, ?);";

    public List<AbsenceBeans> getList(String userId) {
        /* DB接続できていない場合はnullを返す */
        if(con == null) {
            System.out.println("データベースに接続していません。");
            return null;
        }

        /* SQL実行 */
        PreparedStatement stmt = null;
        AbsenceBeans absenceBeans = null;
        List<AbsenceBeans> absenceList = new ArrayList<AbsenceBeans>();

        try {
            stmt = con.prepareStatement(getListSQL); // SQL文の準備
            stmt.setString(1, userId); // SQL文への値代入
            ResultSet rs = stmt.executeQuery(); // SQL実行

            while(rs.next()) {
                absenceBeans = new AbsenceBeans();

                absenceBeans.setUserId(rs.getString("student_id"));
                absenceBeans.setAbsenceDate(rs.getString("absence_date"));
                absenceBeans.setCompanyName(rs.getString("company_name"));
                absenceBeans.setReason(rs.getString("reason"));

                absenceList.add(absenceBeans);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return absenceList;
    }

    public void insert(AbsenceBeans absenceBeans) {
        /* DB接続できていない場合はnullを返す */
        if(con == null) {
            System.out.println("データベースに接続していません。");
            return;
        }

        /* SQL実行 */
        PreparedStatement stmt = null;

        try {
            /* SQL文の準備 */
            stmt = con.prepareStatement(insertAbsenceSQL);

            /* SQL文への値代入 */
            stmt.setString(1, absenceBeans.getUserId());
            stmt.setString(2, absenceBeans.getAbsenceDate());
            stmt.setString(3, absenceBeans.getCompanyName());
            stmt.setString(4, absenceBeans.getReason());

            /* 実行 */
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
