
		function validateForm() {
			
			var fName = document.getElementById("fName").value;
			fName = fName.trim();
			
			var lName = document.getElementById("lName").value;
			lName = lName.trim();
			
			var name = document.getElementById("name").value;
			name = name.trim();
			
			var pass = document.getElementById("pass").value;
			var repass = document.getElementById("repass").value;
			
			var enterp = document.getElementById("enterp").value;
			enterp = enterp.trim();
			
			var address = document.getElementById("address").value;
			address = address.trim();
			
			var email = document.getElementById("email").value;
			email = email.trim();

			if (fName == "" || lName == "" || name == "" || pass == "" || repass == "" || enterp == "" || address == ""|| email == "") {
				alert("Empty fields are not allowed!!");
				return false;
			}

			if (pass != repass) {
				alert("Password and Confirm Password does not match");
				return false;
			}
			
			if (name.indexOf('<') != -1 || name.indexOf('>') != -1
					|| name.indexOf(':') != -1 || name.indexOf(';') != -1
					|| name.indexOf('&') != -1 || name.indexOf('$') != -1) {
				alert("Username cannot contain special characters");
				return false;
			}
			
			var atPosition = email.indexOf("@");
			var dotPosition = email.lastIndexOf(".");
			
			if (atPosition < 1 || dotPosition<atPosition+2 || dotPosition+2 >= email.length)	{
				  alert("Email address is not valid!!");
				  return false;
			 }
		}