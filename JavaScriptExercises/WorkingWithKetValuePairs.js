function workWithKeyValues(input) {
    "use strict"
    let array = [];
    for (let i = 0; i < input.length; i++) {
        let splittedLine = input[i].split(' ');
        let key = splittedLine[0];
        if(i !== input.length -1){
            let value = splittedLine[1];
            array[key] = value;
        }
        else {
            let value = array[key];
            console.log((value == null) ? "None" : value);
        }
    }
}

workWithKeyValues(["3 bla", "3 alb","2"])