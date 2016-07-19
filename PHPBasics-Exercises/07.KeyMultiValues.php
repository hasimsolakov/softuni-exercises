<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="key-value-pairs"></textarea>
    Target Key: <input type="text" name="target-key">
    <input type="submit">
</form>
</body>
</html>

<?php
    if (isset($_GET['delimiter']) && isset($_GET['target-key']) && isset($_GET['key-value-pairs'])){
        $delimiter = $_GET['delimiter'];
        $targetKey = $_GET['target-key'];
        $keyValues = $_GET['key-value-pairs'];
        $pairs = explode("\n", $keyValues);
        $pairs = array_map('trim', $pairs);
        $array = [];

        for ($index = 0; $index < count($pairs); $index++){
            $pair = $pairs[$index];
            $explodedPair = explode($delimiter, $pair);
            $key = $explodedPair[0];
            $value = $explodedPair[1];
            $array[$key] = $value;
        }

        $wantedKey = $array[$targetKey];
        if($wantedKey == null){
            echo "None";
        }
        else{
            echo $wantedKey;
        }
    }