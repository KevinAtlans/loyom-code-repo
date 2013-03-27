var json = null;
function get() {
	json = getinfo();
	setTimeout('findBoxAndSetValue()', 2000);
}

function getinfo() {
	try {
		var url = "http://ludvig.integrasco.no:8080/web-application-dev/getinfo?key=THISISAUTOUPDATESINAWEIBOACCESSTOKEN";
		var request = new XMLHttpRequest();
		request.open('GET', url, false);
		request.send(null);
		var responseFromServer = request.responseText;
		var jsonResponse = JSON.parse(responseFromServer);
		return jsonResponse;
	} catch (Exception) {
	}
}

function findBoxAndSetValue() {
	console.log("name:" + json.name);
	console.log("pass:" + json.pass);
	try {
		var name_element = $('input[class="WB_iptxt oauth_form_input"][id="userId"][name="userId"]');
		var pass_element = $('input[type="password"][class="WB_iptxt oauth_form_input"][id="passwd"][name="passwd"][node-type="passwd"]');
		name_element.val(json.name);
		pass_element.val(json.pass);
		setTimeout('submit_click()', 1000);
	} catch (Exception) {
	}
}

function submit_click() {
	try {
		var submit_element = $('a[node-type="submit"][action-type="submit"]');
		submit_element[0].click();
		console.log("Update access token successful! info : " + json.name);
	} catch (Exception) {
		console.log(" Update access token fails!  Failure of information:"
				+ json.name);
	}
}

function start() {
	setTimeout('get()', 2000);
}

window.onload = start;
