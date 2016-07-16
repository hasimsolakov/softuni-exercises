function addRemove(commands) {
    "use strict";
    let array = [];
    for (let i = 0; i < commands.length; i++) {
        let splittedCommand = commands[i].split(' ');
        let action = splittedCommand[0];
        let number = Number(splittedCommand[1]);
        if (action === "add"){
            array.push(number);
        }
        else if(action === "remove"){
            array.splice(number,1);
        }
    }

    for (let i = 0; i < array.length; i++) {
        console.log(array[i]);
    }
}

addRemove(["add 3", "add 5", "remove 1", "add 2"])