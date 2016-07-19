<?php
    if(isset($_GET['num'])){
    $number1 = intval($_GET['num']);
        for($i = 1; $i <= $number1; $i++){
            echo "$i ";
        }
    }