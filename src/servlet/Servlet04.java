package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;

@WebServlet("/04")
public class Servlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Request Scope
		UserVo userVo = new UserVo(1, "박명수", "park", "1234", "male");
		request.setAttribute("userVo", userVo);
		
		
		request.setAttribute("num", 1);
		request.setAttribute("str", "안녕하세요");
		
		// Session Scope
		UserVo userVosess = new UserVo(2, "홍길동", "hong", "1234", "male");
		request.getSession(true).setAttribute("userVoSess", userVosess);
		
		// Application Scope
		UserVo userVoApp = new UserVo(3, "장길산", "jang", "9876", "male");
		request.getServletContext().setAttribute("userVoApp", userVoApp);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/04.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
