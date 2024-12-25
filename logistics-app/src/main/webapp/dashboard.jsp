<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dahboard.css">
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        const dropdowns = document.querySelectorAll(".dropdown");

        dropdowns.forEach(dropdown => {
            const dropdownContent = dropdown.querySelector(".dropdown-content");

            dropdown.addEventListener("click", function (event) {
                event.stopPropagation(); // Prevent clicks from propagating to the body
                dropdownContent.style.display = dropdownContent.style.display === "block" ? "none" : "block";
            });

            // Close the dropdown when clicking outside
            document.addEventListener("click", function () {
                dropdownContent.style.display = "none";
            });
        });

        // Dynamic content loading function
        function loadContent(controller, mode) {
            const dynamicContent = document.querySelector(".content");

            if (controller && mode) {
                console.log("Inside load content: "+controller , "MODE: "+mode);
                // Construct the correct URL with controller and mode
                 // Construct the URL dynamically
        		const baseUrl = "<%=request.getContextPath()%>" + "/main";
        		console.log("BASE URL::::: "+baseUrl);
        		const url = baseUrl + "?controller="+ controller +"&mode="+mode;

                console.log("Constructed URL: ", url); // Log the URL to verify it's correct

                fetch(url)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error("Failed to load content");
                        }
                        return response.text();
                    })
                    .then(html => {
                        dynamicContent.innerHTML = html;
                    })
                    .catch(error => {
                        dynamicContent.innerHTML = `<p class="error">Error loading content: ${error.message}</p>`;
                    });
            } else {
                console.error("Controller or mode is missing");
            }
        }

        // Attach event listeners to menu items
        const links = document.querySelectorAll(".dropdown-content a");
        links.forEach(link => {
            link.addEventListener("click", function (event) {
                event.preventDefault(); // Prevent default behavior of <a> tag

                const controller = this.getAttribute("data-controller"); // Get the controller value
                const mode = this.getAttribute("data-mode"); // Get the mode value

                // Log the controller and mode values for debugging
                console.log("Controller: ", controller, " Mode: ", mode);

                if (controller && mode) {
                    loadContent(controller, mode); // Load content dynamically with correct URL
                } else {
                    console.error("Controller or mode attribute missing in the link");
                }
            });
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
                <a href="#" data-controller="C0100H" data-mode="VIEW">Upload Data</a>
                <a href="#" data-controller="Tab1BController" data-mode="VIEW">Tab 1B</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">Advance</a>
            <div class="dropdown-content">
                <a href="#" data-controller="Tab2AController" data-mode="VIEW">Tab 2A</a>
                <a href="#" data-controller="Tab2BController" data-mode="VIEW">Tab 2B</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">Extreme</a>
            <div class="dropdown-content">
                <a href="#" data-controller="Tab3AController" data-mode="VIEW">Tab 3A</a>
                <a href="#" data-controller="Tab3BController" data-mode="VIEW">Tab 3B</a>
            </div>
        </div>
    </div>
    <div class="content">
        <h1>Welcome to the Dashboard</h1>
        <p>Select a tab to navigate through the application.</p>
    </div>
</body>
</html>
