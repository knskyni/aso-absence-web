package absence.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import absence.beans.AbsenceBeans;
import absence.model.AbsenceModel;

@WebServlet("/insertabsenceupdate")
public class InsertAbsenceUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* セッション取得 */
        HttpSession session = request.getSession(false);
        AbsenceBeans updateAbsenceBeans = (AbsenceBeans)session.getAttribute("updateAbsenceBeans");

        if(updateAbsenceBeans == null) {
            response.sendRedirect("inputabsenceupdate");
            return;
        }

        /* データベースに登録 */
        AbsenceModel absenceModel = new AbsenceModel();
        absenceModel.update(updateAbsenceBeans);

        /* セッションから登録に使った情報の削除 */
        session.removeAttribute("updateAbsenceBeans");

        response.sendRedirect("completeabsenceupdate");
    }
}
