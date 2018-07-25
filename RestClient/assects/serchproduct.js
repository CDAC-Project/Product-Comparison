$(document).ready(function() {

    $.urlParam = function(name) {
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }
    var id = $.urlParam("product_id"); // name
    //url
    var url = "http://localhost:7070/Shop_ALL/ProductApi/SingleProduct/" + encodeURIComponent(id);

    $.ajax({
        url: url,
        dataType: "json",
        async: false,
        type: "GET",
        success: function(data) {
            console.log(data);
            printData(data);
        },
        error: function(data) {
            console.log(data);
        }
    });

});

function printData(data) {

    $("#product_image").html("");
    txt = '<ul class="slides">';
    txt += '<li data-thumb="images/' + data.imageId + '_front.jpg"><div class="thumb-image"><img src="images/' + data.imageId + '_front.jpg" data-imagezoom="true" class="img-responsive flex-active" alt=""> </div></li>';
    txt += '<li data-thumb="images/' + data.imageId + '_back.jpg"><div class="thumb-image"><img src="images/' + data.imageId + '_back.jpg" data-imagezoom="true" class="img-responsive" alt=""> </div></li>';
    txt += '<li data-thumb="images/' + data.imageId + '_side.jpg"><div class="thumb-image"><img src="images/' + data.imageId + '_side.jpg" data-imagezoom="true" class="img-responsive" alt=""> </div></li>';
    txt += '</ul>';
    $("#product_image").append(txt);


    var name = data.modelNo + " " + data.brand;
    $("#product_name").html(name);

    var lowest = 0;
    var shopname = "";
    $("#productdetail").html("");
    for (var i = 0; i < data.shopProduct.length; i++) {
        list = "";
        list += '<p><i class="fa fa-hand-o-right" aria-hidden="true" /><label>Shop Name: ' + data.shopProduct[i].shop.shopname + "</label></p>";
        list += '<p><i class="fa fa-hand-o-right" aria-hidden="true" /><label>Product Price: Rs. ' + data.shopProduct[i].price + "</label></p>";
        list += '<p><i class="fa fa-hand-o-right" aria-hidden="true" /><label>Product Quantity: ' + data.shopProduct[i].quantity + "</label></p>";
        list += '<p><i class="fa fa-hand-o-right" aria-hidden="true" /><label>Owner Name: ' + data.shopProduct[i].shop.user.name + "</label></p>";
        list += '<p><i class="fa fa-hand-o-right" aria-hidden="true" /><label>Owner Email: ' + data.shopProduct[i].shop.user.email + "</label></p>";
        list += '<hr>';
        $("#productdetail").append(list);
        if (lowest == 0 || lowest > data.shopProduct[i].price) {
            lowest = data.shopProduct[i].price;
            shopname = data.shopProduct[i].shop.shopname;
        }
    }
    low = "Lowest Price <div style='color:red;'>Rs. " + lowest + "</div> In " + shopname;
    $("#lowestprice").html(low);
}