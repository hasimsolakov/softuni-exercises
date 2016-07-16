function run(nums){
    "use strict";
    let n = Number(nums[0]);
    let x = Number(nums[1]);
    if(x >= n){
        return n*x;
    }
    else{
        return n/x;
    }
}

console.log(run([4,5]));
console.log(run([6,4]));