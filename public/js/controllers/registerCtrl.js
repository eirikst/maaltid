var app = angular.module('meal');
app.controller('regCtrl', ['$scope', '$interval', 'service', function($scope, $interval, service) {
  var thiss = this;
  $scope.registerDate = new Date();
  $scope.products = [];
  $scope.meal = new Meal();
  $scope.errorMsg = "";
  $scope.showError = false;

  findProducts();

  /*
   * Functions
  */

  //local add product with units to meal
  $scope.add = function(product) {
    $scope.meal.addProductUnit(
      new ProductUnit(product, product.unit, product.quantity));
  }

  //local remove product from meal
  $scope.remove = function(product) {
    $scope.meal.removeProductUnit(product);
  }

  //register product to service
  $scope.register = function() {
    if($scope.meal.productUnits.length == 0) {
      showError("Ingen data å registrere");
      return;
    }

    registerSuccess = function() {
      $scope.meals.length = 0;
      thiss.showError("Kunne ikke registrere. Prøv igjen");
    }
    registerFailure = function() {
      thiss.showError("Kunne ikke registrere. Prøv igjen");
    }

    service.registerMeal($scope.meal, registerSuccess, registerFailure);
    $scope.meal = new Meal();
  }

  //get products from service
  function findProducts() {
    service.findProducts(function(products) {
      $scope.products = products;
    });
  };

  function showError(msg) {
    $scope.errorMsg = msg;
    $scope.showError = true;

    $interval(function() {
      $scope.showError = false;
    }, 5000);
  }

}]);
