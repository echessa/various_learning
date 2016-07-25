(function() {
    "use strict";

    angular
    .module("ngClassifieds")
    .controller("classifiedsCtrl", function($scope, $http, classifiedsFactory, $mdSidenav, $mdToast) {
        classifiedsFactory.getClassifieds()
            .then(function(classifieds) {
                $scope.classifieds = classifieds.data;
            });

        var fakeContact = {
            name: "Joyce Echessa",
            phone: "(555) 555-5555",
            email: "joyce@example.com"
        };

        $scope.openSidebar = function() {
            $mdSidenav("left").open();
        };

        $scope.closeSidebar = function() {
            $mdSidenav("left").close();
        };

        $scope.saveClassified = function(classified) {
            if (classified) {
                classified.contact = fakeContact;
                $scope.classifieds.push(classified);
                $scope.classified = {};
                $scope.closeSidebar();
                showToast("Classified Saved!");
            }
        };

        $scope.editClassified = function(classified) {
            $scope.editing = true;
            $scope.openSidebar();
            $scope.classified = classified;
        };

        $scope.saveEdit = function() {
            $scope.editing = false;
            $scope.classified = {};
            $scope.closeSidebar();
            showToast("Edit Saved!");
        };

        function showToast(message) {
            $mdToast.show(
                $mdToast.simple()
                    .content(message)
                    .position("top, right")
                    .hideDelay(3000)
            );
        }
    });
})();
