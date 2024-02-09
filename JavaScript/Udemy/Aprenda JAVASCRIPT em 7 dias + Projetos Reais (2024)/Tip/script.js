function formatMoney(value) {
    value = Math.ceil(value * 100) / 100;
    value = value.toFixed(2);
    return '$ ' + value;
}

function formatSplit(value) {
    if (value === 1) return value + ' person';
    return value + ' people';
}

function update() {
    let bill = Number(document.getElementById('yourBill').value);
    let tipPercent = document.getElementById('tipInput').value;
    let split = document.getElementById('splitInput').value;

    let tipValue = bill * (tipPercent / 100);
    let billTotal = bill + tipValue;
    let billEach = billTotal / split;

    document.getElementById('tipPercent').textContent = tipPercent + ' %';
    document.getElementById('tipValue').textContent = formatMoney(tipValue);
    document.getElementById('totalWithTip').textContent = formatMoney(billTotal);
    document.getElementById('splitValue').textContent = formatSplit(split);
    document.getElementById('billEach').textContent = formatMoney(billEach);
}