<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        table * {
            border: 1px solid black;
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td style="">
            Red
        </td>
        <td>
            Green
        </td>
        <td>
            Blue
        </td>
    </tr>
    <?php for($i = 0, $colorIndex = 51; $i < 5; $i++, $colorIndex+=51) : ?>
    <tr>
        <td style="background-color:rgb(<?=$colorIndex?>, 0, 0)"></td>
        <td style="background-color:rgb(0, <?=$colorIndex?>, 0)"></td>
        <td style='background-color:rgb(0, 0, <?=$colorIndex?>)'></td>
    </tr>
    <?php endfor ?>
</table>
</body>
</html>