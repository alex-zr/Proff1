$(document).ready(init);

function init() {
    show();
    $('#add_contact').bind('click', addContact);
}

function addContact() {
    var tr = $('<tr></tr>');
    tr.append($('<td></td>').append('<input type="checkbox" name="toDelete[]" value="0" id="checkbox_0"/>'));
    tr.append($('<td></td>').append('<input type="text" id="name"/>'));
    tr.append($('<td></td>').append('<input type="text" id="surname"/>'));
    tr.append($('<td></td>').append('<input type="text" id="phone"/> '));
    tr.append($('<td></td>').append('<input type="text" id="email"/>'));
    tr.append($('<td></td>').append('<input type="text" id="groupName"/>'));
    tr.append($('<td><td/>').append('<input type="submit" onclick="javascript: sendData()" value="save"/>'));

    $('#table').append(tr);
}

function sendData() {

    var contactData = {
        'name': document.getElementById('name').value,
        'surname': document.getElementById('surname').value,
        'phone': document.getElementById('phone').value,
        'email': document.getElementById('email').value,
        'groupName': document.getElementById('groupName').value
    };

    $.ajax({
        type: 'PUT',
        url: '/contacts/new',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(contactData)
    });

    getNew();
}

function getNew() {
    $.ajax({
        url: '/contacts',
        success: function (jsondata) {
            var newContact = jsondata[jsondata.length-1];
            var tr = $('<tr></tr>');
            tr.append($('<td></td>').append('<input type="checkbox" name="toDelete[]" value="' + newContact.id + '" id="checkbox_' + newContact.id +'"/>'));
            tr.append($('<td></td>').text(newContact.name));
            tr.append($('<td></td>').text(newContact.surname));
            tr.append($('<td></td>').text(newContact.phone));
            tr.append($('<td></td>').text(newContact.email));
            tr.append($('<td></td>').text(newContact.groupName));

            $('#table').append(tr);

        },

        error: function (a, b, c) {
            alert(a+b+c);
        }
    });
}

function show() {
    $.ajax({
        //dataType: 'json',
        //type: 'GET',
        url: '/contacts',
        success: function (jsondata) {
            //alert(jsondata);
            for (var i = 0; i < jsondata.length; i++) {
                var contact = jsondata[i];
                var tr = $('<tr></tr>');
                tr.append($('<td></td>').append('<input type="checkbox" name="toDelete[]" value="' + contact.id + '" id="checkbox_' + contact.id +'"/>'));
                tr.append($('<td></td>').text(contact.name));
                tr.append($('<td></td>').text(contact.surname));
                tr.append($('<td></td>').text(contact.phone));
                tr.append($('<td></td>').text(contact.email));
                tr.append($('<td></td>').text(contact.groupName));

                $('#table').append(tr);
            }
        },
        error: function (a, b, c) {
            alert(a + b + c);
        }
    });
    //alert($('#login').val());
    var login = $('#login').val();
    var pass = $('#pass').val();
    var tr = $('<tr></tr>');
    tr.append($('<td></td>').text(login));
    tr.append($('<td></td>').text(pass));

    /*    $('#table').append(tr);
        $('#one').css({background:"red", color:"white"});
        $('#two').css("border", "red");
        $('#two, #three').css("fontWeight", "bold");*/
}
