<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Home</title>
</head>
<body>
	<div align="center">
            <h1>Person List</h1>
            <h3><a href="/Person/newPerson">New Person</a></h3>
            <table border="1">
                <th>id</th>
                <th>fname</th>
                <th>lname</th>
                <th>addressl1</th>
                <th>addressl2</th>
                
                <th>Actions</th>
                 
                <c:forEach var="person" items="${listPerson}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.fname}</td>
                    <td>${person.lname}</td>
                    <td>${person.addressl1}</td>
                    <td>${person.addressl2}</td>
                    <td>
                        <a href="/Person/updatePersonById?id=${person.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Person/deletePerson?id=${person.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
            <p>Get person by id</p>
	<form action="getPersonById">
		<input type="text" name="id" />
		<button value="submit">Get details</button>
	</form>
	<p>${personInfo.name}</p>
	<br><br>
        </div>
</body>
</html>