/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function add() {
               
              var reg = /^[0-9]{1,10}$/;
                
              // Number of inputs to create
              var number = document.getElementById("number").value;
              
              if(number === null || number.trim() === "" || !reg.test(number))  {        
                alert("Please enter a valid number!");
                document.getElementById("number").style.backgroundColor = "yellow";
                document.getElementById("number").setAttribute("placeholder", "Please enter a valid number");        
                return false;
            }    
              
              // Container <div> where dynamic content will be placed
              var container = document.getElementById("childrenDivision");
              
              container.removeChild(document.getElementById("question"));
              document.getElementById('submitButton').style.display = 'none';                           
              
              // Clear previous contents of the container
//              while (container.hasChildNodes()) {
//                  container.removeChild(container.lastChild);
//              }
              
              container.appendChild(document.createElement("br"));
              container.appendChild(document.createElement("br"));
              
              for (i=0; i < number; i++)    {
                
                var divison = document.createElement('div');
                divison.setAttribute("id", "childForm" + (i+1));
                divison.className = "form-group col-sm-6";
                document.getElementById("myForm").appendChild(divison);
                
                //var label = document.createElement('span');
                var p = document.createElement("label");
                p.innerHTML = "Please enter the name of child number " + (i+1);   
                //label.appendChild(p);
                document.getElementById("childForm" + (i+1)).appendChild(p);
                
                var line = document.createElement("br");
                document.getElementById("childForm" + (i+1)).appendChild(line);
                
                var r = document.createElement('span');
                var y = document.createElement("INPUT");
                y.setAttribute("name", "childName"+(i+1));
                y.setAttribute("type", "text");
                y.setAttribute("placeholder", "Children Name");
                y.className = "form-control";
                r.appendChild(y);
                document.getElementById("childForm" + (i+1)).appendChild(r);                                
                
                //Append breakLine
                var line = document.createElement("br");
                document.getElementById("childForm" + (i+1)).appendChild(line);                

//                
////                // Append a node with a random text
////                container.appendChild(document.createTextNode("Member " + (i+1)));
////                // Create an <input> element, set its type and name attributes
////                var input = document.createElement("input");
////                input.type = "text";
////                input.name = "child" + i;
//                container.appendChild(input);
                // Append a line break 
                //container.appendChild(document.createElement("br"));
                //container.appendChild(divison);
            }
            
            var submitDiv = document.createElement('div');
            submitDiv.setAttribute("id", "Submit");
            submitDiv.className = "form-group col-sm-12";
            document.getElementById("myForm").appendChild(submitDiv);
            
            
            var y = document.createElement("INPUT");
            y.setAttribute("name", "submit");
            y.setAttribute("type", "submit");
            y.setAttribute("value", "Submit Query");
            y.className = "btn btn-primary btn-md";            
            document.getElementById("Submit").appendChild(y);                                

}

