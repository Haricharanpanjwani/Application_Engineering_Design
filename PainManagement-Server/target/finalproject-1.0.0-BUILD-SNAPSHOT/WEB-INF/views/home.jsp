<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


<link href="<c:url value='/resources/css/home.css'></c:url>" rel="stylesheet">
<script>
	
	$(function() {

		var status = null;
		//var address = "http://www.idelta.info:8080/SmartPhoneProject/";
		var address = "http://localhost:8080/finalproject/";
		//show all accounts
		$("#accounts").on("click", function() {
			status = "accounts";
			console.log(status);
			$.ajax({
				type : 'POST',
				url : address + 'getallaccounts',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>UserID</td>"+"<td>UserName</td>"+"<td>Password</td>"+"<td>Status</td>"+"<td>Actions</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].userid+"'>" + "<td><input type='text' stu='1' value='"+data[i].userid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].username+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].userpassword+"' disabled='true'></td>" + 
						"<td><input type='text' stu='1' value='"+data[i].status+"' disabled='true'></td>"+"<td><button type='button' class='btn btn-warning' id='modify'>Edit/Save</button><button type='button' class='btn btn-danger' id='deleteit'>Delete</button></td>"+"</tr>";
					}
					inmyfile += "<tr><td><input type='text' stu='1' value='' disabled='true'></td><td><input type='text' stu='1' value='' disabled='true'></td><td><input type='text' stu='1' value='' disabled='true'></td><td><button type='button' class='btn btn-success' id='addnew'>Add/Save</button></td></tr>"	
					
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		
				//modify accounts
				
				$("#mytable").delegate("#modify","click",function(){
					if(status === "accounts"){
					var senddata = $(this).parent().parent().attr("passdata");
					var key =  $(this).parent().parent().children()[1].getElementsByTagName("input")[0].getAttribute("stu");
					for(var i=0;i < $(this).parent().parent().children().length-1 ;i++){
						if($(this).parent().parent().children()[i].getElementsByTagName("input")[0].getAttribute("stu") == 1){
							$(this).parent().parent().children()[i].getElementsByTagName("input")[0].removeAttribute("disabled");	
							$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","0");		
						}else{
							$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("disabled","true");	
							$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","1");
	
							}
					}
						if(key == 0){
						var userid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
						var username = $(this).parent().parent().children()[1].getElementsByTagName("input")[0].value;
						var password = $(this).parent().parent().children()[2].getElementsByTagName("input")[0].value;
						var stat = $(this).parent().parent().children()[3].getElementsByTagName("input")[0].value;
						
						$.ajax(
								{
									type:'POST',
									url:address + 'editaccounts',
									contentType:"application/json",
									data:JSON.stringify({preuserid:senddata,userid:userid,username:username,password:password,status:stat}),
									dataType:'json',
									success:function(){
											//alert("right");
										},
									error:function(){
											alert("fail");
										}	
								});
						}
					}	
				});
				$("#mytable").delegate("#deleteit","click",function(){
					if(status === "accounts"){
					var userid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					console.log(userid);
					if (confirm("Do you really want to delete this user?") == true) {
						$.ajax({
									type:'POST',
									url: address + 'deleteaccounts',
									contentType:"application/json",
									data:JSON.stringify({userid:userid,username:"",userpassword:""}),
									dataType:'json',
									success:function(){
											alert("right");
										}	
								});
				    	}
					}
				});

			// add new accounts
					$("#mytable").delegate("#addnew","click",function(){
						if(status === "accounts"){
						//var senddata = $(this).parent().parent().attr("passdata");
						var key =  $(this).parent().parent().children()[1].getElementsByTagName("input")[0].getAttribute("stu");
						for(var i=0;i < $(this).parent().parent().children().length-1 ;i++){
							if($(this).parent().parent().children()[i].getElementsByTagName("input")[0].getAttribute("stu") == 1){
								$(this).parent().parent().children()[i].getElementsByTagName("input")[0].removeAttribute("disabled");	
								$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","0");		
							}else{
								$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("disabled","true");	
								$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","1");
		
								}
						}
							if(key == 0){
							var userid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
							var username = $(this).parent().parent().children()[1].getElementsByTagName("input")[0].value;
							var password = $(this).parent().parent().children()[2].getElementsByTagName("input")[0].value;
							var sta = 1;
							
							$.ajax(
									{
										type:'POST',
										url:address + 'addaccounts',
										contentType:"application/json",
										data:JSON.stringify({userid:userid,username:username,userpassword:password,status:sta}),
										dataType:'json',
										success:function(){
												alert("right");
											},
										error:function(){
												alert("fail");
											}	
									});
							}
						}	
					});



			
		

		//show all questions
		$("#questions").on("click", function() {
			status = "questions";
			console.log(status);
			$.ajax({
				type : 'POST',
				url : address + 'getallquestions',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>QuestionID</td>"+"<td>QuestionDetail</td>"+"<td>QuestionType</td>"+"<td>AnswerID</td>"+"<td>Actions</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].questionid+"'>" + "<td><input type='text' stu='1' value='"+data[i].questionid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].questiondetail+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].questionType+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answerid+"' disabled='true'></td>"+"<td><button type='button' class='btn btn-warning' id='modify'>Edit/Save</button><button type='button' class='btn btn-danger' id='deleteit'>Delete</button></td>"+"</tr>";
					}
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		//modify questions
			
			$("#mytable").delegate("#modify","click",function(){
				if(status === "questions"){
				var senddata = $(this).parent().parent().attr("passdata");
				var key =  $(this).parent().parent().children()[1].getElementsByTagName("input")[0].getAttribute("stu");
				for(var i=0;i < $(this).parent().parent().children().length-1 ;i++){
					if($(this).parent().parent().children()[i].getElementsByTagName("input")[0].getAttribute("stu") == 1){
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].removeAttribute("disabled");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","0");		
					}else{
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("disabled","true");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","1");

						}
				}
			
				if(key == 0){

					var questionid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					var questiondetail = $(this).parent().parent().children()[1].getElementsByTagName("input")[0].value;
					var questiontype = $(this).parent().parent().children()[2].getElementsByTagName("input")[0].value;
					var answerid = $(this).parent().parent().children()[3].getElementsByTagName("input")[0].value;
					
					console.log(questionid);
					console.log(questiondetail);
					console.log(questiontype);
					console.log(answerid);
					$.ajax(
							{
								type:'POST',
								url:address + 'editquestions',
								contentType:"application/json",
								data:JSON.stringify({questionid:questionid,questiondetail:questiondetail,questionType:questiontype,answerid:answerid}),
								dataType:'json',
								success:function(){
										//alert("right");
									},
								error:function(){
										alert("fail");
									}	
							});
						}
					}
				});
				// delete questions
				$("#mytable").delegate("#deleteit","click",function(){
					if(status === "questions"){
					var questionid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					console.log(questionid);
					if (confirm("Do you really want to delete this question?") == true) {
						$.ajax({
									type:'POST',
									url:address + 'deletequestions',
									contentType:"application/json",
									data:JSON.stringify({questionid:questionid,questiondetail:questiondetail,questionType:questiontype,answerid:answerid}),
									dataType:'json',
									success:function(){
											alert("right");
										}	
								});
							}
					 }
				});
		

		//show all answers
		$("#answers").on("click", function() {
			status = "answers";
			console.log(status);
			$.ajax({
				type : 'POST',
				url : address + 'getallanswers',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>AnswerID</td>"+"<td>AnswerDetail</td>"+"<td>AnswerType</td>"+"<td>Actions</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].answerid+"'>" + "<td><input type='text' stu='1' value='"+data[i].answerid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].answerdetail+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answertype+"' disabled='true'></td>"+"<td><button type='button' class='btn btn-warning' id='modify'>Edit/Save</button><button type='button' class='btn btn-danger' id='deleteit'>Delete</button></td>"+"</tr>";
					}
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});
		//modify answers
			
			$("#mytable").delegate("#modify","click",function(){
				if(status === "answers"){
				var senddata = $(this).parent().parent().attr("passdata");
				var key =  $(this).parent().parent().children()[1].getElementsByTagName("input")[0].getAttribute("stu");
				for(var i=0;i < $(this).parent().parent().children().length-1 ;i++){
					if($(this).parent().parent().children()[i].getElementsByTagName("input")[0].getAttribute("stu") == 1){
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].removeAttribute("disabled");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","0");		
					}else{
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("disabled","true");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","1");

						}
				}
				if(key == 0){

					var answerid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					var answerdetail = $(this).parent().parent().children()[1].getElementsByTagName("input")[0].value;
					var answertype = $(this).parent().parent().children()[2].getElementsByTagName("input")[0].value;
					
					$.ajax(
							{
								type:'POST',
								url:address + 'editanswers',
								contentType:"application/json",
								data:JSON.stringify({answerid:answerid,answerdetail:answerdetail,answertype:answertype}),
								dataType:'json',
								success:function(){
										//alert("right");
									},
								error:function(){
										alert("fail");
									}	
							});
						}
					}
				});
				// delete answers
				$("#mytable").delegate("#deleteit","click",function(){
					if(status === "answers"){
					var answerid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					if (confirm("Do you really want to delete this answer?") == true) {
						$.ajax({
									type:'POST',
									url:address + 'deleteanswers',
									contentType:"application/json",
									data:JSON.stringify({answerid:answerid,answerdetail:answerdetail,answertype:answertype}),
									dataType:'json',
									success:function(){
											alert("right");
										}	
								});
						}
				    }
				});

				
		//show all answer instructions
		$("#instructions").on("click", function() {
			status = "instructions";
			console.log(status);
			$.ajax({
				type : 'POST',
				url : address + 'getallanswerinstructions',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>AnswerInstructionID</td>"+"<td>AnswerInstructionDetail</td>"+"<td>AnswerID</td>"+"<td>Actions</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].instructionid+"'>" + "<td><input type='text' stu='1' value='"+data[i].instructionid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].instructiondetail+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answerid+"' disabled='true'></td>"+"<td><button type='button' class='btn btn-warning' id='modify'>Edit/Save</button><button type='button' class='btn btn-danger' id='deleteit'>Delete</button></td>"+"</tr>";
					}
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		//modify answers instructions
			
			$("#mytable").delegate("#modify","click",function(){
				if(status === "instructions"){
				var senddata = $(this).parent().parent().attr("passdata");
				var key =  $(this).parent().parent().children()[1].getElementsByTagName("input")[0].getAttribute("stu");
				for(var i=0;i < $(this).parent().parent().children().length-1 ;i++){
					if($(this).parent().parent().children()[i].getElementsByTagName("input")[0].getAttribute("stu") == 1){
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].removeAttribute("disabled");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","0");		
					}else{
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("disabled","true");	
						$(this).parent().parent().children()[i].getElementsByTagName("input")[0].setAttribute("stu","1");

						}
				}
				if(key == 0){

					var instructionid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					var instructiondetail = $(this).parent().parent().children()[1].getElementsByTagName("input")[0].value;
					var answerid = $(this).parent().parent().children()[2].getElementsByTagName("input")[0].value;

					
					$.ajax(
							{
								type:'POST',
								url:address + 'editanswersinstruction',
								contentType:"application/json",
								data:JSON.stringify({instructionid:instructionid,instructiondetail:instructiondetail,answerid:answerid}),
								dataType:'json',
								success:function(){
										//alert("right");
									},
								error:function(){
										alert("fail");
									}	
							});
					
						}
					}
				});
				// delete answers instructions
				$("#mytable").delegate("#deleteit","click",function(){
					if(status === "instructions"){
					var answerid = $(this).parent().parent().children()[0].getElementsByTagName("input")[0].value; 
					if (confirm("Do you really want to delete this answer?") == true) {
						$.ajax({
									type:'POST',
									url: address + 'deleteanswersinstruction',
									contentType:"application/json",
									data:JSON.stringify({instructionid:instructionid,instructiondetail:instructiondetail,answerid:answerid}),
									dataType:'json',
									success:function(){
											alert("right");
										}	
								});
						}
				    }
				});
		

		//show all answer feedbacks
		$("#feedbacks").on("click", function() {
			$.ajax({
				type : 'POST',
				url : address + 'getallfeedbacks',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>FeedbackID</td>"+"<td>UserID</td>"+"<td>QuestionID</td>"+"<td>AnswerValue</td>"+"<td>AnswerType</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].feedbackid+"'>" + "<td><input type='text' stu='1' value='"+data[i].feedbackid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].userid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].questionid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answervalue+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answertype+"' disabled='true'></td>"+"</tr>";
					}
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		
		//show all action feedbacks
		$("#actionfeedbacks").on("click", function() {
			$.ajax({
				type : 'POST',
				url : address + 'getallactionfeedbacks',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile = "<tr>"+"<td>ActionID</td>"+"<td>UserID</td>"+"<td>ProgramID</td>"+"<td>AnswerValue</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].actionid+"'>" + "<td><input type='text' stu='1' value='"+data[i].actionid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].userid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].programid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].answervalue+"' disabled='true'></td>"+"</tr>";
					}
					$("#mytable").html(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		//show all programs
		$("#programs").on("click", function() {
			$("#mytable").html("");
			$.ajax({
				type : 'POST',
				//url : address + 'programs',
				url : address + 'showmaincategory',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
						inmyfile += "<tr>"+"<td>CategoryID</td>"+"<td>CategoryName</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].categryid+"'>" + "<td><input type='text' stu='1' value='"+data[i].categryid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].categoryname+"' disabled='true'></td>"+"</tr>";
					}
					$("#mytable").append(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
			$.ajax({
				type : 'POST',
				url : address + 'showsubcategory',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile += "<tr>"+"<td>Subcategory</td>"+"<td>SubcategoryName</td>"+"<td>CategoryID</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].subcategoryid+"'>" + "<td><input type='text' stu='1' value='"+data[i].subcategoryid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].subcategoryname+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].categoryid+"' disabled='true'></td>"+"</tr>";
					}
					$("#mytable").append(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
			$.ajax({
				type : 'POST',
				url : address + 'showprogramdetails',
				success : function(data) {
					console.log(data);
					var inmyfile = "";
					inmyfile += "<tr>"+"<td>ProgramID</td>"+"<td>ProgramName</td>"+"<td>ProgramDetail</td>"+"<td>ProgramURL</td>"+"<td>Subcategory</td>"+"<td>ProgramType</td>"+"</tr>";
					for(var i=0;i<data.length;i++){
						inmyfile += "<tr passdata='"+data[i].programid+"'>" + "<td><input type='text' stu='1' value='"+data[i].programid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].programname+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].programdetail+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].programurl+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].subcategory+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].programtype+"' disabled='true'></td>"+"</tr>";
					}
					$("#mytable").append(inmyfile);
				},
				error : function() {
					alert("files can't populate");
				}
			});
		});

		$("#medicine").on("click", function() {
			$("#mytable").html("");
			$.ajax({
				type : 'POST',
				//url:address + 'questions',
				//url:address + 'medicinefeedback',
				url : address + 'showmedicine',
				//url : address + 'patientproflie',
				contentType:"application/json",
				//data:JSON.stringify({timeStamp:'1',date:'1',mHistory:'1',mpid:1,totalAmount:10}),
				//data:JSON.stringify({type:'pain'}),
				dataType:'json',
				success : function(data) {
					if(data == null){
							console.log("it's null");
						}else{
							console.log(data);
							var inmyfile = "";
							inmyfile += "<tr class='row'>"+"<td>MedicineID</td>"+"<td>MedicineName</td>"+"<td>UserID</td>"+"<td>MPID</td>"+"<td>MedicineDES</td>"+"<td>MaxQuatity</td>"+"<td>MedPerTime</td>"+"</tr>";
							for(var i=0;i<data.length;i++){
								inmyfile += "<tr class='row' passdata='"+data[i].medicineid+"'>" + "<td><input type='text' stu='1' value='"+data[i].medicineid+"' disabled='true'></td>" +"<td><input type='text' stu='1' value='"+data[i].medicinename+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].userid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].mpid+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].medicinedes+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].maxquatity+"' disabled='true'></td>"+"<td><input type='text' stu='1' value='"+data[i].mdpertime+"' disabled='true'></td>"+"</tr>";
							}
							$("#mytable").append(inmyfile);
						}
					
				},
				error : function() {
					alert("files can't populate");
				}
			});			
		
		});

	});
</script>
</head>

<body>
	<div class="title">
		<h1>
			<span class="label label-danger">Welcome to Admin Page </span>
		</h1>
	</div>
	<div class="mainpart">
		<div class="centerpart">
			<button type="button" class="btn btn-primary" id="accounts">Accounts</button>
			<button type="button" class="btn btn-primary" id="programs">Programs</button>
			<button type="button" class="btn btn-primary" id="questions">Questions</button>
			<button type="button" class="btn btn-primary" id="answers">Answers</button>
			<button type="button" class="btn btn-primary" id="instructions">Instructions</button>
			<button type="button" class="btn btn-primary" id="feedbacks">Feedbacks</button>
			<button type="button" class="btn btn-primary" id="actionfeedbacks">ActionFeedBacks</button>
			<button type="button" class="btn btn-primary" id="medicine">Medicine</button>
		</div>
		<div class="workarea">
			<table id="mytable" class="table table table-hover">
			</table>
		</div>
	</div>
</body>
<script>
$(function(){
	$("#mytable tbody tr td").addClass("col-md-1");	
	//alert("YEs");
});

</script>

</html>
