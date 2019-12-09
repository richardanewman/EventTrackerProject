function bitfolio(user){
	console.log('bitfolio loaded.');
	console.log(user);

	displayPortfolios(user);
	profileInit(user);
}

function profileButtons(user){
	
	
//	///////////////Get All Portfolios Button//////////////////////
//	let buttonDiv = document.createElement('div');
//	buttonDiv.textContent = '';
//	document.body.appendChild(buttonDiv);
//	let portfolios = document.createElement('form');
//	portfolios.name = 'portfolios';
//	buttonDiv.appendChild(portfolios);
//	let portfoliosButton = document.createElement('input');
//	portfoliosButton.name = 'getPortBtn';
//	portfoliosButton.type = 'button';
//	portfoliosButton.value = 'Get All Portfolios';
//	portfolios.appendChild(portfoliosButton);
//	
//	 ///////////////Get All Coin Watches Button//////////////////////
//	let acctById = document.createElement('form');
//	acctById.name = 'acctById'
//	buttonDiv.appendChild(acctById);
//	let inputId = document.createElement('input');
//	inputId.name = 'id';
//	inputId.type = 'number';
//	acctById.appendChild(inputId);
//	let idButton = document.createElement('input');
//	idButton.name = 'idButton';
//	idButton.type = 'button';
//	idButton.value = 'Get Account By ID';
//	acctById.appendChild(idButton);
//	
}


function profileInit(user) {

	



	
	
	////////////////////////Coins Event Listener/////////////////////////////
	let coinRows = document.getElementsByClassName('coinRow');
	
	for(let i=0; i<coinRows.length; i++){
		
		coinRows[i].addEventListener('click', function(e) {
		e.preventDefault();
		console.log('listening to coin clicks');
		
		let coinForms = document.getElementsByName("coinEditForm");
		if(coinForms){
			for (let i=0; i<coinForms.length; i++){
				coinForms[i+1].textContent = '';
				e.preventDefault();
			}
		}
	
		getCoinEditForm(coinRows[i]);

	});
	
	}
	
	////////////////////////Portfolios Event Listener/////////////////////////////
	let portNames = document.getElementsByClassName('portHead');
	
	for(let i=0; i<portNames.length; i++){
		
		portNames[i].addEventListener('click', function(e) {
			e.preventDefault();
			
			let forms = document.getElementsByName('editForm');
			if(forms){
				for (let i=0; i<forms.length; i++){
					forms[i+1].textContent = '';
					e.preventDefault();
				
				}
			
			}
			
			
			getPortEditForm(portNames[i]);
			
		});
		
		
	}
	
	
	

}

function getPortEditForm(portfolio){
	console.log(portfolio);
	let id = portfolio.id;
	
	
	
	
	let form = document.createElement('form');
	form.name = 'editForm';
	portfolio.appendChild(form);
	
	let formDiv = document.createElement('div');
	formDiv.className = 'form-group';
	form.appendChild(formDiv);
	
	
	let portName = document.createElement('input');
	portName.className = 'form-control';
	portName.type = 'text';
	portName.name = 'portName';
	portName.placeholder = 'Enter New Name';
	portName.value = '';
	formDiv.appendChild(portName);
	
	let editBtn = document.createElement('input');
	editBtn.className = 'btn btn-primary';
	editBtn.type = 'button';
	editBtn.name = 'editBtn';
	editBtn.value = 'Edit Name';
	formDiv.appendChild(editBtn);
	
	editBtn.addEventListener('click', function(e) {
		e.preventDefault();
		let userInput = document.editForm;
		editPortName(userInput, id);
		console.log('in form');
		console.log(userInput);
		
	});
	
	
}

function getCoinEditForm(coinRow){
	
	console.log('in coin edit form');
	console.log(coinRow);
	
	
	let coinForm = document.createElement('form')
	coinForm.name = 'coinEditForm';
	coinRow.appendChild(coinForm);
	
	let coinDiv = document.createElement('div');
	coinDiv.className = 'form-group';
	coinForm.appendChild(coinDiv);
	
	let coinLabel = document.createElement('label');
	coinLabel.name = 'coinName';
	coinLabel.innerHTML = 'Coin Name:';
	coinDiv.appendChild(coinLabel);
	
	let coinName = document.createElement('input');
	coinName.className = 'form-control';
	coinName.type = 'text';
	coinName.name = 'coinName';
	coinName.placeholder = 'Enter New Name';
	coinName.value = coinRow.children[0].innerHTML;
	coinDiv.appendChild(coinName);
	
	let tpLabel = document.createElement('label');
	tpLabel.name = 'tradingPair';
	tpLabel.innerHTML = 'Trading Pair:';
	coinDiv.appendChild(tpLabel);
	
	let tradingPair = document.createElement('input');
	tradingPair.className = 'form-control';
	tradingPair.type = 'text';
	tradingPair.name = 'tradingPair';
	tradingPair.placeholder = '';
	tradingPair.value = coinRow.children[1].innerHTML;
	coinDiv.appendChild(tradingPair);
	
	let exLabel = document.createElement('label');
	exLabel.name = 'exLabel';
	exLabel.innerHTML = 'Exchange:';
	coinDiv.appendChild(exLabel);
	
	let exchange = document.createElement('input');
	exchange.className = 'form-control';
	exchange.type = 'text';
	exchange.name = 'exchange';
	exchange.placeholder = '';
	exchange.value = coinRow.children[2].innerHTML;
	coinDiv.appendChild(exchange);
	
	let dateLabel = document.createElement('label');
	dateLabel.name = 'dateLabel';
	dateLabel.innerHTML = 'Date:';
	coinDiv.appendChild(dateLabel);
	
	let date = document.createElement('input');
	date.className = 'form-control';
	date.type = 'text';
	date.name = 'date';
	date.placeholder = '';
	date.value = coinRow.children[3].innerHTML;
	coinDiv.appendChild(date);
	
	let timeLabel = document.createElement('label');
	timeLabel.name = 'timeLabel';
	timeLabel.innerHTML = 'Time:';
	coinDiv.appendChild(timeLabel);
	
	let time = document.createElement('input');
	time.className = 'form-control';
	time.type = 'text';
	time.name = 'time';
	time.placeholder = '';
	time.value = coinRow.children[4].innerHTML;
	coinDiv.appendChild(time);
	
	let priceLabel = document.createElement('label');
	priceLabel.name = 'priceLabel';
	priceLabel.innerHTML = 'Price:';
	coinDiv.appendChild(priceLabel);
	
	let price = document.createElement('input');
	price.className = 'form-control';
	price.type = 'text';
	price.name = 'price';
	price.placeholder = '';
	price.value = coinRow.children[5].innerHTML;
	coinDiv.appendChild(price);
	
	let editCoinBtn = document.createElement('input');
	editCoinBtn.className = 'btn btn-primary';
	editCoinBtn.type = 'button';
	editCoinBtn.name = 'editCoinBtn';
	editCoinBtn.value = 'Edit Name';
	coinDiv.appendChild(editCoinBtn);
	
	editCoinBtn.addEventListener('click', function(e) {
		e.preventDefault();
		let userInput = document.coinEditForm;
		console.log('trying to edit coin');
		
	});
	
	
}


function displayPortfolios(user){
	
	main.textContent = '';

	var ports = user.portfolios;
	
	
	
	let title = document.createElement('h1');
	title.textContent = user.firstName + "'s" + ' Bitfolio';
	main.appendChild(title);
	
	
	let table = document.createElement('div')
	main.appendChild(table);
	
	
	for(let i=0; i<ports.length; i++){
	
		
		let portTable = document.createElement('div')
		main.appendChild(portTable);
		var portHead = document.createElement('th')
		portHead.className = 'portHead';
		portHead.id = ports[i].id;
		portHead.textContent = ports[i].portfolioName;
		portTable.appendChild(portHead);
	
		
		let table = document.createElement('div')
		main.appendChild(table);
		let th1 = document.createElement('th')
		th1.textContent = ' Coin ';
		table.appendChild(th1);
		let th2 = document.createElement('th')
		th2.textContent = ' Trading Pair ';
		table.appendChild(th2);
		let th3 = document.createElement('th')
		th3.textContent = ' Exchange ';
		table.appendChild(th3);
		let th4 = document.createElement('th')
		th4.textContent = ' Date ';
		table.appendChild(th4);
		let th5 = document.createElement('th')
		th5.textContent = ' Time ';
		table.appendChild(th5);
		let th6 = document.createElement('th')
		th6.textContent = ' Price ';
		table.appendChild(th6);
		let th7 = document.createElement('th')
		th7.textContent = ' Amount ';
		table.appendChild(th7);
		let th8 = document.createElement('th')
		th8.textContent = ' Trade Fee ';
		table.appendChild(th8);
		let th9 = document.createElement('th')
		th9.textContent = ' Notes ';
		table.appendChild(th9);
		
		var coinList = user.portfolios[i].coins;
		
		
		for (let i=0; i<coinList.length; i++){
		
			
		var coinRow = document.createElement('div');
		coinRow.className = 'coinRow';
		coinRow.id = coinList[i].id;
		table.appendChild(coinRow);

		
		let coinData1 = document.createElement('td');
		coinData1.name = 'name';
		table.appendChild(coinRow);
		coinRow.appendChild(coinData1);
		coinData1.textContent = coinList[i].name;
		
		let coinData2 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData2);
		coinData2.textContent = coinList[i].tradingPair;
		
		let coinData3 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData3);
		coinData3.textContent = coinList[i].exchange;
		
		let coinData4 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData4);
		coinData4.textContent = coinList[i].purchaseDate;
		
		let coinData5 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData5);
		coinData5.textContent = coinList[i].purchaseTime;
		
		let coinData6 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData6);
		coinData6.textContent = coinList[i].buyPrice;
		
		let coinData7 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData7);
		coinData7.textContent = coinList[i].amountPurchased;
		
		let coinData8 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData8);
		coinData8.textContent = coinList[i].exchangeFee;
		
		let coinData9 = document.createElement('td');
		table.appendChild(coinRow);
		coinRow.appendChild(coinData9);
		coinData9.textContent = coinList[i].notes;
		
		
		
		}
	
	}
	
	

}

function editPortName(userInput, id){
	console.log('in editPortName')
	console.log(userInput);
	
	var xhr = new XMLHttpRequest();

	xhr.open('PUT', 'api/user/' + id + '/portfolio', true);
	xhr.setRequestHeader("Content-type", "application/json");


	xhr.onreadystatechange = function() {
	
		if (xhr.readyState === 4 && xhr.status < 400) {
			var user = JSON.parse(xhr.responseText);
			bitfolio(user);
			
			
			
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
		}

	};

	
	let editObj = { portfolioName: userInput.portName.value }

	let editString = JSON.stringify(editObj);
	console.log(editString);
	
	xhr.send(editString);
	
	
	
	
}









function dispayCoinWatch(user){
	
	//TODO
	
	
}







