var app = angular.module('meal', ["ngRoute"]);

app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
      templateUrl : "views/register.htm",
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
});
