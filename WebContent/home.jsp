<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/frontend/home1.css">
	
	<link rel="stylesheet" type="text/css" href="resources/frontend/dangki.css">
	
	<style type="text/css">
		#dangki{
		display:none;
		}
	</style>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$("#clickdangki").click(function(){
				$("#dangki").show(1500);
				$("#dangnhap").hide(1500);
				
			});
			
			$("#clickdangnhap").click(function(){
				$("#dangnhap").show(1500);
				$("#dangki").hide(1500);
				
			});
			
		})
	</script>
</head>
<body>

<div id="dangnhap">
<h2><i><b><u>Đăng nhập</u></b></i></h2>

<h4><i><b><u>${thongbao }</u></b></i></h4>

<form action="dangnhap" method="post" style="padding-left: 150px; padding-right: 150px;">
  <div style=" height: 20%" class="imgcontainer">
    <img src="resources/image/logo1.jpg" alt="Avatar" class="avatar">
  </div>

  <div class="container-fluid">
    <label for="uname"><b>Username:</b></label>
    <input type="text" placeholder="Enter Username.." name="user" required>

    <label for="psw"><b>Password:</b></label>
    <input type="password" placeholder="Enter Password.." name="pass" required>
        
    <div class="clearfix">
      <button type="submit" class="cancelbtn">Đăng nhập</button>
      <button type="button" id="clickdangki" class="signupbtn" >Đến trang đăng kí</button>
    </div>
    <label>
       ${thongbao }
    </label>
  </div>
  </form>
  </div>

  <div id="dangki">
  	
  	
	<form action="dangki" method="post" style="border:1px solid #ccc;padding-left: 150px; padding-right: 150px;">
  <div class="container">
    <h1><i><b><u>Đăng kí</u></b></i></h1>
    <p>Tạo tài khoản mới </p>
    <hr>

    <label for="email"><b>Username:</b></label>
    <input type="text" placeholder="Enter Email" name="username" required>
    
    <label for="psw"><b>Địa chỉ:</b></label>
    <input type="text" placeholder="Enter dia chi" name="diachi" required>
    

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>



    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="password2" required>
    
    
    
   

    <div class="clearfix">
     
      <button type="submit" class="signupbtn" >Đăng Kí</button>
      <button type="button" id="clickdangnhap" class="cancelbtn" >Trở về trang đăng nhập</button>
    </div>
  </div>
</form>

</body>
</html>
