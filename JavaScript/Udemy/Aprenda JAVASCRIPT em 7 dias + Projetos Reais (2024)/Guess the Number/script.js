let computerNumber;
let userNumbers = [];
let attempts = 0;
const maxGuesses = 10;

function newGame() {
    window.location.reload();
}

function init() {
    computerNumber = Math.floor(Math.random() * 100 + 1);
    console.log(computerNumber);
}

function compareNumbers() {
    const userNumber = Number(document.getElementById('inputBox').value);
    userNumbers.push(' ' + userNumber);
    document.getElementById('guesses').textContent = userNumbers;

    if (attempts < maxGuesses) {
        if (userNumber > computerNumber) {
            document.getElementById('textOutput').textContent = 'Your number is too high';
            document.getElementById('inputBox').value = '';
            attempts++;
            document.getElementById('attempts').textContent = attempts;
        } else if (userNumber < computerNumber) {
            document.getElementById('textOutput').textContent = 'Your number is too low';
            document.getElementById('inputBox').value = '';
            attempts++;
            document.getElementById('attempts').textContent = attempts;
        } else {
            document.getElementById('textOutput').textContent = 'Congratulations!!!';
            attempts++;
            document.getElementById('attempts').textContent = attempts;
            document.getElementById('inputBox').setAttribute('readonly', 'readonly');
        }
    } else {
        document.getElementById('textOutput').textContent = 'You Lose! The computer number was ' + computerNumber;
        document.getElementById('inputBox').setAttribute('readonly', 'readonly');
    }
}