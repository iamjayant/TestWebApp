<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Application</title>
<script   src="https://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script>
$(document).ready(function() {
	//alert("hello");
	//$.getScript("");
	$("#sbutton").click(function() {
		var key = $("#key").val();
		//alert(key);
		//var send_data = {'key':key};
		var URL = "/TestWebApp/" + key;
		window.location.href = URL;
	});
	var links = JSON.parse('${links}');
	var count = Object.keys(links).length;
	//alert(count);
	var i = 0;
	var data = "";
	while(i<count){
		data += "<a id='"+i+"' href='/TestWebApp/${key}/"+links[i]+"'>"+links[i]+"</a><br>";
		i++;
	}
	document.getElementById("showLinks").innerHTML=data;
});
</script>
</head>
<body>
<h1 style="center">Test Application</h1>
<h2>${welcomeMessage}</h2>
<h3>${show}</h3>
<div style="text-align:center;margin-bottom:10px">
	<input id="key" type="text" placeholder="Enter word to search" name="key"><input id="sbutton" type="submit">
</div>
<div style="float:left;width:48%;border:2px solid black" id="showLinks"></div>
<div style="float:right;width:48%;border:2px solid black">${detail}</div>
</body>
</html>