<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>upload files</h1>
<form action="/upload" enctype="multipart/form-data" method="POST">
	<div>
		<p><input type="file" name="file" value="files"></p>
		<p><input type="submit" value="upload"></p>
	</div>
</form>
</body>
</html>