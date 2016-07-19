function parseJsonObjects(input) {
    "use strict";
    let arrayOfObjects = [];
    for (let i = 0; i < input.length; i++) {
        let line = input[i];
        let object = JSON.parse(line);
        arrayOfObjects.push(object);
    }

    for (let i = 0; i < arrayOfObjects.length; i++) {
        console.log("Name: " + arrayOfObjects[i].name);
        console.log("Age: " + arrayOfObjects[i].age);
        console.log("Date: " + arrayOfObjects[i].date);
    }
}
parseJsonObjects(['{"name":"Gosho","age":10,"date":"19/06/2005"}',
    '{"name":"Tosho","age":11,"date":"04/04/2005"}'
]);