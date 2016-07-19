<?php
    if(isset($_GET['num'])){
        $num = intval($_GET['num']);
        $result = $num * 2;
        echo "$result";
    }