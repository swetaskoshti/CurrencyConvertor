function validate() {
	 var baseCurrency = FXData.baseCurrency.value;
     var senderEmailID = FXData.senderEmailID.value;
     var password = FXData.password.value;
     var receiverEmailID = FXData.receiverEmailID.value;
     if (baseCurrency == null || baseCurrency.trim() == "") {
         alert('Base Currency cannot be empty');
         FXData.baseCurrency.focus();
         return false; // cancel submission
     } 
     else if ( senderEmailID == null || senderEmailID.trim() == ""){
     	alert("Sender's EmailID cannot be empty.");
     	FXData.senderEmailID.focus();
         return false; // cancel submission
     }
     else if ( password == null || password.trim() == ""){
      	alert('Password cannot be empty.');
      	FXData.password.focus();
          return false; // cancel submission
      }
     else if ( receiverEmailID == null || receiverEmailID.trim() == ""){
      	alert("Receiver's EmailID cannot be empty.");
      	FXData.receiverEmailID.focus();
          return false; // cancel submission
      }
     else if ( senderEmailID != null || senderEmailID.trim() != "" || receiverEmailID != null || receiverEmailID.trim() != ""){
     	var returnsenderEmailID = ValidateEmail(senderEmailID);
     	var returnreceiverEmailID = ValidateEmail(receiverEmailID);
     	if(!returnsenderEmailID){
     		alert("You have entered an invalid Sender's email address!");
     		FXData.senderEmailID.focus();
      	   return false; // cancel submission
     	}
     	if(!returnreceiverEmailID){
     		alert("You have entered an invalid Receiver's email address!");
     		FXData.receiverEmailID.focus();
      	   return false; // cancel submission
     	}
     }
     else {
         document.FXData.submit(); // allow submit
     }
}

function ValidateEmail(inputText)
{
	if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(inputText))
	{
		return true;
	}
	else
	{
		return false;
	}
}