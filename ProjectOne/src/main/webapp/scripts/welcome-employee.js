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

/* GET array of pending reimbursements */
var employeeURL = "http://localhost:8083/Reimbursement/ThisEmployeesPendingReimbursements";
ajaxGet(employeeURL, populatePendingReimbursements);

function populatePendingReimbursements(xhr){
    console.log(JSON.parse(xhr.responseText));
    var reimbursementsArray = JSON.parse(xhr.responseText);
    var pendingTable = document.getElementById("thisEmployeesPendingReimbursements");
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

/* GET array of resolved reimbursements */
employeeURL = "http://localhost:8083/Reimbursement/ThisEmployeesResolvedReimbursements";
ajaxGet(employeeURL, populateResolvedReimbursements);

function populateResolvedReimbursements(xhr){
    var reimbursementsArray = JSON.parse(xhr.responseText);
    var resolvedTable = document.getElementById("thisEmployeesResolvedReimbursements");
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