<%-- 
    Document   : success
    Created on : May 16, 2024, 4:40:15 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Library Application: Add Movie Success</title>
    </head>
    <body>
        <h1>Add Movie Success</h1>
        
        
        You have add the following Movie: <br>
        Title: <jsp:getProperty name="movieItem" property="title"/> <br>
        Year Released:<jsp:getProperty name="movieItem" property="year" /> <br>
        Genre of Film:<jsp:getProperty name="movieItem" property="genre" /> <vr>
        
        <br><a href="index.html">Home</a>
    </body>
</html>
