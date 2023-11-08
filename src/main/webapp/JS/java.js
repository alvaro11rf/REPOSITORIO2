

const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

const brushSizeInput = document.getElementById("size");
const shapeSizeInput = document.getElementById("size");
const colorInput = document.getElementById("color");
const clearCanvasButton = document.getElementById("clearCanvas");

let isDrawing = false;
let lastX = 0;
let lastY = 0;

canvas.addEventListener("mousedown", () => {
    isDrawing = true;
    [lastX, lastY] = [event.offsetX, event.offsetY];
});

canvas.addEventListener("mousemove", draw);
canvas.addEventListener("mouseup", () => (isDrawing = false));
canvas.addEventListener("mouseout", () => (isDrawing = false));

function draw() {
    if (!isDrawing) return;
    ctx.strokeStyle = colorInput.value;
    ctx.lineWidth = brushSizeInput.value;
    ctx.lineJoin = "round";
    ctx.lineCap = "round";
    ctx.beginPath();
    ctx.moveTo(lastX, lastY);
    ctx.lineTo(event.offsetX, event.offsetY);
    ctx.stroke();
    [lastX, lastY] = [event.offsetX, event.offsetY];
}

clearCanvasButton.addEventListener("click", () => {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
});

colorInput.addEventListener("input", () => {
    ctx.strokeStyle = colorInput.value;
});

// Ejemplo de cómo dibujar una figura (círculo) en el lienzo
function drawShape(x, y) {
    const size = shapeSizeInput.value;
    ctx.fillStyle = colorInput.value;
    ctx.beginPath();
    ctx.arc(x, y, size, 0, Math.PI * 2);
    ctx.fill();
}

canvas.addEventListener("click", (event) => {
    const x = event.offsetX;
    const y = event.offsetY;
    drawShape(x, y);
});
