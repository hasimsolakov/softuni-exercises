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
        for($i = $number1; $i >= 1; $i--){
            if($number1 % $i > 0){
                echo "$i ";
            }
        }

    }
?>
</body>
</html>