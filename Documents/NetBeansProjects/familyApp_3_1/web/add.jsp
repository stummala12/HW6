
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Family Member</title>
    </head>
    <body>
        <h1>Add A New Family Member</h1>
        
        <form name="addForm" action="addMember" method="get">
            
            <label>Member Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Email Address:</label>
            <input type="text" name="email" value="" />
            <br>
            <label>Age:</label>
            <input type="text" name="age" value="" />
            <br>
            <label>Favorite Color:</label>
            <input type="text" name="color" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
            
            
            
       
    </body>
</html>
