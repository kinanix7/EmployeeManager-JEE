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

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(125695);
        request.getRequestDispatcher("/WEB-INF/views/add-employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String poste = request.getParameter("poste");
            int salaire = Integer.parseInt(request.getParameter("salaire"));

            // Validation
            if (!ValidationUtil.isValidName(nom) || !ValidationUtil.isValidName(prenom) ||
                    !ValidationUtil.isValidEmail(email) || !ValidationUtil.isValidSalaire(salaire)) {
                request.setAttribute("error", "Invalid input data");
                request.getRequestDispatcher("/WEB-INF/views/add-employee.jsp").forward(request, response);
                return;
            }

            Employee employee = new Employee();
            employee.setNom(nom);
            employee.setPrenom(prenom);
            employee.setEmail(email);
            employee.setPoste(poste);
            employee.setSalaire(salaire);

            EmployeeDAO dao = new EmployeeDAO();
            dao.addEmployee(employee);

            response.sendRedirect("list-employees");
        } catch (Exception e) {
            request.setAttribute("error", "Error adding employee: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/add-employee.jsp").forward(request, response);
        }
    }
}
