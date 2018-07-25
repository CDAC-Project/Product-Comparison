$(document).ready(function() {
    //alert("ewr");
    var check = function() {
        if (document.getElementById("pass").value == document.getElementById("cpass").value) {
            alert("Password and Confirm Password must be same");
            return false;
        }
    };
});