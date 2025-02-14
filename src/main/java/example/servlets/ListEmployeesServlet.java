package example.servlets;


import example.dao.EmployeeDAO;
import example.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/list-employees")
public class ListEmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> employees = dao.getAllEmployees();

            for (Employee employee : employees) {
                System.out.println(employee.getEmail());
            }
            request.setAttribute("employees", employees);
        } catch (Exception e) {
            request.setAttribute("error", "Error fetching employees: " + e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/list-employees.jsp").forward(request, response);
    }
}