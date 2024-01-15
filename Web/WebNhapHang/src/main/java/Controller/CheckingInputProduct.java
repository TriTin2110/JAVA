package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckingInputProduct
 */
@WebServlet("/CheckingInputProduct")
public class CheckingInputProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckingInputProduct() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String productId = request.getParameter("ProductID");
		String productName = request.getParameter("ProductName");
		String inputPrice = request.getParameter("inputPrice");
		String outputPrice = request.getParameter("outputPrice");
		String dateExpired = request.getParameter("dateExpired");
		String productType = request.getParameter("productType");
		String description = request.getParameter("productDescription");

		String url = "/success.jsp";
		String errorMessage = "";
		String[] infoArray = { productId, productName, inputPrice, outputPrice, dateExpired, productType, description };
		out: for (int i = 0; i < infoArray.length - 2; i++) {
			if (infoArray[i].trim() == "" || infoArray[i] == null) {
				errorMessage = "Bạn chưa nhập đầy đủ thông tin";
				url = "/InputProduct.jsp";
				break out;
			}
		}
		if (Long.parseLong(inputPrice) > Long.parseLong(outputPrice)) {
			url = "/InputProduct.jsp";
			errorMessage = "Giá đầu vào không thể lớn hơn giá bán ra";
		}

		if (Long.parseLong(inputPrice) < 1 || Long.parseLong(outputPrice) < 1) {
			url = "/InputProduct.jsp";
			errorMessage = "Giá không thể nhỏ hơn 1!";
		}

		request.setAttribute("productName", productName);
		request.setAttribute("productId", productId);
		request.setAttribute("inputPrice", inputPrice);
		request.setAttribute("outputPrice", outputPrice);
		request.setAttribute("dateExpired", dateExpired);
		request.setAttribute("productType", productType);
		request.setAttribute("description", description);
		request.setAttribute("errorMessage", errorMessage);

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
