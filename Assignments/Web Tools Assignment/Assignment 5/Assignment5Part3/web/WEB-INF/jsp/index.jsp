<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="count.htm?action=count" method="post">
        <h1>How many books do you want to add?</h1>
        <input type="number" name="noOfBooks" min="0" max="20">
        <input type="submit" value="Submit">
        </form>
    </body>
</html>
