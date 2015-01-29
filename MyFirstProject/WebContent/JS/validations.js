	function add() {
		
		var myName = document.getElementById("userId");
		var fName = document.getElementById("fName");
		var lName = document.getElementById("lName");
		var paswd = document.getElementById("password");
		var privilege = document.getElementById("privilege");
		var table = document.getElementById("userData");

		var myNameValue = myName.value;
		var fNameValue = fName.value;
		var lNameValue = lName.value;
		var paswdValue = paswd.value;
		var privilgeValue = privilege.value;
		var tableValue = table.value;

		if (myNameValue == null || myNameValue == "") {
			alert("ID must be filled out");
		} else if (fNameValue == null || fNameValue == "") {
			alert("First name must be filled out");
		} else if (lNameValue == null || lNameValue == "") {
			alert("Last name must be filled out");
		} else if (paswdValue == null || paswdValue == "") {
			alert("Password must be filled out");
		} else if (privilgeValue == null || privilgeValue == "") {
			alert("Privilege must be filled out");
		} else {
			if (isAlphabet(fName, "Please enter only letters for your f name")) {
				if (isAlphabet(fName,
						"Please enter only letters for your l name")) {
					if (isAlphanumeric(paswd,
							"Numbers and Letters Only for Address")) {
						if (isNumeric(privilege,
								"Please enter a valid numeric privilege")) {
							var rowCount = table.rows.length;
							var row = table.insertRow(rowCount);
							row.insertCell(0).innerHTML = myName.value;
							row.insertCell(1).innerHTML = fName.value;
							row.insertCell(2).innerHTML = lName.value;
							row.insertCell(3).innerHTML = paswd.value;
							row.insertCell(4).innerHTML = privilege.value;
							row.insertCell(5).innerHTML = '<input type="button" value = "Delete" onClick="Javacsript:deleteContent(this)">';
						}
					}

				}

			}
		}
	}

	function isAlphabet(elem, helperMsg) {
		var alphaExp = /^[a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}

	function isAlphanumeric(elem, helperMsg) {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}

	function isNumeric(elem, helperMsg) {
		var numericExpression = /^[0-9]+$/;
		if (elem.value.match(numericExpression)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}

	function deleteContent(obj) {
		var retVal = confirm("Do you want to continue ?");
		   if( retVal == true ){
			   var index = obj.parentNode.parentNode.rowIndex;
				var table = document.getElementById("userData");
				table.deleteRow(index);
		   }else{
		      alert("User does not want to continue!");
			  
		   }
		

	}

	function deleteUserTableContent() {
		var table = document.getElementById("userData");
		//or use :  var table = document.all.tableid;
		for (var i = table.rows.length - 1; i > 0; i--) {
			table.deleteRow(i);
		}

	}
	function clearValues() {
		document.getElementById("userId").value = "";
		document.getElementById("fName").value = "";
		document.getElementById("lName").value = "";
		document.getElementById("password").value = "";
		document.getElementById("privilege").value = "";

	}

	function load() {

		document.location.href='Search';    

	}