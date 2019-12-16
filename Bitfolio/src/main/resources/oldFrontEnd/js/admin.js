window.addEventListener('load', function(e){
	console.log('Document loaded.')
	adminButtons();
	initAdmin();
	
});

function initAdmin(){
	
	let acctTitle = document.createElement('h1');
	acctTitle.textContent = '';
	acctTitle.textContent = 'Admin Dashboard';
	document.body.appendChild(acctTitle);
	
	////////////////////////////Divs///////////////////////////
	var accountDiv = document.createElement('div')
	accountDiv.id = 'accountDiv';
	document.body.appendChild(accountDiv);
	
	
	/////////////////////////Event Listeners///////////////////
	document.accounts.getAcctBtn.addEventListener('click', function(e) {
		e.preventDefault();
		getAccounts();
	});
	
	document.acctById.idButton.addEventListener('click', function(e) {
		e.preventDefault();

		let id = document.acctById.id.value;
		getAccountById(id);
		
	});
	
}

function adminButtons(){
	
	
	///////////////Get All Accounts Button//////////////////////
	let buttonDiv = document.createElement('div');
	buttonDiv.textContent = '';
	document.body.appendChild(buttonDiv);
	let accounts = document.createElement('form');
	accounts.name = 'accounts';
	buttonDiv.appendChild(accounts);
	let accountsButton = document.createElement('input');
	accountsButton.name = 'getAcctBtn';
	accountsButton.type = 'button';
	accountsButton.value = 'Get All Accounts';
	accounts.appendChild(accountsButton);
	
	///////////////Get Account By ID//////////////////////
	let acctById = document.createElement('form');
	acctById.name = 'acctById'
	buttonDiv.appendChild(acctById);
	let inputId = document.createElement('input');
	inputId.name = 'id';
	inputId.type = 'number';
	acctById.appendChild(inputId);
	let idButton = document.createElement('input');
	idButton.name = 'idButton';
	idButton.type = 'button';
	idButton.value = 'Get Account By ID';
	acctById.appendChild(idButton);
	
}

function getAccounts(){
	
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/admin/users', true);


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var accounts = JSON.parse(xhr.responseText);
			displayAccounts(accounts);
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
			notFound();
		}

	};

	xhr.send(null);
	
	
	
}

function displayAccounts(accounts) {

	
	accountDiv.textContent = '';

	
	let title = document.createElement('h1');
	title.textContent = 'User Accounts';
	accountDiv.appendChild(title);
	
	
	let table = document.createElement('table')
	accountDiv.appendChild(table);
	let th1 = document.createElement('th')
	th1.textContent = 'ID';
	table.appendChild(th1);
	let th2 = document.createElement('th')
	th2.textContent = 'Name';
	table.appendChild(th2);
	let th3 = document.createElement('th')
	th3.textContent = 'Email';
	table.appendChild(th3);
	
	for(let i=0; i<accounts.length; i++){
		
		let user = document.createElement('tr');
		let userData1 = document.createElement('td');
		table.appendChild(user);
		user.appendChild(userData1);
		userData1.textContent = accounts[i].id;
		let userData2 = document.createElement('td');
		table.appendChild(user);
		user.appendChild(userData2);
		userData2.textContent = accounts[i].username;
		let userData3 = document.createElement('td');
		table.appendChild(user);
		user.appendChild(userData3);
		userData3.textContent = accounts[i].email;	
	
		
	}
	

}

function getAccountById(id){
	
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/user/' + id, true);


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var account = JSON.parse(xhr.responseText);
			displayAcct(account);
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
			notFound();
		}

	};

	xhr.send(null);
	
	
}

function displayAcct(account){
	
	
	accountDiv.textContent = '';

	
	let title = document.createElement('h1');
	title.textContent = 'User Account';
	accountDiv.appendChild(title);
	
	
	let table = document.createElement('table')
	accountDiv.appendChild(table);
	let th1 = document.createElement('th')
	th1.textContent = 'ID';
	table.appendChild(th1);
	let th2 = document.createElement('th')
	th2.textContent = 'Name';
	table.appendChild(th2);
	let th3 = document.createElement('th')
	th3.textContent = 'Email';
	table.appendChild(th3);
	
	let user = document.createElement('tr');
	let userData1 = document.createElement('td');
	table.appendChild(user);
	user.appendChild(userData1);
	userData1.textContent = account.id;
	let userData2 = document.createElement('td');
	table.appendChild(user);
	user.appendChild(userData2);
	userData2.textContent = account.username;
	let userData3 = document.createElement('td');
	table.appendChild(user);
	user.appendChild(userData3);
	userData3.textContent = account.email;	
	
	
}
	
