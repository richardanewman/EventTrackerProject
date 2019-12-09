
function registration() {

	main.textContent ='';

	let title = document.createElement('h1');
	title.textContent = 'Registration';
	main.appendChild(title);

	let form = document.createElement('form')
	form.name = 'regForm';
	main.appendChild(form);
	
	let formDiv = document.createElement('div');
	formDiv.className = 'form-group';
	form.appendChild(formDiv);
	
	let firstLabel = document.createElement('label');
	firstLabel.name = 'firstName';
	firstLabel.innerHTML = 'First Name:';
	formDiv.appendChild(firstLabel);

	let firstName = document.createElement('input');
	firstName.className = 'form-control';
	firstName.type = 'text';
	firstName.name = 'first';
	firstName.placeholder = 'Enter First Name';
	firstName.value = '';
	formDiv.appendChild(firstName);
	
	let lastLabel = document.createElement('label');
	lastLabel.name = 'lastName';
	lastLabel.innerHTML = 'Last Name:';
	formDiv.appendChild(lastLabel);
	
	let lastName = document.createElement('input');
	lastName.className = 'form-control';
	lastName.type = 'text';
	lastName.name = 'last';
	lastName.placeholder = 'Enter Last Name';
	lastName.value = '';
	formDiv.appendChild(lastName);
	
	let userLabel = document.createElement('label');
	userLabel.name = 'userName';
	userLabel.innerHTML = 'Username:';
	formDiv.appendChild(userLabel);

	let username = document.createElement('input');
	username.className = 'form-control';
	username.type = 'text';
	username.name = 'username';
	username.placeholder = 'Enter A UserName';
	username.value = '';
	formDiv.appendChild(username);
	
	let emailLabel = document.createElement('label');
	emailLabel.name = 'emailLabel';
	emailLabel.innerHTML = 'Email:';
	formDiv.appendChild(emailLabel);
	
	let email = document.createElement('input');
	email.className = 'form-control';
	email.type = 'text';
	email.name = 'email';
	email.placeholder = 'Enter Your Email';
	email.value = '';
	formDiv.appendChild(email);
	
	let passLabel = document.createElement('label');
	passLabel.name = 'passLabel';
	passLabel.innerHTML = 'Password:';
	formDiv.appendChild(passLabel);
	
	let password = document.createElement('input');
	password.className = 'form-control';
	password.type = 'password';
	password.name = 'password';
	password.placeholder = 'Enter A Password';
	password.value = '';
	formDiv.appendChild(password);
	
	let regBtn = document.createElement('input');
	regBtn.className = 'btn btn-primary';
	regBtn.type = 'button';
	regBtn.name = 'regBtn';
	regBtn.value = 'Register';
	formDiv.appendChild(regBtn);
	
	
	document.regForm.regBtn.addEventListener('click', function(e) {
		e.preventDefault();
		let userInput = document.regForm;
		createUser(userInput);
	});

}


function createUser(userInput){

	var xhr = new XMLHttpRequest();

	xhr.open('POST', 'api/user', true);
	xhr.setRequestHeader("Content-type", "application/json");


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var user = JSON.parse(xhr.responseText);
			
			//TODO
			
			
			
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
			notFound();
		}

	};

	
	let newUserObj = {
		user: {
			firstName: userInput.first.value,
			lastName: userInput.last.value
		},
		username: userInput.username.value,
		email: userInput.email.value,
		password: userInput.password.value		
	}

	let newUserString = JSON.stringify(newUserObj);
	
	xhr.send(newUserString);

	
}
