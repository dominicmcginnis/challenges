angular.module('numberGuessApp', [])
  .controller('GuessEntryController', function($scope, $http) {
    var numberGuess = this;
    numberGuess.startGame = function() {
    	var url = "/api/guess/start";
   		var responsePromise = $http.get(url);
   		responsePromise.success(function(data, status, headers, config) {
   			$scope.serverResponse = data.resp;
   			var gameId = headers("game-id");
   			$httpProvider.defaults.headers.get = { 'My-ame-id' : gameId };
    	});
    	responsePromise.error(function(data, status, headers, config) {
    		alert("An error occurred.");
    	});

    };
    numberGuess.makeGuess = function(guess) {
    	var url = "/api/guess/" + guess;
   		var responsePromise = $http.get(url);
   		responsePromise.success(function(data, status, headers, config) {
   			$scope.serverResponse = data.resp;
    	});
    	responsePromise.error(function(data, status, headers, config) {
    		alert("An error occurred.");    		
    	});
    };
  });
