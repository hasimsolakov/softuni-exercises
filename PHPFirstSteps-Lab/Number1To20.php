<?php
echo '<ul>';
for($i = 1; $i <= 20; $i++){
    $color;
    if($i % 2 == 0){
        $color = "green";
    }else{
        $color = "blue";
    }

    echo "<li><span style='color:$color'>$i</span></li>";
}

echo '<ul>';
