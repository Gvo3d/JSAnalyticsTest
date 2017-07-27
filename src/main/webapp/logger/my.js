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
}).listen(8888);

app.use(morgan('combined'))

app.get('/', function (req, res) {
  res.send('hello, world!')
})