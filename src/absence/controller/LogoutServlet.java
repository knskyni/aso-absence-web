package absence.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* セッション取得 */
        HttpSession session = request.getSession(false);

        /* セッションが存在するなら */
        if(session != null) {
            session.invalidate(); // セッションを破棄する
        }

        response.sendRedirect("login?code=2");
        return;
    }
}
