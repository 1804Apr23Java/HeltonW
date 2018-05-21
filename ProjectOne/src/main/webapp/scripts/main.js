document.getElementById("employeeLoginButton").addEventListener("click", function(){
    window.location.assign('views/login.html');
});

document.getElementById("myButton").addEventListener("click", function(){
    getEmployeeInfo("http://localhost:8083/GetEmployeeInfo/")
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
    xhr.open("GET", url, true);
    xhr.setRequestHeader("username", username);
    xhr.send();
}