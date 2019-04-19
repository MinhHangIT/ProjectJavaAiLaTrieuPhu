<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


	<h3 style="margin-top:20px;color:black; font-size: 25px;margin-left: 30px">${caudung }</h3>
	<br>
	<progress value="${phantramdung }" max="100" style="width: 90%;"></progress><span style="margin-left: 10px">${phantramdung } %</span>
    <br>
    <br>
    <h3 style="color:black;font-size: 25px;margin-left: 30px">${causai0 }</h3>
    <br>
	<progress value="${phantramsai0 }" max="100" style="width: 90%;"></progress><span style="margin-left: 10px">${phantramsai0 } %</span>
    <br>
    <br>
    <h3 style="color:black;font-size: 25px;margin-left: 30px">${causai1 }</h3>
    <br>
	<progress value="${phantramsai1 }" max="100" style="width: 90%;"></progress><span style="margin-left: 10px">${phantramsai1 } %</span>
    <br>
    <br>
    <h3 style="color:black;font-size: 25px;margin-left: 30px">${causai2 }</h3>
    <br>
	<progress value="${phantramsai2 }" max="100" style="width: 90%;"></progress><span style="margin-left: 10px">${phantramsai2 } %</span>
	
	
	<br>
	<a onclick="tatthongbao1()" style="margin-left: 35%; margin-right: auto;"><button style="width: 30%; height:60px; border-radius: 30px;background-color: gray; color: black ; font-size: 20px ">Trở về</button></a>
</body>
</html>