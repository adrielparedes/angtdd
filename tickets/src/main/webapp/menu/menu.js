var module = angular.module("avianca.menu.directives",[]);

module.directive("avMenu",[function(){

  return {
      restrict:'E',
      templateUrl:'menu/menu.html',
      transclude:true,
      replace:true,
      link: function(scope,element,attr){
      }
  }


}]);


module.directive("avMenuItem",['$location',function($location){
  return {
      restrict:'E',
      templateUrl:'menu/menu-item.html',
      transclude:true,
      replace:true,
      scope:{
        'url':'@url'
      },
      link: function(scope,element,attr){

      scope.isActive = function(){
        return $location.url() == scope.url;
      }

      }

  }
}]);
