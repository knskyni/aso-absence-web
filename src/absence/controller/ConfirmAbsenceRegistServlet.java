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
import absence.beans.LoginInfoBeans;

@WebServlet("/confirmabsenceregist")
public class ConfirmAbsenceRegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* formからの値取得 */
        String absenceDateString = request.getParameter("absence_date");
        String companyName = request.getParameter("company_name");
        String reason = request.getParameter("reason");

        if(absenceDateString.equals("") || companyName.equals("") || reason.equals("")) {
            response.sendRedirect("inputabsenceregist");
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

        /* セッション取得 */
        HttpSession session = request.getSession(false);
        LoginInfoBeans loginInfoBeans = (LoginInfoBeans)session.getAttribute("loginInfoBeans");

        /* 値をBeansに格納 */
        AbsenceBeans registAbsenceBeans = new AbsenceBeans();
        registAbsenceBeans.setUserId(loginInfoBeans.getUserId());
        registAbsenceBeans.setAbsenceDate(absenceDate);
        registAbsenceBeans.setCompanyName(companyName);
        registAbsenceBeans.setReason(reason);

        /* 値の受け渡し */
        session.setAttribute("registAbsenceBeans", registAbsenceBeans);

        /* JSP読み込み */
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirmabsenceregist.jsp");
        dispatcher.forward(request, response);
    }
}
