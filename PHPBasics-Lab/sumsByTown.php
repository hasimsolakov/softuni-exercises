<?php
if (isset($_GET['towns-incomes'])){
    $townsIncomes = explode("\n", $_GET['towns-incomes']);
    $townsIncomes = array_map('trim', $townsIncomes);
    $sumsByTown = calcSumsByTown($townsIncomes);
    foreach ($sumsByTown as $town => $sum){
        echo $town . "->" . $sum . "<br>\n";
    }
}

function calcSumsByTown(array  $townsIncomes) : array
{
    $sums = [];
    foreach ($townsIncomes as $townsIncome) {
        $tokens = explode(':', $townsIncome);
        $town = $tokens[0];
        $income = $tokens[1];
        if (isset($sums[$town])){
            $sums[$town] += $income;
        }
        else{
            $sums[$town] = $income;
        }
    }

    ksort($sums);
    return $sums;
}
?>
<form>
    <textarea name="towns-incomes" rows="10"></textarea><br>
    <input type="submit" value="Calculate">
</form>
