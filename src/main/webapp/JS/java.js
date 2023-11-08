document.addEventListener("DOMContentLoaded", function () {
    const canvas = document.getElementById("canvas");
    if (canvas) {
        const ctx = canvas.getContext("2d");

        const brushCheckbox = document.getElementById("brush");
        const shapeSizeInput = document.getElementById("size");
        const colorInput = document.getElementById("color");
        const clearCanvasButton = document.getElementById("clearCanvas");

        let isDrawing = false;

        // Agrega un evento de escucha al cambio en el estado de la casilla de verificación
        brushCheckbox.addEventListener("change", () => {
            isDrawing = brushCheckbox.checked; // Habilita o deshabilita el dibujo a mano alzada
        });

        // Variables para el inicio y fin del trazo
        let lastX, lastY;

        // Agrega un evento de escucha para el movimiento del mouse en el lienzo
        canvas.addEventListener("mousedown", (event) => {
            isDrawing = true;
            [lastX, lastY] = [event.offsetX, event.offsetY];
        });

        canvas.addEventListener("mousemove", (event) => {
            if (!isDrawing) return;
            ctx.strokeStyle = colorInput.value;
            ctx.lineWidth = shapeSizeInput.value;
            ctx.lineJoin = "round";
            ctx.lineCap = "round";
            ctx.beginPath();
            ctx.moveTo(lastX, lastY);
            ctx.lineTo(event.offsetX, event.offsetY);
            ctx.stroke();
            [lastX, lastY] = [event.offsetX, event.offsetY];
        });

        // Agrega un evento de escucha al soltar el botón del mouse para detener el dibujo
        canvas.addEventListener("mouseup", () => {
            isDrawing = false;
        });

        // Agrega un evento de escucha para salir del lienzo para detener el dibujo
        canvas.addEventListener("mouseout", () => {
            isDrawing = false;
        });

        clearCanvasButton.addEventListener("click", () => {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
        });

        colorInput.addEventListener("input", () => {
            ctx.strokeStyle = colorInput.value;
        });
    }
});