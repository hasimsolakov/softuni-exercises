<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num" />
    <input type="submit" />
</form>
<?php
    if(isset($_GET['num'])){
        $number1 = intval($_GET['num']);
        $previousNum1 = 0;
        $previousNum2 = 0;
        $previousNum3 = 0;
        for($i = 1; $i <= $number1; $i++){
            if($i == 1){
                echo "$i ";
                $previousNum1 = $i;
            }
            else{
                $result = $previousNum1 + $previousNum2 + $previousNum3;
                echo "$result ";
                $previousNum3 = $previousNum2;
                $previousNum2 = $previousNum1;
                $previousNum1 = $result;
            }
        }

    }
?>
</body>
</html>