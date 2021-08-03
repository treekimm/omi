<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js"/>"></script>
</head>
<body>
	<h1>API DOC 페이지 입니다.</h1>
	
	<ul id='apiList'>
	</ul>
	
</body>
<script>
function getApiList() {
	$.ajax({
		type : "POST",
		url  : '/apidoc/getApiName' ,
		data : {},
		dataType : 'json',
		success : function(data) {
			setApiList(data);
		},
		error : function(e) {
			console.log(e);
			alert(e);
		}
	});
}

function setApiList(data) {
	console.log(data);
	
	var apiList ='';
	apiList = $('#apiList');
	console.log(apiList);
	$.each(data.result.name, function(idx,item) {
		apiList.append('<li>'+ item +'</li>');	
	})
}

function getApiInfo() {
	$.ajax({
		type : "POST",
		url  : '/getApiInfo' ,
		data : {},
		dataType : 'json',
		success : function(data) {
			setApiInfoList(data);
		},
		error : function(e) {
			console.log(e);
			alert(e);
		}
	});
}

function setApiInfoList(data) {
	console.log(data);
	
	var apiList ='';
	apiList = $('#apiList');
	console.log(apiList);
	$.each(data.result.apiNameList, function(idx,item) {
		apiList.append('<li>'+ item +'</li>');	
		$.each(data.result.resultMap,function(idx,item){
			apiList.append('<li>' + idx + ':' + item.method + ' ' + item.field + '</li>');
		});
	});
}

$(document).ready(function(){
	getApiList();
}) ;
	


</script>
</html>