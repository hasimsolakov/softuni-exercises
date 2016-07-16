function largestThreeNumbers(numbers) {
    "use strict";
    let nums = numbers.map(Number);
    let numsSorted = nums.sort((a, b) => b - a);
    let count = Math.min(3, numbers.length);
    for (let i = 0; i < count; i++){
        console.log(numsSorted[i]);
    }
}

largestThreeNumbers([4,5,-10, 20, 50]);
