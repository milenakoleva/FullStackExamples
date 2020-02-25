
function calculate() {

    var url = '/api/returntopast?';

    var money = document.getElementById('money').value;
    var year = document.getElementById('year').value;

    url = url+ 'money='+money+'&year='+year;

    fetch(url).then(function(response) {
        return response.text()
    }).then(function(text) {
        console.log(text);
        document.getElementById('resultParagraph').textContent = text;
    });
}
