<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page them cau hoi</title>
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
						<p><u><i class="far fa-copy" style="margin-right: 20px"></i> Quản Lí Câu Hỏi<u></p>
					</div>
				</div>	
				<div id="trungtam">
					<div id="cauhoi">
						<form action="themcauhoi" method="post">
						<p style="margin-left: 150px;font-size:15px; color: red;">${thongbao }</p>
							<p class="tieude3">Thêm Câu Hỏi:</p>
							<input id="chon" type="text" name="cauhoi" placeholder="Điền Câu Hỏi...." >

							<br>
							<br>
							<label>Chọn Mức độ câu hỏi:</label>
							<select style="width: 30%;padding: 5px" name="mucdo">
								<c:forEach items="${listmucdo }" var="listmucdo">
							  		<option value="${listmucdo.getIdmucdo() }">${listmucdo.getTenmucdo() }</option>
							  	</c:forEach>
							</select>
							<br>
							<br>

							<p class="tieude3">Thêm Câu Trả lời </p><p class="tieude3" style="margin-left: 75%">Câu Đúng</p>
							<label>A : </label><input class="cautraloi" type="text" name="cautraloi1" placeholder="Câu a...." ><input style="margin-left: 15%;" type="radio" name="caudung" value="a">
							<br>
							<br>
							<label>B : </label><input class="cautraloi" type="text" name="cautraloi2" placeholder="Câu b...." ><input style="margin-left: 15%" type="radio" name="caudung" value="b">
							<br>
							<br>
							<label>C : </label><input class="cautraloi" type="text" name="cautraloi3" placeholder="Câu c...." ><input style="margin-left: 15%" type="radio" name="caudung" value="c">
							<br>
							<br>
							<label>D : </label><input class="cautraloi" type="text" name="cautraloi4" placeholder="cau d...." ><input style="margin-left: 15%" type="radio" name="caudung" value="d">

							<br>

							<br>
							<input type="submit" value="Them" style="width: 15%; margin-left: 40px">
						</form>
					</div>
					<div id="danhsach">
						<p class="tieude3">danh sách câu hỏi  : ----><span>ấn vào câu hỏi để xem chi tiết và sửa</span></p>
						<hr>
						<table>
							<tr>
									<td class="td1">Id</td>
									<td class="td2">Câu Hỏi</td>
							</tr>
						</table>
						<div style="width: 100%;height: 300px; overflow-y: auto">
							
							<table>
								
								
							<c:forEach items="${listcauhoi }" var="list">
								<tr>
									<td class="td1">${list.getIdcauhoi() }</td>
									<td class="td2"><a href="chinhsuacauhoi?idcauhoi=${list.getIdcauhoi() }">${list.getCauhoi() }</a></td>
								</tr>

							</c:forEach>	
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>