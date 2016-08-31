(function() {
    'use strict';

    var eventsApp = angular.module("eventsApp");

    var durations = function() {
        return function(duration) {
            switch (duration) {
                case 1:
                    return "Half Hour";
                case 2:
                    return "1 Hour";
                case 3:
                    return "Half Day";
                case 4:
                    return "Full Day";
            }
        };
    };

    eventsApp.filter('durations', durations);

}());
