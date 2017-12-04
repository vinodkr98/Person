<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Details</title>
</head>
<body>
<form:form action="savePerson" method="post" modelAttribute="person">
        
                
                <form:hidden path="id"/><br>
                FName:
                <form:input path="fname" /><br>
                LNAME:
                <form:input path="lname" /><br>
                ADDRESSL1:
                <form:input path="addressl1" /><br>
                ADDRESSL2:
                <form:input path="addressl2" /><br>
            	
                
           <input type="submit" value="Save">
           
        
        </form:form>
    </div>
</body>
</html>