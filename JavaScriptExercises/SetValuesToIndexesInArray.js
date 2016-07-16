function setValues(input) {
    "use strict";
    let n = Number(input[0])
    let array = [];
    for (let j = 0; j < n; j++) {
        array.push(0);
    }

    for (let i = 0; i < input.length - 1; i++) {
        let line = input[i + 1];
        let splittedLine = line.split('-');
        let currentIndex = Number(splittedLine[0]);
        let value;
        if(splittedLine[1] == " "){
            value = Number("-" + splittedLine[2]);
        }
        else {
            value = splittedLine[1];
        }
         
        array[currentIndex] = value;
    }

    for (let index = 0; index < array.length; index++) {
        console.log(array[index]);
    }
}

setValues([5, "0-3", "3- -1", "4-2"])