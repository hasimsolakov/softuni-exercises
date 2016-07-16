function task(input) {
    "use strict";
    for (let i = 0; i >= 0; i++) {
        let line = input[i];
        if (line === "Stop"){
            return;
        }
        else {
            console.log(line.toString());
        }
    }
}

task([10, "Stop"]);