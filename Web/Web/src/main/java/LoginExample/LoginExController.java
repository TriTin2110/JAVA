package LoginExample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginExController
 */
@WebServlet("/LoginExController")
public class LoginExController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginExController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		phương thức setCharacterEncoding được sử dụng để đặt bảng mã (character encoding) cho dữ liệu được gửi và nhận từ client và server
		response.setCharacterEncoding("UTF-8");
		// Phương thức setContentType trong Servlet được sử dụng để đặt loại nội dung
		// (Content Type) của phản hồi (response) mà Servlet sẽ gửi đến trình duyệt của
		// client.
		response.setContentType("text/html; charset=UTF-8");

		String userAcc = request.getParameter("user");
		String userPassword = request.getParameter("password");
		String url = "";
		url = (userAcc.equals("nguyentritin") && userPassword.equals("123")) ? "/\\LoginEx\\Success.jsp"
				: "/\\LoginEx\\Fail.jsp";

		// Điều hướng sang trang mới
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
