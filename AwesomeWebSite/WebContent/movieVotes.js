function vote() {
	var selection = document.getElementById("movieSelector");
	var button = document.getElementById("voteButton");
	button.addEventListener("click", results);
};
	function results() {
		var resultsDiv = document.getElementById("chosenMovieDiv");
		var paragraph = document.createElement("P");
		paragraph.innerHTML = "Test string";
		resultsDiv.appendChild(paragraph);
		//resultsDiv.innerHTML += "Congratulations!  You've chosen "; 
		//selection.options[selection.selectedIndex].text;
	};
//};
vote();

