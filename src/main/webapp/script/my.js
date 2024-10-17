function deleteTask(taskId) {
    let url = "/" + taskId;
    $.ajax({
        url: url,
        type: 'DELETE',
        success: function () {
            window.location.reload();
        }
    });
}

function getDropdownStatusHtml(taskId) {
    let statusId = "selectStatus" + taskId;
    return "<label for='status'></label>"
        + "<select id=" + statusId + " name='status'>"
        + "<option value='IN_PROGRESS'>IN_PROGRESS</option>"
        + "<option value='DONE'>DONE</option>"
        + "<option value='PAUSED'>PAUSED</option>"
        + "</select>";
}

function editTask(taskId) {
    // lock delete button
    let deleteId = "#delete" + taskId;
    $(deleteId).remove();

    // replace edit button with save
    let editId = "#edit" + taskId;
    let saveTag = "<button id='save" + taskId + "'>Save</button>";
    $(editId).html(saveTag);
    let savePropertyTag = "updateTask(" + taskId + ")";
    $(editId).attr("onclick", savePropertyTag);

    // make description editable
    let currentTrElement = $(editId).parent().parent();
    let children = currentTrElement.children();
    let tdDescription = children[1];
    tdDescription.innerHTML = "<input id='inputDescription" + taskId + "' type = 'text' value = '"
        + tdDescription.innerHTML + "'>";

    // make status editable
    let tdStatus = children[2];
    let statusId = "#selectStatus" + taskId;
    let currentValueStatus = tdStatus.innerHTML;
    tdStatus.innerHTML = getDropdownStatusHtml(taskId);
    $(statusId).val(currentValueStatus).change();
}

function updateTask(taskId) {
    let url = "/" + taskId;

    let descriptionValue = $("#inputDescription" + taskId).val();
    let statusValue = $("#selectStatus" + taskId).val();

    $.ajax({
        url: url,
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        data: JSON.stringify({
            "description": descriptionValue,
            "status": statusValue
        })
    });

    setTimeout(() => document.location.reload(), 300);
}

function addTask() {
    let descriptionValue = $("#postDescription").val();
    let statusValue = $("#postStatus").val();

    $.ajax({
        url: "/",
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        async: false,
        data: JSON.stringify({
            "description": descriptionValue,
            "status": statusValue
        })
    });

    setTimeout(() => document.location.reload(), 300);
}