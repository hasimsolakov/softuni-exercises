<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Array-size: <input type="text" name="array-size">
    Input: <textarea name="key-value-pairs"></textarea>
    <input type="submit">
</form>
</body>
</html>
<?php
    if (isset($_GET['delimiter']) && isset($_GET['array-size']) && isset($_GET['key-value-pairs'])){
        $delimiter = $_GET['delimiter'];
        $arraySize = $_GET['array-size'];
        $keyValues = $_GET['key-value-pairs'];
        $pairs = explode("\n", $keyValues);
        $pairs = array_map('trim', $pairs);
        $array = [$arraySize];
        for ($i = 0; $i < $arraySize; $i++){
            $array[$i] = 0;
        }


        for ($index = 0; $index < count($pairs); $index++){
            $pair = $pairs[$index];
            $explodedPair = explode($delimiter, $pair);
            $key = $explodedPair[0];
            $value = $explodedPair[1];
            $array[$key] = $value;
        }

        for ($line = 0; $line < count($array); $line++){
            echo $array[$line]."<br>";
        }
    }