function storeObjects(input){
    "use strict";
    let arrayOfObjects = [];
    for (let i = 0; i < input.length; i++) {
        let line = input[i];
        let splittedLine = line.split(' ->');
        let objectName = splittedLine[0];
        let objectAge = Number(splittedLine[1]);
        let objectGrade = Number(splittedLine[2]);
        let student = {name:objectName, age:objectAge, grade:objectGrade};
        arrayOfObjects.push(student);
    }

    for (let i = 0; i < arrayOfObjects.length; i++) {
        console.log("Name: " + arrayOfObjects[i].name);
        console.log("Age: " + arrayOfObjects[i].age);
        console.log("Grade: " + arrayOfObjects[i].grade.toFixed(2));
    }
}

storeObjects([
    "Pesho -> 13 -> 6.00",
    "Ivan -> 12 -> 5.57",
    "Toni -> 13 -> 4.90"
]);