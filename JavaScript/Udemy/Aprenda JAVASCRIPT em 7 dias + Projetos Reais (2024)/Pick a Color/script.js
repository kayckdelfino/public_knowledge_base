const colors = [
    'green', 'yellow', 'purple', 'blue', 'red',
    'orange', 'pink', 'cyan', 'magenta', 'teal',
    'maroon', 'navy', 'olive', 'indigo', 'brown',
    'coral', 'lime', 'violet', 'turquoise', 'salmon'
];
const btn = document.getElementById('btn');
const color = document.querySelector('.color');

btn.addEventListener('click', function () {
    const randomColorIndex = getRandomColorIndex();
    const randomColor = colors[randomColorIndex];
    document.body.style.background = randomColor;
    color.textContent = randomColor;
});

function getRandomColorIndex() {
    return Math.floor(Math.random() * colors.length);
}