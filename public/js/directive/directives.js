angular.module('meal')

.directive('allergenImages', function() {
  return {
    template:
      '<img src="res/icons/milk-icon.png" class="table-image peanut-icon" ng-show="grocery.allergens.includes(&quot;Melk&quot;)"/>'
    + '<img src="res/icons/gluten-icon.png" class="table-image peanut-icon" ng-show="grocery.allergens.includes(&quot;Gluten&quot;)"/>'
    + '<img src="res/icons/wheat-icon.png" class="table-image peanut-icon" ng-show="grocery.allergens.includes(&quot;Hvete&quot;)"/>'
    + '<img src="res/icons/soya-icon.png" class="table-image peanut-icon" ng-show="grocery.allergens.includes(&quot;Soya&quot;)"/>'
    + '<img src="res/icons/peanuts-icon.png" class="table-image peanut-icon" ng-show="grocery.allergens.includes(&quot;Nøtter&quot;)"/>'
  };
})

.directive('allergens', ['$http', function($http) {

  $http({
    method: 'GET',
    url: '/code/allergens'
  }).then(function successCallback(response) {
      console.log('Find allergens success');
      console.log(response.data);
    }, function errorCallback(response) {
      console.log('Find allergens error');
    });

  return {
    scope: {
      bror: '=Hei'
    },
    template: "<div>'HEI du'</div>"
      };
}]);
