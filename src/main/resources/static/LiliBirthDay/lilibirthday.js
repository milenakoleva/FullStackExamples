
function calculate() {

    var url = '/api/zadlili?';

    var age = document.getElementById('age').value;
    var washingMachinePrice = document.getElementById('waching_machine_price').value;
    var toyPrice = document.getElementById('toy_price').value;

    url = url+ 'age='+age+'&wmp='+washingMachinePrice+'&tp='+toyPrice;

    fetch(url).then(function(response) {
        return response.text()
    }).then(function(text) {
        console.log(text);
        document.getElementById('resultParagraph').textContent = text;
    });


}
