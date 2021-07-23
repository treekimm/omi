<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js"/>"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="javascript:test();"> hi </a>

<h1><a href="/apidoc">GO API DOC</a></h1>

<input id="test" />

</body>
<script>
	function test() {
		$.ajax({
			type : "POST",
			url  : '/test' ,
			data : {},
			dataType : 'json',
			success : function(data) {
				$('#test').val(data.result.text);
			},
			error : function(e) {
				console.log(e);
				alert(e);
			}
		});
	}
</script>
</html>
