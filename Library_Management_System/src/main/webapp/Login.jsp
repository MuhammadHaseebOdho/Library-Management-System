<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="Components/Style.css"%></style>
</head>
<body>
<div class="main_div">
        <div class="box">
            <h1>login form</h1>
            <form method="post" action="LoginServlet">
                <div class="inputBox">
                    <input type="text" name="username" autocomplete="off" required>
                    <label> username</label>
                </div>

                <div class="inputBox">
                    <input type="password" name="password" autocomplete="off" required>
                    <label> password</label>
                </div>
               <input type="submit" name="" value="Login">
             	<br>
             	<p>Don't have account?</p>
             	<a class="button-like" href="SignUp.jsp">Sign Up</a>
            </form>
        </div>
    </div>
</body>
</html>