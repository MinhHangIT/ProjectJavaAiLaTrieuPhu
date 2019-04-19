<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="center" >
	
		<c:if test="${idcautraloi0==idcaudung || idcautraloi0==idcausai }">
            <a id="${idcautraloi0 }" onclick="traloi(${idcautraloi0 })" class="linka"><div class="ans" >
                <span class="cc center">A</span>
                <p class="center">${mucdo0 }</p>
            </div></a>
        </c:if>
        
        <c:if test="${idcautraloi1==idcaudung || idcautraloi1==idcausai }">
           	<a id="${idcautraloi1 }" onclick="traloi(${idcautraloi1 })" class="linka" ><div class="ans">
                <span class="cc center">B</span>
                <p class="center">${mucdo1 }</p>
            </div></a>
        </c:if>
        </div>
        <div class="center">
        <c:if test="${idcautraloi2==idcaudung || idcautraloi2==idcausai }">
            <a id="${idcautraloi2 }" onclick="traloi(${idcautraloi2 })" class="linka"><div class="ans">
                <span class="cc center">C</span>
                <p class="center">${mucdo2 }</p>
            </div></a>
        </c:if>
        
        <c:if test="${idcautraloi3==idcaudung || idcautraloi3==idcausai }">
            <a id="${idcautraloi3 }" onclick="traloi(${idcautraloi3 })" class="linka" ><div class="ans">
                <span class="cc center">D</span>
                <p class="center">${mucdo3 }</p>
            </div></a>
            
         </c:if>
        </div>

</body>
</html>