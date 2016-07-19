<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="commands"></textarea>
    <input type="submit">
</form>
</body>
</html>

<?php
if (isset($_GET['delimiter']) && isset($_GET['commands'])){
    $delimiter = $_GET['delimiter'];
    $commands = $_GET['commands'];
    $pairs = explode("\n", $commands);
    $pairs = array_map('trim', $pairs);
    $array = [];

    for ($index = 0; $index < count($pairs); $index++){
        $pair = $pairs[$index];
        $explodedPair = explode($delimiter, $pair);
        $command = $explodedPair[0];
        $argument = $explodedPair[1];
        if ($command == 'add'){
            $array[] = $argument;
        }else if ($command == 'remove'){
            array_splice($array,$argument, 1);
        }
    }

    for ($line = 0; $line < count($array); $line++){
        echo $array[$line]."<br>";
    }
}