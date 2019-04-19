<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 style="margin: auto; text-align: center; color: blue;margin-top: 10px; font-size: 20px"><b><i>chúc mừng bạn đã trả lời đúng</i></b></h2>
	<br>
	<h2 style="color: yellow; text-align: center">Điểm của bạn :<span style="margin-left: 10px; color: red;"><b><u> ${diemso }</u></b></span></h2>
	<br>
	<a style="margin-left: 35%; margin-right: auto;"  href="cauhoi?cauthu=${caubn+1 }"><button style="width: 30%; height:60px; border-radius: 30px;background-color: gray; color: black ; font-size: 20px ">đến câu tiếp theo</button></a>

</body>
</html>