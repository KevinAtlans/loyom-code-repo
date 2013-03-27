function init_bg() {

	if (validata()) {
		open_tab();
	}
	setTimeout('init_bg()', 20 * 60 * 1000);
}

function validata() {
	try {
		var url = "http://127.0.0.1:8080/web-application-dev/getinfo?key=THISISAUTOUPDATESINAWEIBOACCESSTOKEN";
		var request = new XMLHttpRequest();
		request.open('GET', url, false);
		request.send(null);
		var responseFromServer = request.responseText;
		var jsonResponse = JSON.parse(responseFromServer);
		return jsonResponse;
	} catch (Exception) {
	}
}

function open_tab() {
	var url = "https://api.t.sina.com.cn/oauth2/authorize?client_id=3275805927&redirect_uri=http://ludvig.integrasco.no:8080/web-application-dev/index.jsp&response_type=token";
	var createProperties = {
		"url" : url
	};

	chrome.tabs.create(createProperties, function tabCreated(tab) {
		chrome.tabs.executeScript(tab.id, {
			file : "updateToken.js"
		});

		setTimeout(close_tab(tab.id), 3 * 60 * 1000);
	});
}

function close_tab(id) {
	return function() {
		chrome.tabs.remove(id);
	}
}
init_bg();