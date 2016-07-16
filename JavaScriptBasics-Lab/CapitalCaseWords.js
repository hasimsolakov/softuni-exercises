function extractCapitalCaseWords(input) {
    "use strict";
    let text = input.join(",");
    let words = text.split(/\W+/);
    let nonEmptyWords = words.filter(w => w.length > 0);
    let upWords = nonEmptyWords.filter(isUppercase);
    console.log(upWords.join(", "));
    function isUppercase(string) {
        return string == string.toUpperCase();
    }
}

extractCapitalCaseWords(['PHP, Java and HTML'])
