<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Ente</title>
<link href="../css/Style.css" rel="stylesheet" type="text/css">
</head>
<body>
  
<form class=loginform action="LoginEnte.jsp">

    <input class=input type="text" placeholder="Email" name="emailEnte" required>
    <input class=input type="password" placeholder="Password" name="pswEnte" required>
    <button class=loginbtn type="submit">Login</button>
    <input class=registrabtn type="submit" value="registrati" onclick="RegistrazioneEnte.jsp"/>
    

</form>
</div>
</body>
</html>