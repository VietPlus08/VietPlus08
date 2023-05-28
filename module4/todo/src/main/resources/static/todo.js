const baseUrl = window.location.origin;

function saveNewAction() {
    const content = document.getElementById("content").value;
    const title = document.getElementById("title").value;

    const data = {
        content: content,
        title: title,
    }

    fetch(baseUrl + "/task/", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(res => res.json())
        .then(response => {
            document.getElementById("content").value = "";
            document.getElementById("title").value = "";
            drawTableFromResponseJson(JSON.stringify(response))
        })
        .catch(error => alert("title content should be something!!!"))
}

function drawTableFromResponseJson(str) {
    document.getElementById("bodyList").innerHTML = drawRecord(JSON.parse(str));
}

function drawRecord(str) {
    let tableResult = "";
    str.forEach(x => tableResult += `<tr><td>${x.title}</td>
<td>${x.content}</td>
<td><button onclick="updateById(${x.id},'cancel')" class="btn btn-outline-danger"><img src="img/icons8-delete-128.png"></button>
<button onclick="updateById(${x.id},'done')" class="btn btn-outline-info"><img src="img/loading.png"></button></td></tr>`)
    return tableResult;
}

function updateById(id, local) {
    fetch(`${baseUrl}/task/${local}/id/${id}`, {
        method: 'PATCH',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    })
        .then(resp => resp.json())
        .then(resp => {
            drawTableFromResponseJson(JSON.stringify(resp))
        })
}

window.onload = () => {
    fetch(baseUrl + "/task/")
        .then(resp => resp.json())
        .then(resp => {
            drawTableFromResponseJson(JSON.stringify(resp))
        })
}