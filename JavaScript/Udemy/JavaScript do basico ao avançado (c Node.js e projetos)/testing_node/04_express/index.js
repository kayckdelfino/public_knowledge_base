let express = require('express');
let app = express();

app.get('/', function(req, res) {
  res.send('First route with Express');
});

app.get('/test', function(req, res) {
  res.send('Testing route');
});

app.listen(3000, function() {
  console.log("The application is running on port 3000");
});