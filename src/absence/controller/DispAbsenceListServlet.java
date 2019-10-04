package absence.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/dispabsencelist")
public class DispAbsenceListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* セッション取得 */
        HttpSession session = request.getSession(false);
        LoginInfoBeans loginInfoBeans = (LoginInfoBeans)session.getAttribute("loginInfoBeans");

        /* 公欠一覧の取得*/
        AbsenceModel absenceModel = new AbsenceModel();
        List<AbsenceBeans> list = absenceModel.getList(loginInfoBeans.getUserId());

        /* JSPで表示する値の準備 */
        request.setAttribute("absenceList", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/absencelist.jsp");
        dispatcher.forward(request, response);
    }
}
