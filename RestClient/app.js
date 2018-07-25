var express = require('express')
var app = express()
var mysql = require('mysql')
var connection = require('express-myconnection')
var urlController = require('./Controller/urlController')

var bodyParser = require("body-parser");
var urlencodedParser = bodyParser.urlencoded({ extended: false });

app.set('view engine', 'ejs')
app.use(express.static('./assects'));

app.use(
    connection(
        mysql, {
            host: 'localhost',
            user: 'root',
            password: 'admin',
            database: 'restclient'
        },
        "pool"
    )
);

app.get('/', urlController.loginget);
app.post("/", urlencodedParser, urlController.loginpost);
app.get("/searchproduct", urlController.seachproduct);
app.post("/searchproduct", urlController.seachproductpost);


app.get("/register", urlController.registerget);
app.post("/register", urlencodedParser, urlController.registerpost);

app.get("/about", urlController.about);
app.get("/contact", urlController.contact);
app.get("/productdetail", urlController.detail);

//app.post("/delete", urlencodedParser, urlController.delete);

app.listen(8080)
console.log("listen to port 8080");