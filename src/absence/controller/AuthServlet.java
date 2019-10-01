package absence.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import absence.beans.LoginInfoBeans;
import absence.model.LoginModel;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* formからの値受け取り */
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        /* ログイン実行 */
        LoginModel loginModel = new LoginModel();
        LoginInfoBeans loginInfoBeans = loginModel.login(user, password);

        /* ログイン失敗 */
        if(loginInfoBeans == null) {
            response.sendRedirect("login?error=0");
            return;
        }

        /* ログイン成功、セッション開始 */
        HttpSession session = request.getSession(true);
        session.setAttribute("loginInfoBeans", loginInfoBeans);

        response.sendRedirect("menu");
    }
}
