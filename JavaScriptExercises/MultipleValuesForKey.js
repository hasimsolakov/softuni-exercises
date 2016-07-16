function workWithKeyMultipleValues(input) {
    "use strict"
    let array = [[]];
    for (let i = 0; i < input.length; i++) {
        let splittedLine = input[i].split(' ');
        let key = splittedLine[0];
        if(i !== input.length -1){
            let value = splittedLine[1];
            let check = array[key];
            if (check != null){
                check.push(value);
                array[key] = check;
            }
            else{
                array[key] = [value];
            }
        }
        else {
            let value = array[key];
            if (value == null){
                console.log("None");
            }
            else{
                for (let index = 0; index < value.length; index++) {
                    console.log(value[index]);
                }
            }
        }
    }
}
workWithKeyMultipleValues(["key value", "key eulav", "test tset", "key"]);