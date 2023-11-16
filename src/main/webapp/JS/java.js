let shapes = []


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

        //const shapes = []; // Array para almacenar las figuras

        console.log(shapes);

        let isDrawing = false;
        let isFreehandDrawing = false;
        let currentLine = []; // Array para almacenar los puntos de la línea actual

        brushCheckbox.addEventListener("change", () => {
            isDrawing = brushCheckbox.checked;
            isFreehandDrawing = false; // Reinicia el modo de trazo a mano alzada
            currentLine = []; // Reinicia la línea actual
        });

        clearCanvasButton.addEventListener("click", () => {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            const shapes = [];
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

                // Almacena cada punto de la línea actual
                currentLine.push({ x: event.offsetX, y: event.offsetY });
            }
        });

        canvas.addEventListener("mouseup", () => {
            isFreehandDrawing = false;

            // Almacena la línea actual en el array de figuras
            if (currentLine.length > 0) {
                shapes.push({
                    type: "line",
                    points: currentLine,
                    color: colorInput.value
                });

                console.log(shapes);
            }

            currentLine = []; // Reinicia la línea actual
        });

        canvas.addEventListener("mouseout", () => {
            isFreehandDrawing = false;
        });

        canvas.addEventListener("click", (event) => {
            if (!isDrawing) {
                const selectedShape = shapeSelect.value;
                const x = event.offsetX; // Obtener la coordenada x
                const y = event.offsetY; // Obtener la coordenada y

                // Objeto que representa la figura actual
                const figura = {
                    type: selectedShape,
                    x: x,
                    y: y,
                    size: shapeSizeInput.value,
                    color: colorInput.value,
                    fill: fillShapeCheckbox.checked
                };

                // Agregar la figura al array
                shapes.push(figura);
                 const shapesJSON = JSON.stringify(shapes);
                        document.getElementById("draw").value = shapesJSON;


                console.log(shapes);

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
                } else if (selectedShape === "rectangle") {
                    const size = shapeSizeInput.value;
                    ctx.beginPath();
                    ctx.rect(x - size / 2, y - size / 4, size, size / 2);
                    if (fillShapeCheckbox.checked) {
                        ctx.fillStyle = colorInput.value;
                        ctx.fill();
                    }
                    ctx.stroke();
                }
            }
        });

        // Poner dentro de una función que se llama cada vez que se añade una
        // objeto al dibujo


    }
});
