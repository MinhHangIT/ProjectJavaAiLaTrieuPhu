<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page quản lí tài khoản</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/frontend/admin.css">
</head>
<body>

	<div id="chung">
		<jsp:include page="admin_header.jsp"></jsp:include>

		<div id="mid">
			<jsp:include page="admin_menu.jsp"></jsp:include>
			<div class="benphai1">
				<div id="trungtamtren">
					<div id="thongtin">
						<p><u><i class="far fa-copy" style="margin-right: 20px"></i> Quản Lí Tài Khoản<u></p>
					</div>
				</div>	
				<div id="trungtam">
					
						<p class="tieude3">danh sách người dùng </p>
						<hr>
						<table>
							<tr>
									<td style="width: 10%;padding: 10px; text-align: left;border:1px solid gray;">Id tai khoan</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">ten tai khoan</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">Mật Khẩu</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">Địa Chỉ</td>
							</tr>
						</table>
						<div style="width: 100%;height: 300px; overflow-y: auto">
							
						<table>
								
								
							<c:forEach items="${taikhoan }" var="list">
								<tr>
									<td style="width: 10%;padding: 10px; text-align: left;border:1px solid gray;">${list.getIdtaikhoan() }</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">${list.getTentaikhoan() }</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">${list.getMatkhau() }</td>
									<td style="width: 30%;padding: 10px; text-align: left;border:1px solid gray;">${list.getDiachi() }</td>
									
								</tr>

							</c:forEach>	
						</table>
						
				</div>
			</div>
		</div>

	</div>

</body>
</html>