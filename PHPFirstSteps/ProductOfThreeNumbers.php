<?php
    if(isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])){
        $number1 = intval($_GET['num1']);
        $number2 = intval($_GET['num2']);
        $number3 = intval($_GET['num3']);
        $negativeNumbersCount = 0;
        if($number1 == 0 || $number2 == 0 || $number3 == 0){
            echo "Positive";
            return;
        }

        if($number1 < 0){
            $negativeNumbersCount++;
        }

        if($number2 < 0){
            $negativeNumbersCount++;
        }
    
        if($number3 < 0){
            $negativeNumbersCount++;
        }

        if($negativeNumbersCount % 2 == 0){
            echo "Positive";
        }else{
            echo "Negative";
        }

    }