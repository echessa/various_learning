/**
 * Created by echessa on 4/17/15.
 */

'use strict';

var React = require('react-native');
var SearchBooks = require('./SearchBooks');

var styles = React.StyleSheet.create({
    container: {
        flex: 1
    }
});

class Search extends React.Component {
    render() {
    return (
        <React.NavigatorIOS
        style={styles.container}
        initialRoute={{
            title: 'Search Books',
            component: SearchBooks,
        }}/>
        );
}
}

module.exports = Search;