<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   
<div style="width:400px; margin-right:auto; margin-left:auto; border-radius:5px border:1px solid #000;">
<h1>Registrazione Ente</h1>   
<form style="margin:0 auto" align=center  action="registrazioneEnte.jsp">  
<input type="text" name="nomeEnte" value="nome" onclick="this.value=''"/><br/>  
<input type="text" name="emailEnte"  value="email" onclick="this.value=''"/><br/>  
<input type="submit" value="registrati"/>  
</form> 
</div>

</body>
</html>