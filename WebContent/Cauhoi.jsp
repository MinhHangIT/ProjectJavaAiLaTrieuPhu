<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Câu hỏi thứ ${cauthu }</title>
<style type="text/css">

body{
	background-image: url("resources/image/anh2.jpg");
	
	-webkit-background-size: cover;
              -moz-background-size: cover;
              -o-background-size: cover;
              background-size: cover;
}
	.linka{
		text-decoration: none;
	}
	
	.linka:hover .ans{
		background:blue;
	}
	
	#thongbaonguoichoi{
		height: 25%; 
		width: 50%;
		background-color: #003333;
		border-radius:40px;
		opacity:0.8;
		position: absolute ;
		top: 37%; 
		 
		right: 25%; 
		display: none;
	}
	
	#thongbaonguoichoi1{
		height: 50%; 
		width: 50%;
		background-color: #003333;
		border-radius:40px;
		opacity:0.9;
		position: absolute ;
		top: 25%; 
		 
		right: 25%; 
		display: none;
	}
	
	
</style>
<link rel="stylesheet" type="text/css" href="resources/frontend/frontend.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

	function tatthongbao(){
	
	document.getElementById("thongbaonguoichoi").style.display="none";
	}
	function tatthongbao1(){
		
		document.getElementById("thongbaonguoichoi1").style.display="none";
		}

	function traloi(ma){
		var xhttp;
		var macautraloi=ma;
		var cauthu=${cauthu }

		var url="traloi?madapan="+macautraloi+"&cauthu="+cauthu;
		if(window.XMLHttpRequest){
			xhttp=new XMLHttpRequest();
		}
		else{
			xhttp=new ActiveXObject("Mcrosoft.XMLHTTP");
		}
		
		xhttp.onreadystatechange = function()
		{
			if(xhttp.readyState==4){
				var data = xhttp.responseText;
				document.getElementById("thongbaonguoichoi").style.display="block";
				document.getElementById("traloi").innerHTML=data;
			}
			
			
		}
		
		
		xhttp.open("POST",url,true);
		xhttp.send();
	}
	
	
	function nammuoi(idcauhoi,idtrogiup){
		var xhttp;
		var id=idcauhoi;
		var id2=idtrogiup
		

		var url="apiloaibo?idcauhoi="+id+"&idtrogiup="+id2;
		if(window.XMLHttpRequest){
			xhttp=new XMLHttpRequest();
		}
		else{
			xhttp=new ActiveXObject("Mcrosoft.XMLHTTP");
		}
		
		xhttp.onreadystatechange = function()
		{
			if(xhttp.readyState==4){
				var data = xhttp.responseText;
				document.getElementById("thaythe").innerHTML=data;
				document.getElementById("loaibo").style.display="none";
				
			}
			
			
		}
		
		
		xhttp.open("POST",url,true);
		xhttp.send();
	}
	
	
	function hoidapan(idcauhoi,idtrogiup){
		var xhttp;
		var id=idcauhoi;
		var id2=idtrogiup
		

		var url="apihoidapan?idcauhoi="+id+"&idtrogiup="+id2;
		if(window.XMLHttpRequest){
			xhttp=new XMLHttpRequest();
		}
		else{
			xhttp=new ActiveXObject("Mcrosoft.XMLHTTP");
		}
		
		xhttp.onreadystatechange = function()
		{
			if(xhttp.readyState==4){
				var data = xhttp.responseText;
				document.getElementById("traloi").innerHTML=data;
				document.getElementById("thongbaonguoichoi").style.display="block";
				document.getElementById("dapan").style.display="none";
				
			}
			
			
		}
		
		
		xhttp.open("POST",url,true);
		xhttp.send();
	}
	
	
	function khangia(idcauhoi,idtrogiup){
		var xhttp;
		var id=idcauhoi;
		var id2=idtrogiup
		

		var url="apihoikhangia?idcauhoi="+id+"&idtrogiup="+id2;
		if(window.XMLHttpRequest){
			xhttp=new XMLHttpRequest();
		}
		else{
			xhttp=new ActiveXObject("Mcrosoft.XMLHTTP");
		}
		
		xhttp.onreadystatechange = function()
		{
			if(xhttp.readyState==4){
				var data = xhttp.responseText;
				document.getElementById("traloi1").innerHTML=data;
				document.getElementById("thongbaonguoichoi1").style.display="block";
				document.getElementById("khangia").style.display="none";
				
			}
			
			
		}
		
		
		xhttp.open("POST",url,true);
		xhttp.send();
	}
	
</script>
</head>
<body>
	
	 <div class="wrapper">
        <div class="logo center">
            <div><img src="resources/image/ho2.jpg" style="width: 100%;height: 100%;border-radius:50%"></div>
        </div>
        <div class="heading center">
            <div>Bạn đã really sẵn sàng !!</div>
        </div>
        <div class="question center">
            <div class="cc center">${cauthu }</div>
            <p>${cauhoi.getCauhoi() }</p>
        </div>
        
        <div id="thaythe">
        <div class="center" >
            <a id="${idcautraloi0 }" onclick="traloi(${idcautraloi0 })" class="linka"><div class="ans" >
                <span class="cc center">A</span>
                <p class="center">${mucdo0 }</p>
            </div></a>
           	<a id="${idcautraloi1 }" onclick="traloi(${idcautraloi1 })" class="linka" ><div class="ans">
                <span class="cc center">B</span>
                <p class="center">${mucdo1 }</p>
            </div></a>
        </div>
        <div class="center">
            <a id="${idcautraloi2 }" onclick="traloi(${idcautraloi2 })" class="linka"><div class="ans">
                <span class="cc center">C</span>
                <p class="center">${mucdo2 }</p>
            </div></a>
            <a id="${idcautraloi3 }" onclick="traloi(${idcautraloi3 })" class="linka" ><div class="ans">
                <span class="cc center">D</span>
                <p class="center">${mucdo3 }</p>
            </div></a>
        </div>
        </div>
        <br>
        <div class="control center">
            
            <div class="btnn">
               	<button onclick="nammuoi(${idcauhoi},${idtrogiup0 })" id="loaibo" class="btn" style="background: #3498db;">${trogiup0 }</button>
                <button onclick="khangia(${idcauhoi},${idtrogiup1 })" id="khangia" class="btn" style="background: #5bc0de;">${trogiup1 }</button>
                <button onclick="hoidapan(${idcauhoi},${idtrogiup2 })" id="dapan" class="btn" style="background: blue;">${trogiup2 }</button>
            </div>
        </div>
        <a href="ketthuc"><button class="btn" style="background: #5cb85c;
        margin: 30px; position:relative;left: -175px;">Exit game</button></a>
        <div class="center">
            <div class="choose center">
            
            <c:forEach items="${mucdo }" var="list">
            
            	<c:if test="${list.getIdmucdo()==cauthu }">
                <div class="chon" style="background: red">${list.getTenmucdo() } <hr> <b>${list.getDiem() }</b></div>
               </c:if>
               <c:if test="${list.getIdmucdo()!=cauthu }">
               <div class="chon">${list.getTenmucdo() } <hr> <b>${list.getDiem() }</b></div>
                </c:if>
             </c:forEach>  
            </div>
        </div>
    </div>
	
	
	<div id="thongbaonguoichoi">
		
		<div id="traloi">
		
		</div>
	</div>
	
	<div id="thongbaonguoichoi1" >
		
		<div id="traloi1">
		
		</div>
	</div>
</body>
</html>