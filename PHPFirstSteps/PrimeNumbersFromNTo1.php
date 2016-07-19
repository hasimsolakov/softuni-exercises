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
        for($i = $number1; $i > 1; $i--){
            $maxLookupValue = (int)sqrt($i);
            $isPrime = true;
            for($num = 2; $num <= $maxLookupValue; $num++){
                if($i % $num == 0){
                    $isPrime = false;
                    break;
                }
            }

            if($isPrime){
                echo "$i ";
            }
        }

    }
?>
</body>
</html>