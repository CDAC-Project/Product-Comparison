exports.validate = function(req, res) {
    req.getConnection(function(err, connection) {
        var sql = "SELECT * FROM user where email = '" + req.body.email + "' and password = '" + req.body.pass + "'";
        var query = connection.query(sql, function(err, rows) {
            if (err || rows[0] == null) {
                res.render("index", { msg: "Login Fail" });
            } else {

                res.redirect("/searchproduct");
            }
        });
    });
}

exports.insert = function(req, res) {
    req.getConnection(function(err, connection) {
        var sql = "INSERT INTO user value(default,'" + req.body.email + "','" + req.body.name + "','" + req.body.pass + "','" + req.body.gender + "','" + req.body.contact + "');";
        var query = connection.query(sql, function(err, rows) {
            if (err) {
                //throw err;
                //alert("Registration fail..");
                res.render("registeruser", { msg: "Registration Fail" });
                //res.redirect("/register");
            } else {
                console.log("Data inserted " + rows.id);
                res.render("registeruser", { msg: "Registration Successful" });
            }
        });
    });
};

exports.delete = function(req, res) {
    req.getConnection(function(err, connection) {
        var sql =
            "delete from login where email = '" + req.body.email + "' and pass = '" + req.body.pass + "';";
        var query = connection.query(sql, function(err, rows) {
            if (err) throw err;
            console.log("Data inserted " + rows.id);
            res.render("delete", { msg: "Data Delete" });
        });
    });
};