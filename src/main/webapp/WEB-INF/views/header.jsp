<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/list-employees">
            <i class="fas fa-users me-2"></i>Employee Management
        </a>
        <div class="navbar-nav">
            <a class="nav-link" href="${pageContext.request.contextPath}/list-employees">
                <i class="fas fa-list me-1"></i>List Employees
            </a>
            <a class="nav-link" href="${pageContext.request.contextPath}/add-employee">
                <i class="fas fa-plus me-1"></i>Add Employee
            </a>
        </div>
    </div>
</nav>
<div class="container mt-4">

    <!-- /WEB-INF/views/footer.jsp -->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>