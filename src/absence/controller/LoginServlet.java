package absence.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    /* エラーメッセージ */
	    String errorStr = request.getParameter("error");
	    Integer error = null;
	    String errorMsg = null;
	    String[] errorMsgList = {
	            "ユーザー名またはパスワードが間違っています。",
	            "ログインしていません。",
	            "ログアウトしました。"
	    };

	    /* エラーコードの処理 */
	    try {
	        error = Integer.parseInt(errorStr);
	        if(error >= 0 && error < errorMsgList.length) {
	            errorMsg = errorMsgList[error];
	        }
	    } catch(Exception e) {
	        errorMsg = null;
	    }

	    /* JSPで表示する値の準備 */
	    request.setAttribute("errorMsg", errorMsg);

	    /* JSP読み込み */
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
	    dispatcher.forward(request, response);
	}
}
