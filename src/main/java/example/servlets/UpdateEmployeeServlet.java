package example.servlets;


import example.dao.EmployeeDAO;
import example.model.Employee;
import example.util.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update-employee")
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee employee = dao.getEmployeeById(id);

            if (employee != null) {
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("/WEB-INF/views/update-employee.jsp").forward(request, response);
            } else {
                response.sendRedirect("list-employees");
            }
        } catch (Exception e) {
            response.sendRedirect("list-employees");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String poste = request.getParameter("poste");
            double salaire = Double.parseDouble(request.getParameter("salaire"));

            // Validation
            if (!ValidationUtil.isValidName(nom) || !ValidationUtil.isValidName(prenom) ||
                    !ValidationUtil.isValidEmail(email) || !ValidationUtil.isValidSalaire(salaire)) {
                request.setAttribute("error", "Invalid input data");
                request.getRequestDispatcher("/WEB-INF/views/update-employee.jsp").forward(request, response);
                return;
            }

            Employee employee = new Employee(id, nom, prenom, email, poste, salaire);
            EmployeeDAO dao = new EmployeeDAO();
            dao.updateEmployee(employee);

            response.sendRedirect("list-employees");
        } catch (Exception e) {
            request.setAttribute("error", "Error updating employee: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/update-employee.jsp").forward(request, response);
        }
    }
}