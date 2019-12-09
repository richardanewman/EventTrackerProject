window.addEventListener('load', function(e) {
	console.log('Document loaded.');

	let welcome = document.createElement('h1');
	welcome.textContent = 'Bitfolio';
	document.body.appendChild(welcome);

	homeButtons();
	init();

});

function init() {

	// //////////////////////////Divs///////////////////////////
	let main = document.createElement('div')
	main.textContent = '';
	main.id = 'main';
	main.className = 'jumbotron'
	document.body.appendChild(main);

	// ///////////////////////Event Listeners///////////////////
	document.login.loginBtn.addEventListener('click', function(e) {
		e.preventDefault();
		window.login();

	});

	document.register.registerBtn.addEventListener('click', function(e) {
		e.preventDefault();
		window.registration();

	});

}

function homeButtons() {

	// ///////////// Login //////////////////////
	let buttonDiv = document.createElement('div')
	buttonDiv.textContent = '';
	document.body.appendChild(buttonDiv);
	
	let login = document.createElement('form');
	login.name = 'login';
	buttonDiv.appendChild(login);
	
	let loginBtn = document.createElement('input');
	loginBtn.name = 'loginBtn';
	loginBtn.type = 'button';
	loginBtn.value = 'Login';
	login.appendChild(loginBtn);

	// ///////////// Register //////////////////////

	let register = document.createElement('form');
	register.name = 'register';
	buttonDiv.appendChild(register);
	
	let registerBtn = document.createElement('input');
	registerBtn.name = 'registerBtn';
	registerBtn.type = 'button';
	registerBtn.value = 'Register';
	register.appendChild(registerBtn);

}

