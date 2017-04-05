var app = angular.module("meal");

app.service("service", function($http) {
  var thiss = this;
  var products = [];
  var groceries = [];

  //products
  this.findProducts = function(suc, err) {
    if(products.length != 0) {
      console.log("Products loaded from service");
      suc(products);
      return;
    }

    $http({
      method: 'GET',
      url: '/product'
    }).then(function successCallback(response) {
        console.log('Find products success');
        products = thiss.createProducts(response.data);
        suc(products);
      }, function errorCallback(response) {
        err();
        console.log('Find products error');
      });
  }

  //register product
  this.registerProduct = function(product, suc, err) {
    var req = {
      method: 'POST',
      url: '/product',
      headers: {
       'Content-Type': 'application/json'
      },
      data: { name: product.name, groceries: product.groceries }
    };

    $http(req).then(function successCallback(response) {
      console.log('Register product success');
      suc();
    }, function errorCallback(response) {
      console.log('Register product error');
      err();
    });
  }

  //groceries
  this.findGroceries = function(suc, err) {
    if(groceries.length != 0) {
      console.log("Groceries loaded from service");
      suc(groceries);
      return;
    }

    $http({
      method: 'GET',
      url: '/grocery'
    }).then(function successCallback(response) {
        console.log('Find groceries success');
        groceries = thiss.createGroceries(response.data);
        suc(groceries);
      }, function errorCallback(response) {
        err();
        console.log('Find groceries error');
      });
  }

  this.registerGrocery = function(grocery, suc, err) {
    var req = {
      method: 'POST',
      url: '/grocery',
      headers: {
       'Content-Type': 'application/json'
      },
      data: { name: grocery.name, allergens: grocery.allergens }
    };

    $http(req).then(function successCallback(response) {
      console.log('Register grocery success');
      groceries.length = 0;
      suc();
    }, function errorCallback(response) {
      console.log('Register grocery error');
      err();
    });
  }

  //meals
  this.registerMeal = function(meal, suc, err) {
    var req = {
      method: 'POST',
      url: '/meal',
      headers: {
       'Content-Type': 'application/json'
      },
      data: { id: meal.id, time: meal.time, productUnits: meal.productUnits }
    };

    $http(req).then(function successCallback(response) {
      console.log('Register meal success');
      //TODO:kall suc suc();
    }, function errorCallback(response) {
      console.log('Register meal error');
      err();
    });
  }



  //private helper to create objects of right classes from the objects
  this.createProducts = function(objs) {
    var products = [];
    for(var i = 0; i < objs.length; i++) {
      var product = new Product();
      product.setPropsFromObject(objs[i]);
      products.push(product);
    }
    return products;
  }

  this.createGroceries = function(objs) {
    var groceries = [];
    for(var i = 0; i < objs.length; i++) {
      var grocery = new Grocery();
      grocery.setPropsFromObject(objs[i]);
      groceries.push(grocery);
    }
    return groceries;
  }


  //test functions
  this.findProductsTest = function(groceries) {
    var products = [];
    products.push(new Product(1, "Egg", groceries[0]));
    products.push(new Product(2, "TINE Lettmelk", groceries[1]));
    products.push(new Product(3, "MENY Speltbrød", groceries[2]));

    return products;
  }
});
