<?php
    if(isset($_GET['num1']) && isset($_GET['num2'])){
        $number1 = intval($_GET['num1']);
        $number2 = intval($_GET['num2']);
        $result;
        if($number2 >= $number1){
            $result = $number1 * $number2;
        }else{
            $result = $number1 / $number2;
        }

        echo "$result";
    }