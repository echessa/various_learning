var express = require('express');
var path = require('path');
var fs = require('fs');
var morgan = require('morgan');

var app = express();

app.use(morgan('short'));

var staticPath = path.join(__dirname, 'static');
app.use(express.static(staticPath));

app.use(function(req, res) {
    res.status(404);
    res.send('File not found!');
});

app.listen(3000, function() {
    console.log('App started on port 3000');
});
