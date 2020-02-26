function generateInputs() {

    clearInputs();

    var number = parseInt(document.getElementById('number').value);
    var fieldsContainer = document.getElementById('fieldsContainer');
    for (var i = 0; i < number; i++) {
        var id = 'input_' + i;

        var label = document.createElement('label');
        label.for = id;
        var textnode = document.createTextNode('Товар ' + (i + 1) + ' ');
        label.appendChild(textnode);
        fieldsContainer.appendChild(label);

        var input = document.createElement('input');
        input.name = 'inp';
        input.type = 'number';
        input.id = id;

        fieldsContainer.appendChild(input);

        fieldsContainer.appendChild(document.createElement('br'));
    }

    document.getElementById('calculate_button').style.display = 'block';

}


function clearInputs() {
    var fieldsContainer = document.getElementById('fieldsContainer');
    fieldsContainer.innerHTML = '';
    var resultParagraph = document.getElementById('resultParagraph');
    resultParagraph.innerHTML = '';
    document.getElementById('calculate_button').style.display = 'none';
}


function calculateLogistic() {

    var url = '/api/logistic?';

    var inputs = document.getElementsByName('inp');

    for (var i = 0; i < inputs.length; i++) {
        url = url + inputs[i].id + '=' + inputs[i].value + '&';
    }

    fetch(url).then(function (response) {
        return response.text()
    }).then(function (text) {
        console.log(text);
        document.getElementById('resultParagraph').textContent = text;
    });
}
