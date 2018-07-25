$(document).ready(function() {

    $("#searchproduct").on("click", function() {
        //alert("adsf");
        var product = $("#productserchbar").val();
        var url = "http://localhost:7070/Shop_ALL/ProductApi/ListOfProducts/" + encodeURIComponent(product);
        //sharecore(shareurl);

        $.ajax({
            url: url,
            dataType: "json",
            type: "GET",
            success: function(data) {
                console.log(data);
                printData(data);
                //console.log("Hello World!");
            },
            error: function(data) {
                console.log(data);
            }
        });
    });
});

function printData(data) {
    window.location = "#navigateHere";
    var x = 0;
    var txt = "";
    $(".product-sec1").html(txt);
    for (x = 0; x < data.length; x++) {
        txt = "";
        txt += '<div class="col-md-4 product-men"><div class="men-pro-item simpleCart_shelfItem"><div class="men-thumb-item">';
        txt += '<img src="images/' + data[x].imageId + '_front.jpg" alt="">';
        txt += '<div class="men-cart-pro"><div class="inner-men-cart-pro">';
        txt += '<a href="/productdetail?product_id=' + data[x].product_id + '" class="link-product-add-cart">Quick View</a>';
        txt += '</div></div></div><div class="item-info-product "> <h4>';
        txt += '<a href="/productdetail?product_id=' + data[x].product_id + '">"' + data[x].modelNo + '"</a>';
        txt += '</h4><div class="info-product-price">';
        txt += '<span class="item_price">"' + data[x].brand + '"</span>';
        txt += "</div></div></div></div>";
        $(".product-sec1").append(txt);
    }
}