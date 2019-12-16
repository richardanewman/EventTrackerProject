//Simple login - not secure//
function login(){
	
	main.textContent ='';

	let title = document.createElement('h1');
	title.textContent = 'Login';
	main.appendChild(title);

	let form = document.createElement('form')
	form.name = 'loginForm';
	main.appendChild(form);
	
	let formDiv = document.createElement('div');
	formDiv.className = 'form-group';
	form.appendChild(formDiv);
	
	let emailLabel = document.createElement('label');
	emailLabel.name = 'emailLabel';
	emailLabel.value = 'Email:';
	
	let email = document.createElement('input');
	email.className = 'form-control';
	email.type = 'text';
	email.name = 'email';
	email.placeholder = 'Enter Your Email';
	email.value = '';
	formDiv.appendChild(email);
	
	let passLabel = document.createElement('label');
	passLabel.name = 'passLabel';
	passLabel.value = 'Password:';
	
	let password = document.createElement('input');
	password.className = 'form-control';
	password.type = 'password';
	password.name = 'password';
	password.placeholder = 'Enter Your Password';
	password.value = '';
	formDiv.appendChild(password);
	
	let loginBtn = document.createElement('input');
	loginBtn.className = 'btn btn-primary';
	loginBtn.type = 'button';
	loginBtn.name = 'loginBtn';
	loginBtn.value = 'Login';
	formDiv.appendChild(loginBtn);
	
	
	document.loginForm.loginBtn.addEventListener('click', function(e) {
		e.preventDefault();
		let userInput = document.loginForm;
		validate(userInput);
	});

	
}


function validate(userInput){

	var xhr = new XMLHttpRequest();

	xhr.open('POST', 'api/login', true);
	xhr.setRequestHeader("Content-type", "application/json");


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var user = JSON.parse(xhr.responseText);
			if (user){
				
				window.bitfolio(user);
				
			
			}else {
				
				window.homeButtons();
				
			}
			
			
			
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
		
		}

	};

	
	let userObj = {
		email: userInput.email.value,
		password: userInput.password.value		
	}
	
	let userString = JSON.stringify(userObj);

	xhr.send(userString);
	

}









