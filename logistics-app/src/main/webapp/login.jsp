<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<jsp:useBean id="STRINGS" scope="page"
	class="com.logistics.utils.StringFunctions"></jsp:useBean>
<!DOCTYPE html>
<%
String errorMsg = STRINGS.replaceNull(request.getParameter("Errormsg"));
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Logistics App</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">

<script type="text/javascript">
        function login() {
            // You can add validation logic or any other functionality here
            // Example of simple validation to check if username and password are not empty
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;

            if (username === '' || password === '') {
                alert("Please fill in both username and password.");
                return false; // Prevent form submission if validation fails
            }

            // Optionally, you can proceed to submit the form if everything is okay
            document.theform.submit(); // Submit the form programmatically
        }

       function checkError(){
           	var control = '<%=errorMsg%>';
		if (control.length > 0) {
			alert(control); // Display alert if the string is not empty
		}
	}

	function forgotPassword() {
		document.theform.action="<%=request.getContextPath()%>/forgotPassword.jsp";
		document.theform.submit();
	}
</script>

</head>
<body onload="checkError();">
	<div class="background-image">
		<div class="container">
			<!-- Company Name at the top-right -->
			<div class="company-name">Logistics Corp</div>

			<!-- Login Form -->
			<div class="login-form">
				<h2>Login to Your Account</h2>
				<form name="theform" action="login" method="POST">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							id="username" name="username">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							id="password" name="password">
					</div>
					<div class="form-group">
						<!-- Add onclick event to call the login function -->
						<button type="button" class="btn" onclick="login()">Login</button>
					</div>

					<div class="login-form-pass">
						<font color="#ffffff" size="4" face="arial narrow"> <a
							href="javascript:forgotPassword();" style="color: red">Forgot Password</a>
						</font>
					</div>


				</form>
			</div>
		</div>

		<!-- Footer with Terms and Conditions -->
		<div class="footer">
			<p>
				&copy; 2024 Logistics Corp. <a href="#">Terms & Conditions</a>
			</p>
		</div>
	</div>
</body>
</html>
