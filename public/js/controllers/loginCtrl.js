var app = angular.module('meal');
app.controller('loginCtrl', ['$scope', '$http', function($scope, $http, $location) {
  var thiss = this;
console.log("loginctrl klar");

  $scope.login = function() {
    console.log($scope.username + " logger inn.");
    var req = {
      method: 'POST',
      url: '/user',
      headers: {
       'Content-Type': 'application/json'
      },
      data: { id: 0, username: $scope.username}
    };

    $http(req).then(function successCallback(response) {
      console.log('Login success');
      redirOnSuccess();
    }, function errorCallback(response) {
      console.log('Login error');
    });
  }

  redirOnSuccess = function() {
    $location.path("/register");
    console.log("kk");
}
}]);
