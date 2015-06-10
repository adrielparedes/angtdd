var module = angular.module("avianca.user.directives",[]);

module.directive("avUser",['UserService',function(UserService){

  return {
      restrict:'E',
      templateUrl:'user/user.html',
      replace:true,
      link: function(scope,element,attr){

        scope.user = UserService;

      }
  }

}]);



module.service("UserService",[function(){

  this.username = "";

}]);
