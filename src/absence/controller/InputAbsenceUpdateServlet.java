package absence.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import absence.beans.AbsenceBeans;
import absence.beans.LoginInfoBeans;
import absence.model.AbsenceModel;

@WebServlet("/inputabsenceupdate")
public class InputAbsenceUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 更新する公欠IDの取得 */
        String absenceIdStr = request.getParameter("id");
        int absenceId = 0;
        try {
            absenceId = Integer.parseInt(absenceIdStr);
        } catch(NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        /* セッション取得 */
        HttpSession session = request.getSession(false);
        LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfoBeans");

        /* 公欠データ取得 */
        AbsenceModel absenceModel = new AbsenceModel();
        AbsenceBeans absenceBeans = absenceModel.getAbsence(loginInfo.getUserId(), absenceId);

        /* 自分以外の公欠データを選択してきた場合 */
        if(absenceBeans == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        /* 値のセット */
        request.setAttribute("absenceBeans", absenceBeans);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/inputabsenceupdate.jsp");
        dispatcher.forward(request, response);
    }
}
