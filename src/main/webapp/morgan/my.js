var express = require('express');
var morgan = require('morgan');
var http = require("http");
var fs = require('fs')
var path = require('path')

var logger = morgan('combined');
var app = express()

http.createServer(function(request, response) {
  response.writeHead(200, {"Content-Type": "text/plain"});
  response.write("Hello World");
  response.end();
  console.log("Hello World");
}).listen(8888);

// create a write stream (in append mode)
var accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), {flags: 'a'})

// setup the logger
app.use(morgan('combined', {stream: accessLogStream}))

app.get('/', function (req, res) {
  res.send('hello, world!')
})