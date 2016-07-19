<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
    <?php for($row = 0, $rowColorIndex = 0; $row < 5; $row++, $rowColorIndex+=51) :
        ?><?php for($column = 0, $columnColorIndex = $rowColorIndex; $column < 10; $column++, $columnColorIndex+=5) :
        ?><div style="background-color: rgb(<?=$columnColorIndex?>, <?=$columnColorIndex?>, <?=$columnColorIndex?>);"></div><?php endfor
        ?><br><?php endfor ?>
</body>
</html>