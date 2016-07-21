<?php
    $msgAfterCelsius = "";
    if (isset($_GET['cel'])){
        $celsius = floatval($_GET['cel']);
        $fahrenheit = celsiusToFahrenheit($celsius);
        $msgAfterCelsius = "$celsius &deg;C = $fahrenheit &deg;F";
    }

    $msgAfterFahrenheit = "";
    if (isset($_GET['fah'])){
        $fahrenheit = floatval($_GET['fah']);
        $celsius = fahrenheitToCelsius($fahrenheit);
        $msgAfterFahrenheit = "$fahrenheit &deg;F = $celsius &deg;C";
    }

    function celsiusToFahrenheit(float $cel) : float
    {
        return $cel * 1.8 + 32;
    }

    function fahrenheitToCelsius(float $fah) : float
    {
        return ($fah - 32) / 1.8;
    }
?>

<form>
    Celsius: <input type="text" name="cel"/>
    <input type="submit" value="Convert"/>
    <?= $msgAfterCelsius ?>
</form>

<form>
    Fahrenheit: <input type="text" name="fah"/>
    <input type="submit" value="Convert"/>
    <?= $msgAfterFahrenheit ?>
</form>

