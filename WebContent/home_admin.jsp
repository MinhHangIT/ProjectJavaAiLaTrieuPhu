<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href='<c:url value='/resources/assets/img/favicon.ico'/>'>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href='<c:url value='/resources/assets/css/bootstrap.min.css'/>'
	rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href='<c:url value='/resources/assets/css/animate.min.css'/>'
	rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link
	href='<c:url value='/resources/assets/css/light-bootstrap-dashboard.css?v=1.4.0'/>'
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href='<c:url value='/resources/assets/css/demo.css'/>' rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='<c:url value='/resources/assets/css/pe-icon-7-stroke.css'/>'
	rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<jsp:include page="sidebar_admin.jsp"></jsp:include>
		<div class="main-panel">
			<jsp:include page="nav_admin.jsp"></jsp:include>
			<div class="content">
				<div class="container-fluid">
					<div class="row">


						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">Users Behavior</h4>
									<p class="category">24 Hours performance</p>
								</div>
								<div class="content">
									<div id="chartHours" class="ct-chart"></div>
									<div class="footer">
										<div class="legend">
											<i class="fa fa-circle text-info"></i> Open <i
												class="fa fa-circle text-danger"></i> Click <i
												class="fa fa-circle text-warning"></i> Click Second Time
										</div>
										<hr>
										<div class="stats">
											<i class="fa fa-history"></i> Updated 3 minutes ago
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>




				</div>
			</div>
		</div>
		<jsp:include page="footer_admin.jsp"></jsp:include>
	</div>
</body>
<script
	src='<c:url value='/resources/assets/js/jquery.3.2.1.min.js" type="text/javascript'/>'></script>
<script src="/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src='<c:url value='/resources/assets/js/chartist.min.js'/>'></script>

<!--  Notifications Plugin    -->
<script src='<c:url value='/resources/assets/js/bootstrap-notify.js'/>'></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
	src='<c:url value='/resources/assets/js/light-bootstrap-dashboard.js?v=1.4.0'/>'></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src='<c:url value='/resources/assets/js/demo.js'/>'></script>

<script type="text/javascript">
	$(document).ready(function() {

						demo.initChartist();

						$
								.notify(
										{
											icon : 'pe-7s-gift',
											message : "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

										}, {
											type : 'info',
											timer : 4000
										});

					});
</script>
</html>