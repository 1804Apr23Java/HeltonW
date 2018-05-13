// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
  
function getUSA(){
    var myElement = document.querySelector("[data-customAttr='USA']");
    // console.log(myElement.innerHTML);
    console.dir(myElement);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
  
function getPeopleInSales(){
    var myEmployeeNames = document.getElementsByClassName("empName");
    for(var i = 0; i < myEmployeeNames.length; i++){
        var dept = myEmployeeNames[i].nextElementSibling.innerHTML;
        if(dept == "Sales"){
            console.log(myEmployeeNames[i].innerHTML);
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
  
function getAnchorChildren(){
    var anchorSpans = document.querySelectorAll("a > span");
    for(var i = 0; i < anchorSpans.length; i++){
        console.log(anchorSpans[i].innerHTML);
    }
}

// 4. Hobbies
// Define function 	
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getSelectedHobbies(){
    var selectedHobbies = document.querySelectorAll("select[name='skills'] > option[selected='selected']");
    for(var i = 0; i < selectedHobbies.length; i++){
        console.log(selectedHobbies[i].getAttribute("value"));
        console.log(selectedHobbies[i].innerHTML);
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute(){
    var customAttributeTags = document.querySelectorAll("[data-customAttr]");
    for(var i = 0; i < customAttributeTags.length; i++){
        console.log(customAttributeTags[i].getAttribute("data-customAttr"));
        console.log(customAttributeTags[i]);
    }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:	
// <input id="num1" class="nums" type="text"/>	
// <input id="num2" class="nums" type="text"/>	
// <h3>Sum: span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

var num1 = 0, num2 = 0;
var num1Element = document.getElementById("num1");
var num2Element = document.getElementById("num2");
var sumSpan = document.getElementById("sum");
num1Element.addEventListener("change", sumNums1and2);
num2Element.addEventListener("change", sumNums1and2);

function sumNums1and2(){
    num1 = num1Element.value;
    num2 = num2Element.value;
    var result = parseInt(num1) + parseInt(num2);
    if(isNaN(result)){
        sumSpan.innerHTML = "Cannot add!";
    } else {
        sumSpan.innerHTML = result;
    }    
};

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:	
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

var skillsSelector = document.querySelector("select[name='skills']");
skillsSelector.addEventListener("change", function() {
   alert("Are you sure " + 
   skillsSelector.options[skillsSelector.selectedIndex].text + 
   " is one of your skills?"); 
});

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:	
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) 
// the newly selected favoriteColor

var radioColors = document.querySelectorAll("[name='favoriteColor']");
var lastChecked;

for(var i = 0; i < radioColors.length; i++){
    radioColors[i].addEventListener("change", function(){
        for(var j = 0; j < radioColors.length; j++){
            if(radioColors[j].checked){
                alert("So you like " + radioColors[j].value + " more than " + lastChecked + " now?");
                lastChecked = radioColors[j].value;
                for(var k = 0; k < radioColors.length; k++){
                    console.log(radioColors[k]);
                    radioColors[k].style.backgroundColor = radioColors[j].value;
                }
            }
        }
    });
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:	
// Hide the name if shown.
// 	Show the name if hidden.

var empNames = document.getElementsByClassName("empName");
for(var i = 0; i < empNames.length; i++){
    empNames[i].style.opacity = 1;
    empNames[i].addEventListener("mouseenter", toggleOpacity);
}

function toggleOpacity(){
    if(this.style.opacity == 1){
        this.style.opacity = 0;
    } else {
        this.style.opacity = 1;
    }    
}

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
var i = 0;
var timeHeader = document.getElementById("currentTime");
setInterval(function(){
    var outDate = new Date();
    var rawHours = outDate.getHours();
    var amOrPm = (rawHours < 12 ? 'am' : 'pm');
    var fixedHours = (rawHours < 12 ? rawHours : rawHours-12);
    fixedHours = zeroTime(fixedHours);
    var fixedMinutes = zeroTime(outDate.getMinutes());
    var fixedSeconds = zeroTime(outDate.getSeconds());
    var dateString = fixedHours + ":" + fixedMinutes + ":" + fixedSeconds + " " + amOrPm;
    timeHeader.innerHTML = dateString;
}, 1000);

function zeroTime(inputTime){
    if(inputTime < 10){
        return "0" + inputTime.toString();
    }
    return inputTime;
}

// 11. Delay
// Regarding this element:
// 	s
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

document.getElementById("helloWorld").addEventListener("click", function(){    
    setTimeout(function(){ 
        document.getElementById("helloWorld").style.color = '#' + (Math.random() * 0xFFFFFF << 0).toString(16); 
    }, 3000);    
});

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. 
// Use recursion.
// On each node, call func(node).

function walkTheDOM(node, func){
    func(node);

    var allChildren = node.children;
    for(var i = 0; i < allChildren.length; i++){
        walkTheDOM(allChildren[i], func);
    }
}

var func = function printNode(node){
    console.log(node.nodeName);
}

//test cases
//1.
//should print dir of the span

// //2.
// console.log("Question 2 : Should be 'John, Austin, Courtney, Scout' : ");
// getPeopleInSales();

// //3.
// console.log("Question 3 : Should be 'Here1, Here2, Here, Here3' : ");
// getAnchorChildren();

// //4.
// console.log("Question 4 : Should be 'dom, DOM, javascript, JavaScript' : ");
// getSelectedHobbies();

// //5.
// console.log("Question 5 : Should be 'USA, <span data-customattr='USA'>States</span>', (4 more) : ");
// getCustomAttribute();

//6.
//test by adding numbers to num1 and num2 inputs

//7.
//test by selecting skills from the selector box

//8.
//test by clicking color radio buttons

//9.
//test by hovering over employee names

//12.
//should print HTML, HEAD, META, etc.
// var htmlNode = document.getElementsByTagName("HTML")[0];
// walkTheDOM(htmlNode, func);