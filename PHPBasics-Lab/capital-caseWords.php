<form>
    <div>Input</div>
    <textarea name="text" rows="4"></textarea>
    <input type="submit" value="Extract">
</form>
<?php
    if (isset($_GET['text'])){
        $text = $_GET['text'];
        preg_match_all('/\w+/', $text, $words);
        $words = $words[0];
        $upperWords = array_filter($words, function ($word){
            return strtoupper($word) == $word;
        });
        echo implode(', ', $upperWords);
    }
?>

