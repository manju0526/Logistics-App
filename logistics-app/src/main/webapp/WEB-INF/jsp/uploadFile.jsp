<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <h2>Upload a File</h2>
    <form action="fileupload" method="POST" enctype="multipart/form-data">
        <label>Select File: </label>
        <input type="file" name="file" required>
        <button type="submit">Upload</button>
    </form>
</body>
</html>
