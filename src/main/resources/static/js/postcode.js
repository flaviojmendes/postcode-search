angular.module('postcode', [])
    .controller('PostcodeCtrl', function($scope, $location, $http) {

        $scope.submitFormAddressIe = function () {
            var postcode = $scope.postcode;
            var addressUrl = 'http://' + $location.host() + ':' + $location.port() + '/address/ie/' + postcode;

            $http({
              method: 'GET',
              url: addressUrl
            }).then(function successCallback(response) {
                $scope.addresses = response.data;
            }, function errorCallback(response) {
              submitFormAddressIe();
            });
        }

        $scope.submitFormAddressGeo = function () {
            var postcode = $scope.postcode;
            var addressUrl = 'http://' + $location.host() + ':' + $location.port() + '/addressgeo/ie/' + postcode;

            $http({
              method: 'GET',
              url: addressUrl
            }).then(function successCallback(response) {
                $scope.addresses = response.data;
            }, function errorCallback(response) {
              submitFormAddressGeo();
            });
        }

        $scope.submitFormPositionIe = function () {
         var postcode = $scope.postcode;
         var addressUrl = 'http://' + $location.host() + ':' + $location.port() + '/position/ie/' + postcode;

         $http({
           method: 'GET',
           url: addressUrl
         }).then(function successCallback(response) {
             $scope.addresses = response.data;
         }, function errorCallback(response) {
           submitFormPositionIe();
         });
        }
        $scope.submitFormRevGeoIe = function () {
         var latitude = $scope.latitude;
         var longitude = $scope.longitude;
         var addressUrl = 'http://' + $location.host() + ':' + $location.port() + '/rgeo/ie/' + latitude + '/' + longitude + '?distance=50';

         $http({
           method: 'GET',
           url: addressUrl
         }).then(function successCallback(response) {
             $scope.addresses = response.data;
         }, function errorCallback(response) {
           submitFormRevGeoIe();
         });
     }

         $scope.submitFormAddressUk = function () {
             var postcode = $scope.postcode;
             var addressUrl = 'http://' + $location.host() + ':' + $location.port() + '/address/uk/' + postcode;

             $http({
               method: 'GET',
               url: addressUrl
             }).then(function successCallback(response) {
                 $scope.addresses = response.data;
             }, function errorCallback(response) {
               submitFormAddressUk();
             });
         }
    });