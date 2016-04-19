<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table  border="1" cellpadding="2" cellspacing="1" align="center">
    <tr>
        <td height="80px" width="700px"  colspan="2" style="background-image: url(logo.jpg),url(background.jpg); background-repeat: no-repeat;background-size: 85px 90px;" ><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td height="445px" width="200px" style="background-image: url(vertical.jpg);background-size:200px 500px;background-repeat: repeat"><tiles:insertAttribute name="menu" /></td>
        <td height="445px" width="600px" style="background-image: url(background.jpg);"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="60px" width="700px" colspan="2" style="background-size:900px 100px;background-image: url(back.jpg);background-repeat:repeat"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>