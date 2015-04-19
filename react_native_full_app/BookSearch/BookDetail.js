/**
 * Created by echessa on 4/18/15.
 */

'use strict';

var React = require('react-native');

var styles = React.StyleSheet.create({
    container: {
        flex: 1
    }
});

class BookDetail extends React.Component {
    render() {
    return (
        <View style={styles.container}>
            <Text style={styles.description}>
            Book Detail
            </Text>
        </View>
        );
    }
}

module.exports = BookDetail;