function ajaxGet(url, func){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}


/* GET array of all pending reimbursements */
var employeeURL = "http://localhost:8083/Reimbursement/AllPendingReimbursements";
ajaxGet(employeeURL, populateAllPendingReimbursements);

function populateAllPendingReimbursements(xhr){
    console.log(JSON.parse(xhr.responseText));
    var reimbursementsArray = JSON.parse(xhr.responseText);
    var pendingTable = document.getElementById("allEmployeesPendingReimbursements");
    for(i in reimbursementsArray){
        var reimbursementId = reimbursementsArray[i].reimbursementId;
        var dateTimeStamp = reimbursementsArray[i].dateTimeStamp;
        var requesterEmployeeId = reimbursementsArray[i].requesterEmployeeId;
        var approvalStatus = reimbursementsArray[i].approvalStatus;
        var approvalManagerId = reimbursementsArray[i].approvalManagerId;
        if(approvalManagerId == 0){
            approvalManagerId == "none";
        }
        var descriptionNote = reimbursementsArray[i].descriptionNote;
        var currencyValue = reimbursementsArray[i].currencyValue;

        var newTableRow = document.createElement("tr");
        newTableRow.innerHTML = `
        <th scope="row">${reimbursementId}</th>
            <td>${dateTimeStamp}</td>
            <td>${requesterEmployeeId}</td>
            <td>${approvalStatus}</td>
            <td>${approvalManagerId}</td>
            <td>${descriptionNote}</td>
            <td>${currencyValue}</td>
        `;
        pendingTable.appendChild(newTableRow);
    }
}

/* GET array of all resolved reimbursements */
employeeURL = "http://localhost:8083/Reimbursement/AllResolvedReimbursements";
ajaxGet(employeeURL, populateAllResolvedReimbursements);

function populateAllResolvedReimbursements(xhr){
    console.log(JSON.parse(xhr.responseText));
    var reimbursementsArray = JSON.parse(xhr.responseText);
    var resolvedTable = document.getElementById("allEmployeesResolvedReimbursements");
    for(i in reimbursementsArray){
        var reimbursementId = reimbursementsArray[i].reimbursementId;
        var dateTimeStamp = reimbursementsArray[i].dateTimeStamp;
        var requesterEmployeeId = reimbursementsArray[i].requesterEmployeeId;
        var approvalStatus = reimbursementsArray[i].approvalStatus;
        var approvalManagerId = reimbursementsArray[i].approvalManagerId;
        if(approvalManagerId == 0){
            approvalManagerId == "none";
        }
        var descriptionNote = reimbursementsArray[i].descriptionNote;
        var currencyValue = reimbursementsArray[i].currencyValue;

        var newTableRow = document.createElement("tr");
        newTableRow.innerHTML = `
        <th scope="row">${reimbursementId}</th>
            <td>${dateTimeStamp}</td>
            <td>${requesterEmployeeId}</td>
            <td>${approvalStatus}</td>
            <td>${approvalManagerId}</td>
            <td>${descriptionNote}</td>
            <td>${currencyValue}</td>
        `;
        resolvedTable.appendChild(newTableRow);
    }
}


/* GET array of all employees */
employeeURL = "http://localhost:8083/Reimbursement/AllEmployeeInfo";
ajaxGet(employeeURL, populateAllEmployees);

function populateAllEmployees(xhr){
    var employeesArray = JSON.parse(xhr.responseText);
    var employeesTable = document.getElementById("allEmployeesInfo");
    for(i in employeesArray){
        var employeeId = employeesArray[i].employeeId;
        var username = employeesArray[i].userName;
        var firstName = employeesArray[i].firstName;
        var lastName = employeesArray[i].lastName;
        var email = employeesArray[i].email;
        if(employeesArray[i].manager == true){
            var isManager = "Manager";
        } else {
            var isManager = "Employee";
        }

        var newTableRow = document.createElement("tr");
        newTableRow.innerHTML = `
        <th scope="row">${employeeId}</th>
            <td>${username}</td>
            <td>${firstName}</td>
            <td>${lastName}</td>
            <td>${email}</td>
            <td>${isManager}</td>
        `;
        employeesTable.appendChild(newTableRow);
    }
}