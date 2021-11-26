<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2021-11-25
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>file upload</title>
</head>
<body>

<h2>파일업로드</h2>

<div class="container">
    <form action="/mung/fileinsert" method="post"
          enctype="multipart/form-data">
        <input type="file" name="files">
        <!-- 여기서 files는 controller에 @RequestPart MultipartFile files -->

        <button type="submit" class="btn btn-dark">업로드</button>
    </form>
</div>
</body>
</html>