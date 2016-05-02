
		function GetXmlHttpObject()	{
		    var xmlHttp = null;
		    try	{
		        // Firefox, Opera 8.0+, Safari
		        xmlHttp = new XMLHttpRequest();
		    } 
		    catch (e)	{
		        // Internet Explorer
		        try	{
		            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		        } 
		        catch (e)	{
		            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		        }
		    }
		    return xmlHttp;
		}
		
		function validateForm() {
			
			var workRequestID = document.getElementById("workRequestID").value;
			workRequestID = workRequestID.trim();
			
			if (workRequestID == "") {
				alert("Request Field cannot be empty!!");
				return false;
			}
			
			document.getElementById("requestProcess").submit();
			
			/* var xmlHttp;
	        xmlHttp = GetXmlHttpObject();

	        if (xmlHttp == null)	{
	           alert("Your browser does not support AJAX!");
	           return;
	        }
	   
	        var requestID = document.getElementById("workRequestID").value;
	        alert(requestID);
	        
	        var query = "workRequestID=" + requestID;
	            
			xmlHttp.onreadystatechange = function stateChanged()	{
	            	        
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200)	{
					
			        //document.getElementById("status"+requestID).innerHTML="Processed";
		         }
	        };
	            
			xmlHttp.open("POST", "manufacturerRequestProcess.htm", true);
	        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	        xmlHttp.send(query);
	            
	        return false; */  
		}		