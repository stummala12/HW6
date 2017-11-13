
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Family"%>
<% Family member = (Family) request.getAttribute("member"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Member</title>
    </head>
    <body>
        <h1>Update A New Member Record</h1>
        
        <form name="updateForm" action="updateMember" method="get">
            
                     <table class="update">
            
                <tr>
                <label>Member ID:</label>
            <input type="text" name="id" value="<%= member.getMemberID() %>" readonly/>
            </tr>
            <tr>
                <label>Member Name:</label>
            <input type="text" name="name" value="<%= member.getMemberName() %>" />
            </tr>
            
            <tr>
            <label>Email Address:</label>
            <input type="text" name="email" value="<%= member.getEmailAddr() %>" />
</tr>
            
<tr>
            <label>Age:</label>
            <input type="text" name="age" value="<%= member.getAge() %>" />
            </tr>
            
            <tr>
            <label>Favorite Color:</label>
            <input type="text" name="color" value="<%= member.getFavoriteColor() %>" />
            </tr>
            
            
        
            
        </table>    
            <br>
            <input type="reset" name="reset" value="Clear" />  
            <input type="submit" name="submit" value="Update" />
        </form>
        </body>
</html>