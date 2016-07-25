angular
    .module("ngClassifieds", ["ngMaterial"])
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme("default")
            .primaryPalette("teal")
            .accentPalette("orange");
    });
