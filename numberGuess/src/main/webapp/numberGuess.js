angular.module('numberGuessApp', [])
  .controller('GuessEntryController', function($scope, $rootScope, $http) {
    var numberGuess = this;
    numberGuess.startGame = function() {
    	var url = "/api/guess/start";
   		var responsePromise = $http.get(url);
   		responsePromise.success(function(data, status, headers, config) {
   			$scope.serverResponse = data.resp;
   			var gameId = headers("game-id");
        $rootScope.game_id = gameId;

    	});
    	responsePromise.error(function(data, status, headers, config) {
    		alert("An error occurred.");
    	});

    };
    numberGuess.makeGuess = function() {
    	var url = "/api/guess/" + $scope.youGuess;
      var config = {
        'headers': { 'game-id' : $rootScope.game_id }
      }
   		var responsePromise = $http.get(url, config);
   		responsePromise.success(function(data, status, headers, config) {
   			$scope.serverResponse = data.resp;
    	});
    	responsePromise.error(function(data, status, headers, config) {
    		alert("An error occurred.");    		
    	});
    };
  });
