<jsp:include page="/global.jsp"></jsp:include>
<%@ taglib uri="http://www.logistics.com/ui" prefix="logistics" %>
<html>
<head>
    <logistics:screenTitle title="File upload Page" />
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleall.css">
    
    <script type="text/javascript">
        function excelupload() {
            alert("File upload triggered!");
           /*  document.forms[0].submit();  // Submit the form when the button is clicked */
        }
    </script>
</head>
<body marginwidth="0" marginheight="0" leftmargin="0" topmargin="0" bottommargin="0" rightmargin="0">

    <form action="theform" method="POST" enctype="multipart/form-data">
        <table width="56%" class="TABLEORDER" border="0" align="center" cellspacing="" cellpadding="0">
            <tr class="TITLE">
                <td align="left" width="40%" class="TEXTBOX">
                    <input type="file" name="fileName" size="70" class="R">
                </td>
                <td align="left" class="TEXTBOX">
                    <input type="button" name="upload" class="NAVIGATION-BTN" value="Upload File" onclick="excelupload()">
                </td>
            </tr>
        </table>
        <br>
    </form>

    <logistics:footer message="" />
    
</body>
</html>
