package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
    		HttpServletResponse response)
    		throws ServletException, IOException {

    	    //フォワード
	        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	        dispatcher.forward(request, response);
    }


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");

		//ログイン処理の実行
		Login login=new Login(id,pass);
		LoginLogic bo=new LoginLogic();
		boolean result=bo.execute(login);

		//処理の分岐
		if(result) {//ログイン成功時
		HttpSession session=request.getSession();
		session.setAttribute(id, id);

//フォワード
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
	     dispatcher.forward(request, response);
		}else{//ログイン失敗時
			//リダイレクト
			response.sendRedirect("/account/LoginServlet");
		}
	}

}
