var port = 3000;
var urlToSend = "http://192.168.1.137:8088/services/collector/event";
var token = 'Splunk 97F766E2-AC06-44A8-8263-93E31E17B71F';
var express = require('express');
var app = express();
var morgan = require('morgan');
var cookieParser = require('cookie-parser');
var session = require('express-session');
var bodyParser = require('body-parser');
var http = require('http');
var fs = require("fs");
var request = require('request');

temp.on('data', function() {
  console.log('onend');
});

var logger = morgan('combined', {stream: process.stdout, func: function(param){
// Set the headers
var headers = {
    'Authorization':       token,
    'Content-Type':     'application/json'
}
var data = {"event":param}

request({
        url: urlToSend,
        json: true,
        method: 'POST',
        headers: headers,
        multipart: {
            chunked: false,
            data: [
                {
                    'Authorization':       token,
                    'content-type': 'application/json',
                    body: requestData
                }
            ]
        }
    }, function (error, response, body) {
        if (!error && response.statusCode === 200) {
            console.log(body)
        }
        else {
            console.log("error: " + error)
            console.log("response.statusCode: " + response.statusCode)
            console.log("response.statusText: " + response.statusText)
        }
    })
}});

app.use(cookieParser());
app.use(logger);

app.get('/', function (req, res, next) {
  res.send('Hello World!<a href="/test">PZDC</a>');
  next()
});

app.listen(port);
console.log('Server running on port: ' + port);




