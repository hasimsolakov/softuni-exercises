function getProductSign(nums){
    "use strict";
    let x = Number(nums[0]);
    let y = Number(nums[1]);
    let z = Number(nums[2]);
    let negativeNumsCount = 0;
    if(x ===0||y===0|| z===0){
        return "Positive";
    }
    if(x < 0){
        negativeNumsCount++;
    }
    if(y < 0){
        negativeNumsCount++;
    }
    if(z < 0){
        negativeNumsCount++;
    }

    if(negativeNumsCount % 2 === 1){
        return "Negative";
    }
    else{
        return "Positive";
    }
}

console.log(getProductSign([4,5,-6]))
