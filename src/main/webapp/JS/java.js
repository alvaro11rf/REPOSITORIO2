document.addEventListener("DOMContentLoaded", function () {
    const canvas = document.getElementById("canvas");
    if (canvas) {
        const ctx = canvas.getContext("2d");

        const brushCheckbox = document.getElementById("brush");
        const shapeSelect = document.getElementById("shapeSelect");
        const fillShapeCheckbox = document.getElementById("fillShape");
        const clearCanvasButton = document.getElementById("clearCanvas");
        const shapeSizeInput = document.getElementById("size");
        const colorInput = document.getElementById("color");

        let isDrawing = false;
        let isFreehandDrawing = false;

        brushCheckbox.addEventListener("change", () => {
            isDrawing = brushCheckbox.checked;
            isFreehandDrawing = false; // Reinicia el modo de trazo a mano alzada
        });

        clearCanvasButton.addEventListener("click", () => {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
        });

        colorInput.addEventListener("input", () => {
            if (!brushCheckbox.checked) {
                ctx.strokeStyle = colorInput.value;
            }
        });

        canvas.addEventListener("mousedown", (event) => {
            if (brushCheckbox.checked) {
                isFreehandDrawing = true;
                isDrawing = true;
                ctx.strokeStyle = colorInput.value;
                ctx.lineWidth = shapeSizeInput.value;
                ctx.lineJoin = "round";
                ctx.lineCap = "round";
                ctx.beginPath();
                ctx.moveTo(event.offsetX, event.offsetY);
            }
        });

        canvas.addEventListener("mousemove", (event) => {
            if (isFreehandDrawing && isDrawing) {
                ctx.lineTo(event.offsetX, event.offsetY);
                ctx.stroke();
            }
        });

        canvas.addEventListener("mouseup", () => {
            isFreehandDrawing = false;
        });

        canvas.addEventListener("mouseout", () => {
            isFreehandDrawing = false;
        });

        canvas.addEventListener("click", (event) => {
            if (!isDrawing) {
                const selectedShape = shapeSelect.value;
                const x = event.offsetX;
                const y = event.offsetY;

                ctx.strokeStyle = colorInput.value;
                ctx.lineWidth = 2;

                if (selectedShape === "circle") {
                    const radius = shapeSizeInput.value;
                    ctx.beginPath();
                    ctx.arc(x, y, radius, 0, 2 * Math.PI);
                    if (fillShapeCheckbox.checked) {
                        ctx.fillStyle = colorInput.value;
                        ctx.fill();
                    }
                    ctx.stroke();
                } else if (selectedShape === "square") {
                    const size = shapeSizeInput.value;
                    ctx.beginPath();
                    ctx.rect(x - size / 2, y - size / 2, size, size);
                    if (fillShapeCheckbox.checked) {
                        ctx.fillStyle = colorInput.value;
                        ctx.fill();
                    }
                    ctx.stroke();
                } else if (selectedShape === "triangle") {
                    const size = shapeSizeInput.value;
                    const height = (Math.sqrt(3) / 2) * size;

                    ctx.beginPath();
                    ctx.moveTo(x - size / 2, y + height / 2);
                    ctx.lineTo(x + size / 2, y + height / 2);
                    ctx.lineTo(x, y - height / 2);
                    ctx.closePath();

                    if (fillShapeCheckbox.checked) {
                        ctx.fillStyle = colorInput.value;
                        ctx.fill();
                    }
                    ctx.stroke();
                }
            }
        });
    }
});