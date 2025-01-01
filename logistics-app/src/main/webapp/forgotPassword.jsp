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
<script src="./clientvalidations.js"></script>
<script type="text/javascript">
      
       function checkError(){
           	var control = '<%=errorMsg%>';
		if (control.length > 0) {
			alert(control); // Display alert if the string is not empty
		}
	}

	function resetPassword(){
     if(isEmpty(document.theform.username)){
         alert("Username not entered!!");
         }else{
             alert("Still functionality yet to develope!!!");
         }
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
				<form name="theform" action="login" method="POST">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							id="username" name="username">
					</div>


					<div class="form-group">					
					  <input type="button" class="btn" onclick="resetPassword()" value="Rest Password" name="save">			
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
