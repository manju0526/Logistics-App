<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dahboard.css">
<script type="text/javascript">
	document
			.addEventListener(
					"DOMContentLoaded",
					function() {
						const dropdown = document.querySelector(".dropdown");
						const dropdownContent = document
								.querySelector(".dropdown-content");

						dropdown
								.addEventListener(
										"click",
										function(event) {
											event.stopPropagation(); // Prevent clicks from propagating to the body
											dropdownContent.style.display = dropdownContent.style.display === "block" ? "none"
													: "block";
										});

						// Close the dropdown when clicking outside
						document.addEventListener("click", function() {
							dropdownContent.style.display = "none";
						});
					});
</script>
</head>
<body>
	<div class="logout">
		<form action="logout" method="post">
			<button type="submit">Logout</button>
		</form>
	</div>
	<div class="nav">
		<div class="dropdown">
			<a href="#">Basic</a>
			<div class="dropdown-content">
				<a
					href="<%=request.getContextPath()%>/main?controller=C0100H&mode=VIEW">Upload
					Data</a> <a href="tab1b.jsp">Tab 1B</a>
			</div>
		</div>
		<div class="dropdown">
			<a href="#">Advance</a>
			<div class="dropdown-content">
				<a href="tab2a.jsp">Tab 2A</a> <a href="tab2b.jsp">Tab 2B</a>
			</div>
		</div>
		<div class="dropdown">
			<a href="#">Exterme</a>
			<div class="dropdown-content">
				<a href="tab3a.jsp">Tab 3A</a> <a href="tab3b.jsp">Tab 3B</a>
			</div>
		</div>
	</div>
	<div class="content">
		<h1>Welcome to the Dashboard</h1>
		<p>Select a tab to navigate through the application.</p>
	</div>
</body>
</html>
