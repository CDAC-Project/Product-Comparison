var user = require('../dao/userDao');

exports.loginget = function(req, res) {
    res.render('index');
}

exports.registerget = function(req, res) {
    res.render("registeruser");
};

exports.registerpost = function(req, res) {
    user.insert(req, res);
};

exports.loginpost = function(req, res) {
    user.validate(req, res);
};

exports.detail = function(req, res) {
    res.render("detail");
};

exports.about = function(req, res) {
    res.render("about");
};

exports.contact = function(req, res) {
    res.render("contact");
};

exports.seachproduct = function(req, res) {
    res.render("searchproduct");
};

exports.seachproductpost = function(req, res) {
    res.render("searchproduct");
};