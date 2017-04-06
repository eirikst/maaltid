var app = angular.module('meal', ["ngRoute"]);

app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider, $location) {
  $routeProvider
  .when("/", {
      templateUrl : "views/register.htm",
  })
  .when("/login", {
      templateUrl : "views/login.htm",
  })
  .when("/register", {
      templateUrl : "views/register.htm",
  })
  .when("/meals", {
      templateUrl : "views/meals.htm",
  })
  .when("/groceries", {
      templateUrl : "views/groceries.htm",
  });

  $httpProvider.interceptors.push(function($q, $location) {

    return {

      'responseError': function(rejection){

        var defer = $q.defer();

        if(rejection.status == 401){
          console.log("401, redirecter til login");
          $location.path('/login');
        }

        defer.reject(rejection);

        return defer.promise;

      }
    };
  });

}]);
