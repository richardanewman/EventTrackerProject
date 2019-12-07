window.addEventListener('load', function(e){
	console.log('Document loaded.')
	initAdmin();
});

function initAdmin(){
	document.accounts.getAccounts.addEventListener('click', function(e) {
		e.preventDefault();
		getAccounts();
});

function getAccounts(){
	
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/admin/users', true);


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var accounts = JSON.parse(xhr.responseText);
			console.log(accounts);
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
	let dataDiv = document.getElementById('div');
	dataDiv.textContent = '';
	
	let title = document.createElement('h1');
	title.textContent = 'Admin Dashboard';
	dataDiv.appendChild(title);
	
	
	let table = document.createElement('table')
	table.textContent = 'User Acounts';
	dataDiv.appendChild(table);
	
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
	
}