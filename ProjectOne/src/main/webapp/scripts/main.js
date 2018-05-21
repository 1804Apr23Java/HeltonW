//irrelevant for now
document.getElementById("employeeLoginButton").addEventListener("click", function(){
    window.location.assign('views/login.html');
});

//button that fires off xhr with username and returns Employee obj as string
document.getElementById("myButton").addEventListener("click", function(){
    getEmployeeInfo("/GetEmployeeInfo")
});


function getEmployeeInfo(url){
	document.getElementById("myOutput").innerHTML = "called getEmployeeInfo";
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            document.getElementById("myOutput").innerHTML = xhr.responseText;
        }
    };
    var username = document.getElementById("myUserName").value;
    xhr.open("POST", url, true);

    //how to send info to servlet?  just need username
    xhr.setRequestHeader("username", username);
    xhr.send();
}