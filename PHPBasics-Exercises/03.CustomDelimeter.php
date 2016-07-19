<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="lines"></textarea>
    <input type="submit">
</form>
</body>
</html>

<?php
    if (isset($_GET['lines']) && isset($_GET['delimiter'])){
        $delimiter = $_GET['delimiter'];
        $lines = $_GET['lines'];
        $array = explode($delimiter, $lines);
        $array = array_map('trim', $array);
        for ($index = 0; $index < count($array); $index++){
            if($array[$index] == 'Stop'){
                break;
            }

            echo $array[$index]. '<br>';
        }
    }