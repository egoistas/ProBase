<%-- 
    Document   : loginView
    Created on : 19-Dec-2023, 10:09:41
    Author     : georg
--%>

<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <body>
        <div class="container">
            <jsp:include page="_header.jsp"></jsp:include>
                <section class="vh-100" style="background-color: #508bfc;">
                    <div class="container py-5 h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                                    <div style="color:red">${errorString}</div>
                                    <div class="card-body p-5 text-center">
                                        <form method="POST" action="${pageContext.request.contextPath}/login">
                                            <h3 class="mb-5">Login</h3>

                                            <div class="form-outline mb-4">
                                                <input type="text" id="typeEmailX-2" name="username" class="form-control form-control-lg" />
                                                <label class="form-label" for="typeEmailX-2">Username</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="password" id="typePasswordX-2" name="password" class="form-control form-control-lg" />
                                                <label class="form-label" for="typePasswordX-2">Password</label>
                                            </div>

                                            <!-- Checkbox -->
                                            <div class="form-check d-flex justify-content-start mb-4">
                                                <input class="form-check-input" type="checkbox" value="" name="rememberme" id="form1Example3" />
                                                <label class="form-check-label" for="form1Example3"> Remember password </label>
                                            </div>

                                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            <jsp:include page="_footer.jsp"></jsp:include>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
