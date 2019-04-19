<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page quản lí Mức độ</title>
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
						<p><u><i class="far fa-copy" style="margin-right: 20px"></i> Quản Lí Mức độ<u></p>
					</div>
				</div>	
				<div id="trungtam">
					<div style="width: 100%; float: left">
					<p style="color: red; margin-left: 60px; font-size: 15px">${thongbao }</p>
						<p class="tieude3">danh sách Mức độ -------> ấn vào tên mức độ để update lại mức độ</p>
						<hr>
						<table>
							<tr>
									<td style="width: 10%;padding: 10px; text-align: left;border:1px solid gray;">Id muc do </td>
									<td style="width: 45%;padding: 10px; text-align: left;border:1px solid gray;">ten muc do</td>
									<td style="width: 45%;padding: 10px; text-align: left;border:1px solid gray;">Diem</td>
									
							</tr>
						</table>
						<div style="width: 100%;height: 300px; overflow-y: auto">
							
						<table>
								
								
							<c:forEach items="${mucdo }" var="list">
								<tr>
									<td style="width: 10%;padding: 10px; text-align: left;border:1px solid gray;">${list.getIdmucdo() }</td>
									<td style="width: 45%;padding: 10px; text-align: left;border:1px solid gray;">
										<a href="quanlimucdo?idmucdo=${list.getIdmucdo() }">${list.getTenmucdo() }</a>
									</td>
									<td style="width: 45%;padding: 10px; text-align: left;border:1px solid gray;">${list.getDiem() }</td>
									
									
								</tr>

							</c:forEach>	
						</table>
					</div>
					<c:if test="${idmucdo>1 }">
						<div style="width: 50%; float: left; margin-top: 20px">
						
						<form action="quanlimucdo?idmucdo=${mucdo1.getIdmucdo() }" method="post" style="width: 100%;margin-left: 40px">
							Ten muc do :
							<br>
							<input type="text" value="${mucdo1.getTenmucdo() }" name="ten" style="width: 90%; border-radius: 0 40px; padding: 10px">
							<br>
							
							<br>
							
							Diem :
							<input type="number" value="${mucdo1.getDiem() }" name="diem" style="width: 90%; border-radius: 0 40px; padding: 10px">
							
							<br>
							
							<br>
							
							<input type="submit" value="update " style="width: 20%; padding: 10px">
						</form>
					</div>
					</c:if>
				</div>
			</div>
		</div>

	</div>

</body>
</html>