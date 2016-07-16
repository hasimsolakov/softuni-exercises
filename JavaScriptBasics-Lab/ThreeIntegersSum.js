function threeIntegersSum(numbers) {
    "use strict";
    let nums = numbers[0].split(' ').map(Number);
    console.log(
        check(nums[0], nums[1], nums[2]) ||
        check(nums[0], nums[2], nums[1]) ||
        check(nums[1], nums[2], nums[0]) || 'No');

    function check(num1, num2, sum) {
        if (num1 + num2 != sum){
            return false;
        }
        if (num1 > num2){
            let temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return `${num1} + ${num2} = ${sum}`;
    }
}

threeIntegersSum("-2 -3 -5");


