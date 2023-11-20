const canvas = document.getElementById("canvasView");
const ctx = canvas.getContext("2d");
const JSONview = document.getElementById("JSON");

function seeDrawing(shapes){

for (Figura figura : shapes){
const size = figura.size;
const x = figura.x;
const y = figura.y;
const color = figura.color
const fill = figura.fill
const shape = figura.shape
if(figura.type === "circle"){
 ctx.beginPath();
ctx.arc(x, y, radius, 0, 2 * Math.PI);

}
else if(figura.type === "square"){
 ctx.beginPath();
ctx.rect(x - size / 2, y - size / 2, size, size);
}else if(figura.type === "triangle"){
const height = (Math.sqrt(3) / 2) * size;

                    ctx.beginPath();
                    ctx.moveTo(x - size / 2, y + height / 2);
                    ctx.lineTo(x + size / 2, y + height / 2);
                    ctx.lineTo(x, y - height / 2);
                    ctx.closePath();
}
ctx.stroke
ctx.beginPath();

}

else if (figura === "rectangle"){
ctx.beginPath();
ctx.rect(x - size / 2, y - size / 4, size, size / 2);
}
}