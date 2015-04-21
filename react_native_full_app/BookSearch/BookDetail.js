/**
 * Created by echessa on 4/18/15.
 */

'use strict';

var React = require('react-native');

var {
    StyleSheet,
    Text,
    View,
    Component,
    Image
    } = React;

var styles = StyleSheet.create({
    container: {
        marginTop: 75,
        alignItems: 'center'
    },
    image: {
        width: 107,
        height: 165,
        padding: 10
    },
    description: {
        padding: 10
    }
});

class BookDetail extends Component {
    render() {
    var book = this.props.book;
    return (
        <View style={styles.container}>
            <Image style={styles.image} source={{uri: book.volumeInfo.imageLinks.thumbnail}} />
            <Text style={styles.description}>{book.volumeInfo.description}</Text>
        </View>
        );
    }
}

module.exports = BookDetail;