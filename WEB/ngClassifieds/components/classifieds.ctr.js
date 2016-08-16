(function() {
    "use strict";

    angular
    .module("ngClassifieds")
    .controller("classifiedsCtrl", function($scope, $http, classifiedsFactory, $mdSidenav, $mdToast, $mdDialog) {
        classifiedsFactory.getClassifieds()
            .then(function(classifieds) {
                $scope.classifieds = classifieds.data;
                $scope.categories = getCategories($scope.classifieds);
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

        $scope.deleteClassified = function(event, classified) {
            var confirm = $mdDialog.confirm()
                .title("Are you sure you want to delete " + classified.title + "?")
                .ok("Yes")
                .cancel("No")
                .targetEvent(event);

            $mdDialog.show(confirm).then(function() {
                var index = $scope.classifieds.indexOf(classified);
                $scope.classifieds.splice(index, 1);
            }, function() {

            });
        };

        function showToast(message) {
            $mdToast.show(
                $mdToast.simple()
                    .content(message)
                    .position("top, right")
                    .hideDelay(3000)
            );
        }

        function getCategories(classifieds) {
            var categories = [];

            angular.forEach(classifieds, function(item) {
                angular.forEach(item.categories, function(category) {
                    categories.push(category);
                });
            });

            return _.uniq(categories);
        }
    });
})();
