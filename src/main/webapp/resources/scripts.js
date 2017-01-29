function populateJobsForm(id, description) {
    document.getElementById('add-button').style.display='none';
    document.getElementById('save-button').style.display='inline-block';
    document.getElementById('clear-button').style.display='inline-block';
    document.getElementById('admin-edit-jobs-form-id').innerHTML = id;
    document.getElementById('admin-edit-jobs-form-description').setAttribute('value', description);
}

function clearJobsForm() {
    document.getElementById('add-button').style.display='inline-block';
    document.getElementById('save-button').style.display='none';
    document.getElementById('clear-button').style.display='none';
    document.getElementById('admin-edit-jobs-form-id').innerHTML = "";
    document.getElementById('admin-edit-jobs-form-description').setAttribute('value', '');
}

function displayLabel(id, defaultLabelName){
    if(id.value === '') {
        id.value = defaultLabelName;
        id.style.opacity = 0.5;
    }
}

function hideLabel(id, defaultLabelName) {
    if (id.value === defaultLabelName) {
        id.value = "";
        id.style.opacity = 1;
    }
}

function makeLabels() {
    var firstname = document.getElementById('firstname');
    displayLabel(firstname, 'first name');

    var lastname = document.getElementById('lastname');
    displayLabel(lastname, 'last name');

    var email = document.getElementById('email');
    displayLabel(email, 'email');

    var description = document.getElementById('description');
    displayLabel(description, 'description');
}

