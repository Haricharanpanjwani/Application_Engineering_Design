<%-- 
    Document   : browse
    Created on : Feb 8, 2016, 3:06:24 PM
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
        <title>Browse Movie</title>
    </head>
    <body>
        <form role='form' method='POST' action='search.htm'>
            <div class="container contact_tot">
                <div class="panel panel-default">
                    <div class="panel-heading">			       
                        <b> Search Movies </b>
                    </div>
                </div>
            </div>     

            <div class="form-group col-sm-6">
                <label>Keyword:</label><input type="text" name="search" Placeholder="Enter the Search String" class="form-control" />                    
            </div>
            <div class="form-group col-sm-12"></div>

            <div class="form-group col-sm-6">            
                <label class="radio-inline"><input type="radio" name="type" value="title" checked>Search by Movie Title</label><br />
                <label class="radio-inline"><input type="radio" name="type" value="actor">Search by Lead Actor</label><br />
                <label class="radio-inline"><input type="radio" name="type" value="actress">Search by Lead Actress</label>
                <br/>            
            </div>

            <div class="form-group col-sm-12">
                <input type="submit" class="btn btn-primary btn-md" value='Search Movies' />
            </div>
        </form>
    </body>
</html>
