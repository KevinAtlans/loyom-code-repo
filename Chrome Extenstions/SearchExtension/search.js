function search_click() {
	console.log("begin search!");
	var words = document.getElementById("words").value;
	var type = document.getElementById("type").value;
	var log = "Search words:" + words + " by Search Engine of " + type + "!";
	console.log(log);

	search(words, type);
}

function search(word, type) {
	var url = "";
	switch (type) {
	case "1":
		url = "http://www.google.com#q=" + word
				+ "&start=0&maxResults=10&lr=lang_zh-CN|lang_en&ie=utf-8";
		break;
	case "2":
		url = "http://www.baidu.com/s?wd=" + word
				+ "&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8";
		break;
	case "3":
		url = "http://www.soso.com/q?sc=web&bs=%C8%A5&ch=w.uf&num=10&w=" + word;
		break;
	case "4":
		url = "http://www.sogou.com/web?query=" + word;
		break;
	}

	var createProperties = {
		"url" : url
	};
	chrome.tabs.create(createProperties, function tabCreated(tab) {
		console.log("open the link:" + createProperties);
	});
}
