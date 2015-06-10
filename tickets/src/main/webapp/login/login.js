var module = angular.module("avianca.login.directives",[]);

module.directive("avLogin",['UserService',function(UserService){

  return {
      restrict:'E',
      templateUrl:'login/login.html',
      replace:true,
      link: function(scope,element,attr){

        scope.saveUser = function(){
          console.log("guardando usuario " + scope.username);
          UserService.username = scope.username;

        }

      }
  }

}]);
