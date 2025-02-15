<html>

<head>
    <meta charset="UTF-8">
    <title>affichage</title>
</head>

<%@ page import="example.model.Employee" %>
<%@ page import="java.util.List" %>
<!-- /WEB-INF/views/list-employees.jsp -->
<%@ include file="header.jsp" %>

<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    String error = (String) request.getAttribute("error");
%>

<div class="d-flex justify-content-center align-items-center mb-4">
    <h2></i>Employee List</h2>

</div>

<% if (error != null && !error.isEmpty()) { %>
<div class="alert alert-danger" role="alert">
    <i class="fas fa-exclamation-circle me-2"></i> <%= error %>
</div>
<% } %>

<div class="table-responsive">
    <table class="table table-striped table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th> <!-- Fixed encoding here -->
            <th>Email</th>
            <th>Poste</th>
            <th>Salaire</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% if (employees != null) {
            for (Employee employee : employees) { %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getNom() %></td>
            <td><%= employee.getPrenom() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getPoste() %></td>
            <td><%= employee.getSalaire() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/update-employee?id=<%= employee.getId() %>"
                   class="btn btn-sm btn-warning me-2">
                    <i class="fas fa-edit"></i>
                </a>
                <button onclick="confirmDelete(<%= employee.getId() %>)" class="btn btn-sm btn-danger">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>
        <%  }
        } %>
        </tbody>
    </table>
</div>

<script>
    function confirmDelete(id) {
        if (confirm('Are you sure you want to delete this employee?')) {
            window.location.href = '<%= request.getContextPath() %>/delete-employee?id=' + id;
        }
    }
</script>

<%@ include file="footer.jsp" %>
</html>