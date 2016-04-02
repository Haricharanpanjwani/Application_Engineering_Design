<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <style>
        table{
            border:3px solid black;
        }
        a{
            text-decoration: underline;
            cursor: pointer;
            color:blue;
        }
        span{
            color: red;
        }
    </style>
    <script>
        function registrationFormDisplay() {
            if (document.getElementById("registrationForm").style.display == "none") {
                document.getElementById("registrationForm").style.display = "block";
                document.getElementById("myForm").reset();
                document.getElementById("success").innerHTML = "";
                document.getElementById("searchForm").style.display = "none"
            } else {
                document.getElementById("registrationForm").style.display = "none"
            }
        }

        function searchFormDisplay() {
            if (document.getElementById("searchForm").style.display == "none") {
                document.getElementById("searchForm").style.display = "block";
                document.getElementById("search").reset();
                document.getElementById("results").innerHTML = "";
                document.getElementById("registrationForm").style.display = "none";
            } else {
                document.getElementById("searchForm").style.display = "none";
            }
        }

        //AJAX

        var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveUser() {
            //alert("hello1");

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var first = document.getElementById("first").value;
            var last = document.getElementById("last").value;
            var gender = document.getElementById("gender").value;
            var email = document.getElementById("email").value;
            var aboutMe = document.getElementById("aboutMe").value;

            var query = "action=register&first=" + first + "&last=" + last + "&gender=" + gender + "&email=" + email + "&aboutMe=" + aboutMe;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "register.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }

        function getResults() {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var key = document.getElementById("name").value;
            var flag = document.querySelector('input[name = "search"]:checked').value;
            var query = "action=searchuser&key=" + key.trim() + "&flag=" + flag.trim();
            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    document.getElementById("results").innerHTML = "";
                    var json = JSON.parse(xmlHttp.responseText);
                    if (json.users.length > 0) {
                        var x = document.createElement("TABLE");
                        x.setAttribute("id", "myTable");
                        document.getElementById("results").appendChild(x);
                        var y = document.createElement("TR");
                        y.setAttribute("id", "myTr");
                        document.getElementById("myTable").appendChild(y);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("First");

                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Last");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Email");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("About Me");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Delete");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        for (var count = 0; count < json.users.length; count++) {
                            var y = document.createElement("TR");
                            y.setAttribute("id", "myTr" + count);
                            document.getElementById("myTable").appendChild(y);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].first);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].last);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].email);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].aboutMe);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var a = document.createElement('a');
                            var id = json.users[count].id;
                            var rowID = "myTr" + count;
                            var linkText = document.createTextNode("Delete");
                            a.appendChild(linkText);
                            a.title = "Delete";
                            a.onclick = (function (id, rowID) {
                                return function () {
                                    deleteRow(id, rowID);
                                }
                            })(id, rowID);
                            z.appendChild(a);
                            document.getElementById("myTr" + count).appendChild(z);
                        }
                    } else {
                        document.getElementById("results").innerHTML="Nothing Found";
                    }
                }
            };
            xmlHttp.open("POST", "searchuser.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }

        function deleteRow(userID, rowID) {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }

            var query = "action=delete&user=" + userID;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    var row = document.getElementById(rowID);
                    row.parentNode.removeChild(row);
                }
            };
            xmlHttp.open("POST", "searchuser.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }

        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
    </script>
    <body>
        <button onclick="registrationFormDisplay()">Create User</button><br><br>
        <button onclick="searchFormDisplay()">Search User</button><br><br>
        <div id="registrationForm" style="display: none;">
            <h3>Registration Form</h3>
            <span id="success"></span>
            <form onsubmit="return saveUser();" id="myForm" method="POST" enctype="multipart/form-data">
                First : <input id="first" type="text" required/><br><br>

                Last : <input id="last" type="text" required/><br><br>

                Gender:
                <input type="radio" id="gender" value="M" checked/>Male
                <input type="radio" id="gender" value="F"/>Female
                <br><br>

                Email : <input id="email" type="text" required/><br><br>

                About Me: <textarea id="aboutMe" required></textarea> <br><br>

                <input type="submit" name="Register User">

            </form>
        </div>

        <div id="searchForm" style="display: none;">
            <h3>Search Form</h3>
            <form id="search" onsubmit="return getResults();">

                Search User <input type="text" id="name" name="user" required /> <br><br>

                <label>Search By:</label>
                <input type="radio" name="search" value="first" checked="checked"> First Name
                <input type="radio" name="search"  value="last"> Last Name
                <input type="radio" name="search"  value="gender"> Gender
                <input type="radio" name="search"  value="email"> Email <br><br>
                <input type="submit" name="search"/><br><br>
            </form>
            <div id="results">

            </div>
        </div>
    </body>
</html>
