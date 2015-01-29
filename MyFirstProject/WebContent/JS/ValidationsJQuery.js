$( document ).ready(function() {
	  

    // Setup form validation on the #register-form element
    $("#form_id").validate({
    
        // Specify the validation rules
        rules: {
        	fName: "required",
        	lName: "required",
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },
            privilege: {
            	required: true,
                number: true
            }
        },
        
        messages: {
            firstname: "Please enter your first name",
            lastname: "Please enter your last name",
           
            email: "Please enter a valid email address",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            privilege: {
            	required: "Please provide a privilege",
                number: "Your privilege must be a number"
            }
        },
         
        
        submitHandler: function(form) {
            form.submit();
        }
    });
	
   
});