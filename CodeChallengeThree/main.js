// WHEN USER CLICKS THE BOOK TITLE IN CURRENT LIST
// First change the background of list element to green
// Then display the book information in Book Details

currentBookShelfList = document.querySelectorAll(".ownedBook");
for(var i = 0; i < currentBookShelfList.length; i++){
    console.log(i);
    currentBookShelfList[i].addEventListener("click", function(){        
        document.getElementsByClassName("bookSelectedInMainList")[0].classList.remove("bookSelectedInMainList");
        this.className += " bookSelectedInMainList";
        // display and/or hide book blocks here
    });
}

// WHEN USER CLICKS ON "ADD NEW BOOK" BUTTON
// read input fields
// if all fields are not empty, build an html object
// append new title to ul#id="myBookTitles"
// append new bookDisplay div element to myBookDetails div
// set new input to selected
document.getElementById("newBook").addEventListener("click", function(){
    var newBookTitle = document.getElementById("newBookTitle").value;
    var newAuthor = document.getElementById("newAuthor").value;
    var newGenre = document.getElementById("newGenre").value;
    var newImage = document.getElementById("newImage").value;
    if(newBookTitle == false || newAuthor == false ||
        newGenre == false || newImage == false){
            return;
        }
    
    // build new div here
    var newBook = document.createElement("div");
    newBook.setAttribute("class", "bookDisplay");

    // just a console print
    console.log("new book is: " + newBookTitle + " " + newAuthor + " " + newGenre + " " + newImage);

});