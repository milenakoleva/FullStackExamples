
function calculate() {

    var url = '/api/zadbreaking?';

    var Minput = document.getElementById('M').value;
    var Ninput = document.getElementById('N').value;
    var Sinput = document.getElementById('S').value;

    url = url+ 'M='+Minput+'&N='+Ninput+'&S='+Sinput;

    fetch(url).then(function(response) {
        return response.text()
    }).then(function(text) {
        console.log(text);
        document.getElementById('resultParagraph').textContent = text;
    });


}
