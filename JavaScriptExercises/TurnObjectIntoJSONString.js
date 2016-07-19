function turnObjectToJson(input){
    "use strict";
    let object = {};
    for (let i = 0; i < input.length; i++) {
        let line = input[i];
        let splittedLine = line.split(' -> ');
        let property = splittedLine[0];
        let value = splittedLine[1];
        let number = Number(value);
        if(!isNaN(number)){
            value = number;
        }

        object[property] = value;
    }

    console.log(JSON.stringify(object))
}

turnObjectToJson(["name -> Angel",
    "surname -> Georgiev",
    "age -> 20",
    "grade -> 6.00",
    "date -> 23/05/1995",
    "town -> Sofia"
]);