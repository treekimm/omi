<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="/resources/jquery-tmpl-master/jquery.tmpl.js"></script>
<link rel="stylesheet" href="/resources/bootswatch/dist/cosmo/bootstrap.css">
</head>
<body>
	<h1>API DOC 페이지 입니다.</h1>

	<div id="apiListArea">
		<script id="apiList" type="text/x-jquery-tmpl">
		${list}
		{{each(idx,item) list}}
			<div class="card text-white bg-primary mb-3" style="max-width: 100rem;" onclick="clickList(this,'\${item.controllerPath}');">
				<div class="card-header"> \${item.controllerName} </div>
				<div class="card-body">
					<h4 class="card-title">Primary card title</h4>
					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card\'s content.</p>
				</div>
			</div>
		{{/each}}
		</script>
	</div>

</body>
<script>
function getControllerList() {
	$.ajax({
		type : "POST",
		url  : '/apidoc/getControllerList' ,
		data : {},
		dataType : 'json',
		success : function(data) {
			console.log(typeof data);
			setApiList(data);
		},
		error : function(e) {
			console.log(e);
			alert(e);
		}
	});
}

function setApiList(data) {
	
	var apiListArea = $('#apiListArea');
	$('#apiList').tmpl({list : data.result.result}).appendTo(apiListArea);
	
	apiListArea.show();
	$('.card-body').hide();
}

function clickList(target,path) {
	if($(target).children().eq(1).is(':visible')) {
		closeApiDetail(target);
	} else {
		openApiDetail(target);
	}
}

function openApiDetail(target) {
	$(target).children().eq(1).show();
}

function closeApiDetail(target) {
	$(target).children().eq(1).hide();
}

function getApiInfo() {
	$.ajax({
		type : "POST",
		url  : '/apidoc/getApiInfo' ,
		data : {},
		dataType : 'json',
		success : function(data) {
			console.log(data);
		},
		error : function(e) {
			console.log(e);
			alert(e);
		}
	});
}

/* function getApiInfo() {
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
} */

/* function setApiInfoList(data) {
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
} */

$(document).ready(function(){
	$('#apiListArea').hide();
	getControllerList();
});

</script>
</html>