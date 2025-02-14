package example.servlets;



import example.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDAO dao = new EmployeeDAO();
            dao.deleteEmployee(id);
        } catch (Exception e) {
            request.setAttribute("error", "Error deleting employee");
        }
        response.sendRedirect("list-employees");
    }
}
