<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<jsp:useBean id="STRINGS" scope="page" class="com.logistics.utils.StringFunctions"></jsp:useBean>
<!DOCTYPE html>
<%
String errorMsg = STRINGS.replaceNull(request.getParameter("Errormsg"));
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Logistics App</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <script src="./clientvalidations.js"></script>
    <script type="text/javascript">
        function checkError(){
            var control = '<%= errorMsg != null ? errorMsg : "" %>';
            if (control.length > 0) {
                alert(control); // Display alert if the string is not empty
            }
        }

        function resetPassword(username) {
            if (isEmpty(document.theform.username)) {
                alert("Username not entered!!");
                return;
            }

            if (isEmpty(document.theform.password)) {
                alert("Password not entered!!");
                return;
            }

            if (isEmpty(document.theform.repassword)) {
                alert("Re-password not entered!!");
                return;
            }

            var pass = document.theform.password.value;
            var repass = document.theform.repassword.value;
            if (pass !== repass) {
                alert("Passwords don't match with each other.");
                return;
            }

            document.theform.submit(); // Submit the form if all checks pass
        }
    </script>
</head>
<body onload="checkError()">
    <div class="background-image">
        <div class="container">
            <!-- Company Name at the top-right -->
            <div class="company-name">Logistics Corp</div>

            <!-- Login Form -->
            <div class="login-form">
                <h2>Forgot Password</h2>
                <form name="theform" action="reset" method="POST">
                    <div class="form-group">
                        <label for="username">Username</label> 
                        <input type="text" id="username" name="username">
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label> 
                        <input type="password" id="password" name="password">
                    </div>

                    <div class="form-group">
                        <label for="repassword">Re-enter password</label> 
                        <input type="password" id="repassword" name="repassword">
                    </div>

                    <div class="form-group">
                        <input type="button" class="btn" onclick="resetPassword(document.theform.username.value)" value="Reset Password" name="save">
                    </div>
                </form>
            </div>
        </div>

        <!-- Footer with Terms and Conditions -->
        <div class="footer">
            <p>&copy; 2024 Logistics Corp. <a href="#">Terms & Conditions</a></p>
        </div>
    </div>
</body>
</html>
