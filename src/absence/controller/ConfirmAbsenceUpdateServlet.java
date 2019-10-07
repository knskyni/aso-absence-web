package absence.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import absence.beans.AbsenceBeans;

@WebServlet("/confirmabsenceupdate")
public class ConfirmAbsenceUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* formからの値取得 */
        String absenceDateString = request.getParameter("absence_date");
        String companyName = request.getParameter("company_name");
        String reason = request.getParameter("reason");

        /* セッション取得 */
        HttpSession session = request.getSession(false);
        AbsenceBeans updateAbsenceBeans = (AbsenceBeans)session.getAttribute("updateAbsenceBeans");

        /* 一つでも値が空っぽであればエラー */
        if(absenceDateString.equals("") || companyName.equals("") || reason.equals("") || updateAbsenceBeans == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        /* Date変換 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date absenceDate;
        try {
            absenceDate = sdf.parse(absenceDateString);
        } catch(ParseException e) {
            absenceDate = new Date();
        }

        /* Beansに更新 */
        updateAbsenceBeans.setAbsenceDate(absenceDate);
        updateAbsenceBeans.setCompanyName(companyName);
        updateAbsenceBeans.setReason(reason);

        /* 値の受け渡し */
        session.setAttribute("updateAbsenceBeans", updateAbsenceBeans);

        /* JSP読み込み */
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirmabsenceupdate.jsp");
        dispatcher.forward(request, response);
    }
}
