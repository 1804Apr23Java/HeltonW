function vote() {
	var selection = document.getElementById("chooseMovie");
	var button = document.getElementById("voteButton");
	button.addEventListener("click", results);
	function results() {
		var resultsDiv = document.getElementById("chosenMovie");
		resultsDiv.innerHTML += "Congratulations!  You've chosen " + selection.options[selection.selectedIndex].text;
	};
};
vote();

