/**
 * Created by echessa on 4/17/15.
 */

'use strict';

var React = require('react-native');
var BookList = require('./BookList');

var styles = React.StyleSheet.create({
    container: {
        flex: 1
    }
});

class Featured extends React.Component {
    render() {
    return (
        <React.NavigatorIOS
        style={styles.container}
        initialRoute={{
            title: 'Featured Books',
            component: BookList,
        }}/>
        );
}
}

module.exports = Featured;