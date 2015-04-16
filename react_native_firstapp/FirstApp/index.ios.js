/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';

var React = require('react-native');
var BookList = require('./BookList');

var styles = React.StyleSheet.create({
    container: {
        flex: 1
    }
});

class FirstApp extends React.Component {
    render() {
        return (
            <React.NavigatorIOS
                style={styles.container}
                initialRoute={{
                    title: 'BookSearch',
                    component: BookList
                }}/>
        );
    }
}

AppRegistry.registerComponent('FirstApp', () => FirstApp);
