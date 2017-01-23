function populateJobsForm(id, description) {
    document.getElementById('addBtn').style.display='none';
    document.getElementById('saveBtn').style.display='inline-block';
    document.getElementById('clearBtn').style.display='inline-block';
    document.getElementById('jobsFormId').setAttribute('value', id);
    document.getElementById('jobsFormDescription').setAttribute('value', description);
}

function clearJobsForm() {
    document.getElementById('addBtn').style.display='inline-block';
    document.getElementById('saveBtn').style.display='none';
    document.getElementById('clearBtn').style.display='none';
    document.getElementById('jobsFormId').setAttribute('value', '');
    document.getElementById('jobsFormDescription').setAttribute('value', '');
}