<html>
<head>

</head>
<body>
<form>
    Input: <textarea name="lines"></textarea>
    <input type="submit">
</form>
</body>
</html>

<?php
    if (isset($_GET['lines'])){
        $lines = $_GET['lines'];
        $array = explode("\n", $lines);
        $array = array_map('trim', $array);
        for ($index = 0; $index < count($array); $index++){
            if($array[$index] == 'Stop'){
                break;
            }

            echo $array[$index]. '<br>';
        }
    }