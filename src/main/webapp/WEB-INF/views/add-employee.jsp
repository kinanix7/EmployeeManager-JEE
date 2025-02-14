<!-- /WEB-INF/views/add-employee.jsp -->
<%@ include file="header.jsp" %>
<%
    String error = (String) request.getAttribute("error");
%>
<div class="row justify-content-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0"><i class="fas fa-plus me-2"></i>Add New Employee</h3>
            </div>
            <div class="card-body">
                <% if (error != null && !error.isEmpty()) { %>
                <div class="alert alert-danger" role="alert">
                    <i class="fas fa-exclamation-circle me-2"></i> <%= error %>
                </div>
                <% } %>
                <form action="<%= request.getContextPath() %>/add-employee" method="post" class="needs-validation" novalidate>
                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" aria-describedby="nomError" required>
                        <div id="nomError" class="invalid-feedback">Please enter a nom.</div>
                    </div>
                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prenom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" aria-describedby="prenomError" required>
                        <div id="prenomError" class="invalid-feedback">Please enter a prenom.</div>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailError" required>
                        <div id="emailError" class="invalid-feedback">Please enter a valid email.</div>
                    </div>
                    <div class="mb-3">
                        <label for="poste" class="form-label">Poste</label>
                        <input type="text" class="form-control" id="poste" name="poste" aria-describedby="posteError" required>
                        <div id="posteError" class="invalid-feedback">Please enter a poste.</div>
                    </div>
                    <div class="mb-3">
                        <label for="salaire" class="form-label">Salaire</label>
                        <input type="number" class="form-control" id="salaire" name="salaire" min="0" step="0.01" aria-describedby="salaireError" required>
                        <div id="salaireError" class="invalid-feedback">Please enter a valid salaire (positive number).</div>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-save me-2"></i>Save Employee
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
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        forms.forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>
<%@ include file="footer.jsp" %>