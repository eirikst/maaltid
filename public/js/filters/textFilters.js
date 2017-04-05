var app = angular.module('meal');

//Forventer at objekter i input har metoden searchable(), som returnerer det som skal søkes i
app.filter('textIncludesFilter', function() {
  return function(input, text) {
    var output = [];
    var searchWords = text.split(" ");

    for(var i = 0; i < input.length; i++) {
      var searchableString = input[i].name.concat(" " + input[i].searchable()).replace(",", "").toUpperCase();

      if(includesAll(searchableString, searchWords)) {
        output.push(input[i]);
      }
    }

    return output;
  }

  //does text include all substrings in words?
  function includesAll(text, words) {
    for(var a = 0; a < words.length; a++) {
      if(!text.includes(words[a].toUpperCase())) {
        return false;
      }
    }
    return true;
  }

});
