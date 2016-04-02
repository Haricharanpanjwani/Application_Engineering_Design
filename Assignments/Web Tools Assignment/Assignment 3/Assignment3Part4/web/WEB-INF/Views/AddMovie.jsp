<%-- 
    Document   : AddMovie
    Created on : Feb 8, 2016, 3:06:40 PM
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
        <title>Add Movie</title>
    </head>
    <body>
        
        <div class="container contact_tot">
            <div class="panel panel-default">
                <div class="panel-heading">			       
                    <b>Please enter the movie details below: </b>
                </div>
            </div>
        </div>         
        
        <div class='container'>            
            
            <form role='form' method='post' action='add.htm'>
            
                <div class="form-group col-sm-6">
                    <label>Movie Title:</label><input type="text" name="movieTitle" Placeholder="Movie Title" class="form-control" />                    
                </div>
                <div class="form-group col-sm-12"></div>
                
                <div class="form-group col-sm-6">
                    <label>Lead Actor:</label><input type="text" name="actor" Placeholder="Lead Actor" class="form-control" />                    
                </div>
                <div class="form-group col-sm-12"></div>
                
                <div class="form-group col-sm-6">
                    <label>Lead Actress:</label><input type="text" name="actress" Placeholder="Lead Actress" class="form-control" />                    
                </div>
                <div class="form-group col-sm-12"></div>
                
                <div class="form-group col-sm-6">
                    <label>Genre:</label><input type="text" name="genre" Placeholder="Genre" class="form-control" />                    
                </div>
                <div class="form-group col-sm-12"></div>
                
                <div class="form-group col-sm-6">
                    <label>Release Year:</label><input type="text" name="year" Placeholder="Release Year" class="form-control" />                    
                </div>
                <div class="form-group col-sm-12"></div>
                
                <div class="form-group col-sm-12">
                    <input type="submit" class="btn btn-primary btn-md" value='Add Movie' />
                </div>
            </form>
        </div>
        
    </body>
</html>
