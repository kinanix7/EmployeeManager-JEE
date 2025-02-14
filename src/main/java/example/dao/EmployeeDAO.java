package example.dao;


import example.config.DatabaseConfig;
import example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public EmployeeDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword());
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setNom(rs.getString("nom"));
                employee.setPrenom(rs.getString("prenom"));
                employee.setEmail(rs.getString("email"));
                employee.setPoste(rs.getString("poste"));
                employee.setSalaire(rs.getDouble("salaire"));
                employees.add(employee);
            }
        }
        return employees;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (nom, prenom, email, poste, salaire) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getNom());
            pstmt.setString(2, employee.getPrenom());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPoste());
            pstmt.setDouble(5, employee.getSalaire());
            pstmt.executeUpdate();
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET nom=?, prenom=?, email=?, poste=?, salaire=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getNom());
            pstmt.setString(2, employee.getPrenom());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPoste());
            pstmt.setDouble(5, employee.getSalaire());
            pstmt.setInt(6, employee.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";

        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Employee getEmployeeById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUser(),
                DatabaseConfig.getDbPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("poste"),
                            rs.getDouble("salaire")
                    );
                }
            }
        }
        return null;
    }
}