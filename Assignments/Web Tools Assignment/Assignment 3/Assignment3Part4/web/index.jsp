<%-- 
    Document   : index
    Created on : Feb 8, 2016, 2:28:19 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Movie Database</title>
    </head>
    <body>
        <div class="bg-primary text-center" style='alignment-adjust: center'>
            <h2> Welcome to Movie Store </h2>
        </div>
        
        <div class='form-group col-sm-12' style='align:center'>
            <!--<form role='form' method='POST' action='login.htm'>-->
                
                <div class="form-group col-sm-12">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Please make your selection
                        <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="movie.htm?action=browse">Browse Movies</a></li>
                            <li><a href="movie.htm?action=add">Add New Movies to Database</a></li>                  
                        </ul>
                    </div>
                </div>
                
<!--            <div class="form-group col-sm-12">
                    <input type="submit" class="btn btn-primary btn-md" value='Send' />
                </div>
                
                <input type="hidden" name="action" value="login" />
                                    
            </form> -->                  
        </div>
    </body>
</html>
