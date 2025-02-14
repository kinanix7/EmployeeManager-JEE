<%@ page import="example.model.Employee" %>
<!-- /WEB-INF/views/update-employee.jsp -->
<%@ include file="header.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header bg-warning">
                <h3 class="mb-0"><i class="fas fa-edit me-2"></i>Update Employee</h3>
            </div>
            <div class="card-body">
                <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger" role="alert">
                    <i class="fas fa-exclamation-circle me-2"></i><%= request.getAttribute("error") %>
                </div>
                <% } %>

                <form action="<%= request.getContextPath() %>/update-employee" method="post" class="needs-validation" novalidate>
                    <input type="hidden" name="id" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getId() : "" %>">

                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getNom() : "" %>" required>
                        <div class="invalid-feedback">Please enter a nom.</div>
                    </div>

                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getPrenom() : "" %>" required>
                        <div class="invalid-feedback">Please enter a prénom.</div>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getEmail() : "" %>" required>
                        <div class="invalid-feedback">Please enter a valid email.</div>
                    </div>

                    <div class="mb-3">
                        <label for="poste" class="form-label">Poste</label>
                        <input type="text" class="form-control" id="poste" name="poste" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getPoste() : "" %>" required>
                        <div class="invalid-feedback">Please enter a poste.</div>
                    </div>

                    <div class="mb-3">
                        <label for="salaire" class="form-label">Salaire</label>
                        <input type="number" step="0.01" class="form-control" id="salaire" name="salaire" value="<%= request.getAttribute("employee") != null ? ((Employee) request.getAttribute("employee")).getSalaire() : "" %>" required>
                        <div class="invalid-feedback">Please enter a valid salaire.</div>
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-warning">
                            <i class="fas fa-save me-2"></i>Update Employee
                        </button>
                        <a href="<%= request.getContextPath() %>/list-employees" class="btn btn-secondary">
                            <i class="fas fa-arrow-left me-2"></i>Back to List
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    // Form validation
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')
        Array.prototype.slice.call(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>

<%@ include file="footer.jsp" %>