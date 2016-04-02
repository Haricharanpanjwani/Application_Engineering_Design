<%-- 
    Document   : index
    Created on : Feb 8, 2016, 7:14:19 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Book Database</title>
    </head>
    <body>
        <div class="bg-primary text-center" style='alignment-adjust: center'>
            <h2> Welcome to Book Store </h2>
        </div>
        
        <div class='container'>                        
            <form role='form' method='post' action='form.htm'>
            
                <div class="form-group col-sm-6">
                    <label>How many books you want to add?</label>
                    <input type="text" name="numberOfBooks" Placeholder="Enter number of Books" class="form-control" />                    
                </div>                
                
                <div class="form-group col-sm-12">
                    <input type="submit" class="btn btn-primary btn-md" value='Submit' />
                </div>
            </form>
        </div>                
        
    </body>
</html>
