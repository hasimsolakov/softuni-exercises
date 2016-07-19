<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
    <?php
        $number = 3;
        $blueButton = "<button style='background-color:blue'>1</button>";
        $whiteButton = "<button>0</button>";

        echo "$blueButton"."$blueButton"."$blueButton"."$blueButton"."$blueButton"."<br>";
        for($iteration = 1; $iteration <= $number; $iteration++){
            echo "$blueButton"."$whiteButton"."$whiteButton"."$whiteButton"."$whiteButton"."<br>";
        }

        echo "$blueButton"."$blueButton"."$blueButton"."$blueButton"."$blueButton"."<br>";

        for($iteration1 = 1; $iteration1 <= $number; $iteration1++){
            echo "$whiteButton"."$whiteButton"."$whiteButton"."$whiteButton"."$blueButton"."<br>";
        }
        echo "$blueButton"."$blueButton"."$blueButton"."$blueButton"."$blueButton"."<br>";
    ?>
</body>
</html>