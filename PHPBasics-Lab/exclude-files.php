<?php
    function excludeFromArray(array $arr, array $excludeArr) : array
    {
        $result = [];
        foreach ($arr as $item){
            if (!in_array($item, $excludeArr)){
                $result [] = $item;
            }
        }

        return $result;
    }

    function printAsList(array $arr)
    {
        echo "<ul>\n";
        foreach ($arr as $item){
            echo "<li>$item</li>\n";
        }

        echo "</ul>\n";
    }

    if (isset($_GET['towns']) && isset($_GET['townsToExclude'])) {
        $towns = explode("\n", $_GET['towns']);
        $towns = array_map('trim', $towns);
        $townsToExclude = explode("\n", $_GET['townsToExclude']);
        $townsToExclude = array_map('trim', $townsToExclude);
        $remainingTowns = excludeFromArray($towns, $townsToExclude);
        printAsList($remainingTowns);
    }
    else{?>
        <form>
   <div style="display:inline-block">
       <div>Towns</div>
       <textarea name="towns" rows="10"></textarea>
   </div>
    <div style="display:inline-block">
        <div>Towns to exclude</div>
        <textarea name="townsToExclude" rows="10"></textarea>
    </div>
    <div><input type="submit" value="Exclude"></div>
</form>
    <?php } ?>