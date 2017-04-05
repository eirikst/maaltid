var app = angular.module('meal');
app.controller('groceryCtrl', ['$scope', '$interval', 'service', function($scope, $interval, service) {
  var thiss = this;
  $scope.groceries = [];
  $scope.grocery = new Grocery(undefined, "", []);
  $scope.product = new Product(undefined, "", []);
  $scope.errorMsg = "";
  $scope.showError = false;
  $scope.successMsg = "";
  $scope.showSuccess = false;
  $scope.tempAllergen = "Melk";

  findGroceries();

  /*
   * Functions
  */

  //local add grocery with units to meal
  $scope.register = function(grocery) {
    console.log(grocery);
  }


  //register grocery to service
  $scope.register = function() {
    if($scope.grocery.name.length == 0) {
      showError("Ingen data å registrere");
      return;
    }

    for(var i = 0; i < $scope.groceries.length; i++) {
      if($scope.groceries[i].name.toUpperCase() == $scope.grocery.name.
      toUpperCase()) {
        showError("Matvaren er allerede registrert");
        return;
      }
    }

    registerSuccess = function() {
      $scope.grocery = new Grocery();
      findGroceries();
      showSuccess("Matvare er lagt til!");
    }
    registerFailure = function() {
      thiss.showError("Kunne ikke registrere. Prøv igjen");
    }

    service.registerGrocery($scope.grocery, registerSuccess, registerFailure);
  }

  //get groceries from service
  function findGroceries() {
    service.findGroceries(function(groceries) {
      $scope.groceries = groceries;
    });
  };

  //local add allergen
  $scope.addAllergen = function() {
    if(!$scope.grocery.allergens.includes($scope.tempAllergen)) {
      $scope.grocery.allergens.push($scope.tempAllergen);
    }
  }

  //local remove allergen
  $scope.removeAllergen = function(allergen) {
    $scope.grocery.removeAllergen(allergen);
  }

  //register product to service
  $scope.registerProduct = function() {
    if($scope.product.name.length == 0) {
      showError("Navn på produkt mangler");
      return;
    }

    if($scope.product.groceries.length == 0) {
      showError("Ingen matvarer er registrert");
      return;
    }


    registerSuccess = function() {
      $scope.product = new Product();

      showSuccess("Produkt er lagt til!");
    }
    registerFailure = function() {
      thiss.showError("Kunne ikke registrere. Prøv igjen");
    }

    service.registerProduct($scope.product, registerSuccess, registerFailure);
  }

  //local add grocery to product
  $scope.addGrocery = function(grocery) {
    if(!$scope.product.groceries.includes(grocery)) {
      $scope.product.groceries.push(grocery);
    }
  }

  //local remove grocery from product
  $scope.removeGrocery = function(grocery) {
    $scope.product.removeGrocery(grocery);
  }

  function showError(msg) {
    $scope.errorMsg = msg;
    $scope.showError = true;

    $interval(function() {
      $scope.showError = false;
    }, 5000);
  }

  function showSuccess(msg) {
    $scope.successMsg = msg;
    $scope.showSuccess = true;

    $interval(function() {
      $scope.showSuccess = false;
    }, 5000);
  }


}]);
