<%@ page import="dao.BookDao,daoimpl.BookDaoImpl,model.Book,dao.UserDao,daoimpl.UserDaoImpl,model.User,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
        }

        nav {
            background-color: #444;
            padding: 10px;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 0 10px;
        }

        .container {
            margin: 20px;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .crud-buttons {
            margin-top: 10px;
        }

        .crud-buttons button {
            padding: 10px;
            margin: 0 5px;
            cursor: pointer;
        }
        
        .styled-button {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color:  #4CAF50;
            
            border-radius: 5px;
            font-weight: bold;
            text-align: center;
            cursor: pointer;
            transition: background-color 0.3s;
        }
	 .nav-bar-hover:hover,.styled-button:hover {
            background-color: black;
        }
    </style>
</head>
<body>
 
<header>
    <h1>Library Management System</h1>
</header>

<nav>
	<center>
	<a class="nav-bar-hover" href="#">Users</a>
    <a class="nav-bar-hover" href="Books.jsp">Books</a>
   
    <a class="nav-bar-hover" class="nav-bar-hover" href="AddBook.jsp">Add New Book</a>
	<a class="nav-bar-hover" href="AddUser.jsp">Add New User</a>
	<a class="nav-bar-hover" href="Login.jsp">Logout</a>
    </center>
</nav>
<%
int id=Integer.parseInt(request.getParameter("id"));
UserDao userDao=new UserDaoImpl();


	User user=userDao.getNameById(id);
%>
<div class="container">
	<center>
    <h2>User:<span id="username"><%= user.getName()%></span></h2>
	<form action="AssignBookServlet" method="post">
    	<input type="hidden" id="id" name="id" value="<%=id%>" >
          <select name="bookName" id="bookName"> 
  
        <option>Select Book</option>  
          <%
    try{
    BookDao bookDao=new BookDaoImpl();
	List<Book> bookDetails=bookDao.getBookDetails();
	for(Book book:bookDetails){
	%> 
        <option  value="<%=book.getTitle() %>" ><%=book.getTitle() %></option>  
   
    <%
	}
    }catch(Exception ex){
    	ex.printStackTrace();
    }
    %> 
     </select> 
        <div class="crud-buttons">
            <button type="submit"  class="styled-button">Assign</button>
            <button type="button" onclick="window.location.href='Users.jsp'"  class="styled-button">Cancel</button>
        </div>
    </form>
  
</div>
</center>
</body>
</html>















