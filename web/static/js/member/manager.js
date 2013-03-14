function showCustomer() {
    $("#cus-card-menu").addClass("active");
    $("#cus-order-menu").removeClass("active");
    $("#cus-dessert-menu").removeClass("active");

    $(".hero-customer").show();
    $(".hero-order").hide();
    $(".hero-dessert-num").hide();
}

function showOrder() {
    $("#cus-card-menu").removeClass("active");
    $("#cus-order-menu").addClass("active");
    $("#cus-dessert-menu").removeClass("active");

    $(".hero-customer").hide();
    $(".hero-order").show();
    $(".hero-dessert-num").hide();
}

function showDessert() {
    $("#cus-card-menu").removeClass("active");
    $("#cus-order-menu").removeClass("active");
    $("#cus-dessert-menu").addClass("active");

    $(".hero-customer").hide();
    $(".hero-order").hide();
    $(".hero-dessert-num").show();
}

$(function () {
    $("#cus-card-menu").on("click", function () {
        showCustomer();
    })
    $("#cus-order-menu").on("click", function () {
        showOrder();
    })
    $("#cus-dessert-menu").on("click", function () {
        showDessert();
    })

    showCustomer();
})