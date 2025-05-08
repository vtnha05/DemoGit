package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HCNservlet
 */
@WebServlet("/HCN")
public class HCNservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HCNservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.getRequestDispatcher("view/HCN.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Lấy giá trị từ form
        String lengthStr = request.getParameter("length");
        String widthStr = request.getParameter("width");

        if (lengthStr == null || widthStr == null || lengthStr.isEmpty() || widthStr.isEmpty()) {
            // Gửi thông báo lỗi nếu giá trị null hoặc rỗng
            request.setAttribute("error", "Please enter valid numeric values for length and width.");
        } else {
            try {
                // Chuyển đổi giá trị từ String sang double
                double length = Double.parseDouble(lengthStr.trim());
                double width = Double.parseDouble(widthStr.trim());

                // Tính diện tích và chu vi
                double area = length * width;
                double perimeter = 2 * (length + width);

                // Gửi kết quả đến JSP
                request.setAttribute("area", area);
                request.setAttribute("perimeter", perimeter);
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu giá trị không phải số
                request.setAttribute("error", "Invalid input. Please enter numeric values.");
            }
        }

        // Chuyển tiếp đến HCN.jsp để hiển thị kết quả hoặc lỗi
        request.getRequestDispatcher("view/HCN.jsp").forward(request, response);
    }

}
