<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Application</title>
<script   src="https://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script>
$(document).ready(function() {
	$("#sbutton").click(function() {
		var key = $("#key").val();
		var send_data = {'key':key};
		var fetchLinks = $.ajax({
			type : "POST",
			url  : "/TestWebApp/search/",
			data : send_data,
			success : function (response){
				var links = JSON.parse(response);
				var count = Object.keys(links).length;
				var i = 0;
				var data = "";
				 while(i<count){
					data += "<a href='#' id='"+links[i]+"' class='fdl'>"+links[i]+"</a><br>";
					i++;
				}
				$("#showLinks").show();
				$("#showDesc").width("48%");
				$("#showLinks").html(data);
			},
			error : function(){
				alert("There seems to be an error! Please try again");
			}
		});
	});
	$(document).on('click','a.fdl',function(){
		var link = this.id;
		$("abc").html("Showing details for "+link);
		var send_link = {'link':link};
		var fetchData = $.ajax({
			type : "POST",
			url  : "/TestWebApp/links/",
			data : send_link,
			success : function(response){
				var desc = JSON.parse(response);
				$("#showLinks").hide();
				$("#showDesc").width("96%");
				$("#showDesc").html(desc['0']);
			}
		});
	});
});
</script>
</head>
<body>
<h1 style="center">Test Application</h1>
<h2>${welcomeMessage}</h2>
<h3 id="abc">${show}</h3>
<div style="text-align:center;margin-bottom:10px">
	<input id="key" type="text" placeholder="Enter word to search" name="key"><input id="sbutton" type="submit">
</div>
<div style="float:left;width:48%;border:2px solid black" id="showLinks"></div>
<div style="float:right;width:48%;border:2px solid black" id="showDesc"></div>
</body>
</html>