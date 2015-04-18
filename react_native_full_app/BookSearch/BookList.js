/**
 * Created by echessa on 4/18/15.
 */

'use strict';

var REQUEST_URL = 'https://www.googleapis.com/books/v1/volumes?q=subject:fiction';

var React = require('react-native');
var {
    AppRegistry,
    Image,
    StyleSheet,
    Text,
    View,
    Component,
    ListView,
    TouchableHighlight,
    ActivityIndicatorIOS
    } = React;

var styles = StyleSheet.create({
    cellContainer: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
        padding: 10
    },
    thumbnail: {
        width: 53,
        height: 81,
        marginRight: 10
    },
    rightContainer: {
        flex: 1
    },
    title: {
        fontSize: 20,
        marginBottom: 8
    },
    author: {
        color: '#656565'
    },
    separator: {
        height: 1,
        backgroundColor: '#dddddd'
    },
    listView: {
        backgroundColor: '#F5FCFF'
    },
    loading: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    }
});

class BookList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: false,
            dataSource: new ListView.DataSource({
                rowHasChanged: (row1, row2) => row1 !== row2
            })
        };
    }

    componentDidMount() {
        this.fetchData();
    }

    fetchData() {

        fetch(REQUEST_URL)
        .then((response) => response.json())
        .then((responseData) => {
            this.setState({
                dataSource: this.state.dataSource.cloneWithRows(responseData.items),
                isLoading: true,
            });
        })
        .done();
    }

    render() {
        if (!this.state.isLoading) {
            return this.renderLoadingView();
        }

    return (
        <ListView
            dataSource={this.state.dataSource}
            renderRow={this.renderBook}
            style={styles.listView}
        />
       );
    }

    renderBook(book) {
        return (
            <TouchableHighlight underlayColor='#dddddd'>
                <View>
                    <View style={styles.cellContainer}>
                        <Image
                            source={{uri: book.volumeInfo.imageLinks.thumbnail}}
                        style={styles.thumbnail} />
                        <View style={styles.rightContainer}>
                            <Text style={styles.title}>{book.volumeInfo.title}</Text>
                            <Text style={styles.author}>{book.volumeInfo.authors}</Text>
                        </View>
                    </View>
                    <View style={styles.separator} />
                </View>
            </TouchableHighlight>
        );
    }

    renderLoadingView() {
        return (
            <View style={styles.loading}>
                <ActivityIndicatorIOS
                    size='large'/>
                <Text>
                    Loading books...
                </Text>
            </View>
        );
    }

}

module.exports = BookList;