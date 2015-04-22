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
        padding: 10,
        color: '#656565',
        fontSize: 15
    }
});

class BookDetail extends Component {
    render() {
    var book = this.props.book;
    var imageURI = (typeof book.volumeInfo.imageLinks !== 'undefined') ? book.volumeInfo.imageLinks.thumbnail : '';
    var description = (typeof book.volumeInfo.description !== 'undefined') ? book.volumeInfo.description : '';
    return (
        <View style={styles.container}>
            <Image style={styles.image} source={{uri: imageURI}} />
            <Text style={styles.description}>{description}</Text>
        </View>
        );
    }
}

module.exports = BookDetail;