
function validate(frm){
	  alert("123");
	//empty  error messages
	document.getElementById("patNameErr").innerHTML="";
	document.getElementById("locationErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("hospitalErr").innerHTML="";
	
	//read from data 
	 let name=frm.patName.value;
	 let loc=frm.location.value;
	 let page=frm.age.value;
	 let hsptl=frm.hospital.value;
	 let flag=false;
	 
	 //client side form validations
	 if(name==""){
		 document.getElementById("patNameErr").innerHTML="<b> person name is madatory</b>";
		 //frm.patName.focus();
		 flag=true;
	 }
	 
	 if(loc==""){
		 document.getElementById("locationErr").innerHTML="<b> person location is madatory</b>";
		 //frm.location.focus();
		flag=true;
	 }
	 if(page==""){
		 document.getElementById("ageErr").innerHTML="<b> person age is mandatory</b>";
		 //frm.age.focus();
		flag=true;
	 }
	 else if(isNaN(page)){
		 document.getElementById("ageErr").innerHTML="<b> person age must be numeric value</b>";
		 //frm.age.focus();
		flag=true;
	 }
	 else if(page<1 || page>100){
		 document.getElementById("ageErr").innerHTML="<b> person age must be there between 1 through 100</b>";
		 //frm.age.focus();
		 flag=true;
	 }
	 
	 if(hsptl==""){
		 document.getElementById("hospitalErr").innerHTML="<b> hosptial name is mandatory</b>";
		 //frm.hospital.focus();
		 flag=true;
	 }
	 else if(hsptl.length<3 || hsptl.length>12){
		 document.getElementById("hospitalErr").innerHTML="<b> hosptial name must have min 3 chars and max of 12 chars</b>";
		 //frm.hospital.focus();
		flag=true;
	 }
	 
	 // change  vflag value to "yes" indicating client side validations are done
	 frm.vflag.value="yes";
	 
	  if(flag)
		  return false;
	  else
		  	return true;
}//function

