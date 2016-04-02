/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateForm() {
    
    var name = document.forms["insuranceForm"]["Name"].value;
    var address = document.forms["insuranceForm"]["Address"].value;
    var city = document.forms["insuranceForm"]["City"].value;
    var state = document.forms["insuranceForm"]["State"].value;
    var zipcode = document.forms["insuranceForm"]["Zip Code"].value;
    var contact = document.forms["insuranceForm"]["Contact Number"].value;
    var email = document.forms["insuranceForm"]["Email ID"].value;
    
    var account = document.forms["insuranceForm"]["Account Number"].value;
    var petname = document.forms["insuranceForm"]["Pet Name"].value;
    var breed = document.forms["insuranceForm"]["Breed"].value;
    var age = document.forms["insuranceForm"]["Age"].value;
    
    var diagnosis = document.forms["insuranceForm"]["Diagnosis"].value;
    
    var amountClaim = document.forms["insuranceForm"]["Amount Claimed"].value;
    var illnessDate = document.forms["insuranceForm"]["Date Illness"].value;
    
    var vet = document.forms["insuranceForm"]["Veterinarian"].value;
    var clinicName = document.forms["insuranceForm"]["Clinic Name"].value;    
    var phoneNumber = document.forms["insuranceForm"]["Phone Number"].value;
    var faxNumber = document.forms["insuranceForm"]["Fax Number"].value;
    
    var sign = document.forms["insuranceForm"]["Signature"].value;
    var dateSign = document.forms["insuranceForm"]["Date"].value;             
    
    var agreement = document.forms["insuranceForm"]["Agreement"].checked;
    
    var reg = /^[0-9]{10}$/;
    var zipReg = /^[0-9]{5}$/;
    var ageReg = /^[0-9]{1,2}$/;
    var amountReg = /^[0-9]{1,6}$/;
    
    var nameReg =/^[a-zA-Z ]+$/;
    
    var emailReg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;                 
    
    if(name === null || name.trim() === "") {                
        document.getElementById("Name").style.backgroundColor = "yellow";
        document.getElementById("Name").setAttribute("placeholder", "Name Required");        
        return false;
    }    
    else if(address === null || address.trim() === "") {                
        document.getElementById("Address").style.backgroundColor = "yellow";
        document.getElementById("Address").setAttribute("placeholder", "Address Required"); 
        return false;
    }    
    else if(city === null || city.trim() === "") {
        document.getElementById("City").style.backgroundColor = "yellow";
        document.getElementById("City").setAttribute("placeholder", "City Required"); 
        return false;
    }
    else if(state === null || state.trim() === "") {
        document.getElementById("State").style.backgroundColor = "yellow";
        document.getElementById("State").setAttribute("placeholder", "State Required"); 
        return false;
    }
    else if(zipcode === null || zipcode.trim() === "") {
        document.getElementById("Zip Code").style.backgroundColor = "yellow";
        document.getElementById("Zip Code").setAttribute("placeholder", "Zip Code Required"); 
        return false;
    }
    else if(contact === null || contact.trim() === "") {
        document.getElementById("Contact Number").style.backgroundColor = "yellow";
        document.getElementById("Contact Number").setAttribute("placeholder", "Contact Number Required"); 
        return false;
    }
    else if(email === null || email.trim() === "") {
        document.getElementById("Email ID").style.backgroundColor = "yellow";
        document.getElementById("Email ID").setAttribute("placeholder", "Email ID Required"); 
        return false;
    }
    else if(account === null || account.trim() === "") {
        document.getElementById("Account Number").style.backgroundColor = "yellow";
        document.getElementById("Account Number").setAttribute("placeholder", "Account Number Required"); 
        return false;
    }
    else if(petname === null || petname.trim() === "") {
        document.getElementById("Pet Name").style.backgroundColor = "yellow";
        document.getElementById("Pet Name").setAttribute("placeholder", "Pet Name Required"); 
        return false;
    }
    else if(breed === null || breed.trim() === "") {
        document.getElementById("Breed").style.backgroundColor = "yellow";
        document.getElementById("Breed").setAttribute("placeholder", "Breed of Pet Required"); 
        return false;
    }
    else if(age === null || age.trim() === "") {
        document.getElementById("Age").style.backgroundColor = "yellow";
        document.getElementById("Age").setAttribute("placeholder", "Age of Pet Required"); 
        return false;
    }
    else if(diagnosis === null || diagnosis.trim() === "") {
        document.getElementById("Diagnosis").style.backgroundColor = "yellow";
        document.getElementById("Diagnosis").setAttribute("placeholder", "History of illness Required"); 
        return false;
    }
    else if(amountClaim === null || amountClaim.trim() === "") {
        document.getElementById("Amount Claimed").style.backgroundColor = "yellow";
        document.getElementById("Amount Claimed").setAttribute("placeholder", "Claimed Amount is Required"); 
        return false;
    }
    else if(illnessDate === null || illnessDate.trim() === "") {
        document.getElementById("Date Illness").style.backgroundColor = "yellow";
        document.getElementById("Date Illness").setAttribute("placeholder", "Date of Illness is Required"); 
        return false;
    }
    else if(vet === null || vet.trim() === "") {
        document.getElementById("Veterinarian").style.backgroundColor = "yellow";
        document.getElementById("Veterinarian").setAttribute("placeholder", "Veterinarian Name is Required"); 
        return false;
    }
    else if(clinicName === null || clinicName.trim() === "") {
        document.getElementById("Clinic Name").style.backgroundColor = "yellow";
        document.getElementById("Clinic Name").setAttribute("placeholder", "Clinic Name is Required"); 
        return false;
    }
    else if(phoneNumber === null || phoneNumber.trim() === "") {
        document.getElementById("Phone Number").style.backgroundColor = "yellow";
        document.getElementById("Phone Number").setAttribute("placeholder", "Phone Number is Required"); 
        return false;
    }
    else if(faxNumber === null || faxNumber.trim() === "") {
        document.getElementById("Fax Number").style.backgroundColor = "yellow";
        document.getElementById("Fax Number").setAttribute("placeholder", "Fax Number is Required"); 
        return false;
    }
    else if(sign === null || sign.trim() === "") {
        document.getElementById("Signature").style.backgroundColor = "yellow";
        document.getElementById("Signature").setAttribute("placeholder", "Signature is Required"); 
        return false;
    }
    else if(dateSign === null || dateSign.trim() === "") {
        document.getElementById("Date").style.backgroundColor = "yellow";
        document.getElementById("Date").setAttribute("placeholder", "Date is Required"); 
        return false;
    }
    else if(!nameReg.test(name)) {
        document.getElementById("Name").style.backgroundColor = "yellow";
        document.getElementById("Name").setAttribute("placeholder", "Name should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(city)) {
        document.getElementById("City").style.backgroundColor = "yellow";
        document.getElementById("City").setAttribute("placeholder", "City should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(state)) {
        document.getElementById("State").style.backgroundColor = "yellow";
        document.getElementById("State").setAttribute("placeholder", "State should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(petname)) {
        document.getElementById("Pet Name").style.backgroundColor = "yellow";
        document.getElementById("Pet Name").setAttribute("placeholder", "Pet Name should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(breed)) {
        document.getElementById("Breed").style.backgroundColor = "yellow";
        document.getElementById("Breed").setAttribute("placeholder", "Breed should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(vet)) {
        document.getElementById("Veterinarian").style.backgroundColor = "yellow";
        document.getElementById("Veterinarian").setAttribute("placeholder", "Veterinarian Name should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(clinicName)) {
        document.getElementById("Clinic Name").style.backgroundColor = "yellow";
        document.getElementById("Clinic Name").setAttribute("placeholder", "Clinic Name should have only alphabets"); 
        return false;
    }
    else if(!nameReg.test(sign)) {
        document.getElementById("Signature").style.backgroundColor = "yellow";
        document.getElementById("Signature").setAttribute("placeholder", "Full Name should be provided"); 
        return false;
    }
    else if(!reg.test(contact)) {
        document.getElementById("Contact Number").style.backgroundColor = "yellow";
        document.getElementById("Contact Number").setAttribute("placeholder", "Contact Number should have exactly  10 digits"); 
        return false;
    }
    else if(!zipReg.test(zipcode)) {
        document.getElementById("Zip Code").style.backgroundColor = "yellow";
        document.getElementById("Zip Code").setAttribute("placeholder", "Zip Code should have exactly 5 digits"); 
        return false;
    }
    else if(!reg.test(account)) {
        document.getElementById("Account Number").style.backgroundColor = "yellow";
        document.getElementById("Account Number").setAttribute("placeholder", "Account Number should have exactly 10 digits"); 
        return false;
    }
    else if(!ageReg.test(age)) {
        document.getElementById("Age").style.backgroundColor = "yellow";
        document.getElementById("Age").setAttribute("placeholder", "Age can have max 2 digits"); 
        return false;
    }    
    else if(!reg.test(phoneNumber)) {
        document.getElementById("Phone Number").style.backgroundColor = "yellow";
        document.getElementById("Phone Number").setAttribute("placeholder", "Phone Number should have exactly  10 digits"); 
        return false;
    }
    else if(!reg.test(faxNumber)) {
        document.getElementById("Fax Number").style.backgroundColor = "yellow";
        document.getElementById("Fax Number").setAttribute("placeholder", "Fax Number should have exactly 10 digits"); 
        return false;
    }
    else if(!amountReg.test(amountClaim)) {
        document.getElementById("Amount Claimed").style.backgroundColor = "yellow";
        document.getElementById("Amount Claimed").setAttribute("placeholder", "Amount Claimed can have max 6 digits"); 
        return false;
    }
    else if(!emailReg.test(email)) {
        document.getElementById("Email ID").style.backgroundColor = "yellow";
        document.getElementById("Email ID").setAttribute("placeholder", "Email ID is incorrect"); 
        return false;
    }
    else if(!agreement)
    {
        alert('You must read terms and conditions. And Please agree to the terms first.');
        return false;
    }    
    else {
        return true;
    }        
      
 }