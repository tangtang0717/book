<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getAjax().value{
		var ajax;
		if(window.XMLHttpRequest){
			ajax = new XMLHttpRequest();
		}
		ajax.onreadystatechange = function(){
			if(ajax.readyState==4){
				if(ajax.status==200){
					var result = ajax.responseText;
					eval("var p"+result);
					var table = document.getElementById("table");
					var tr = table.insertRow(1);
					var cell0=tr.insertCell(0);
					cell0.innerHTML=p.name;
					var cell1=tr.insertCell(1);
					cell1.innerHTML=p.name;
					var cell2=tr.insertCell(2);
					cell2.innerHTML=p.name;
					var cell3=tr.insertCell(3);
					cell3.innerHTML=p.name;
					/*var showdiv = document.getElementById("showdiv");
					showdiv.innerHTML = result;*/
				}
			}
		}
		ajax.open("get","index");
		ajax.send(null);
	}
</script>
<style type="text/css">
	#showdiv{
		border:solid 2px;
		width:200px;
		height:100px;
	}
</style>
</head>
<body>
<input type="submit" name="button" value="测试" onClick="getAjax()" />
<div id="showdiv">

</div>
<table id="table">
	<tr></tr>
</table>
</body>
</html>