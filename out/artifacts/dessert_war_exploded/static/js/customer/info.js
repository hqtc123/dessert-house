function isInteger(str) {
    var regu = /^[-]{0,1}[0-9]{1,}$/;
    return regu.test(str);
}

function showShop1() {
    $("#table-shop2").hide();
    $("#table-shop1").show();
    $("#shop-menu2").removeClass("active");
    $("#shop-menu1").addClass("active")
}
function showShop2() {
    $("#table-shop1").hide();
    $("#table-shop2").show();
    $("#shop-menu1").removeClass("active");
    $("#shop-menu2").addClass("active")
}
$(function () {
//    充值
    $(document).on("click", ".cha-money", function () {
        $("#myModal").modal("show");
    })
    $(document).on("click", ".btn-re-primary", function () {
        var money = $("#modal-input").val();
        if (money == "") {
            alert("请输入数额");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "recharge.action",
            data: {
                "rechargeMoney": money
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "充值成功") {
                    $("#myModal").modal("hide");
                    window.location.href = "getInfoAction.action";
                }
            }
        })
    })

    //add order item
    var dessertid , dessertnum, avainum, weeknumid, tr, shopid = 1;

    //choose shop
    showShop1();
    $("#shop-menu1").on("click", function () {
        showShop1();
        shopid = 1;
    })
    $("#shop-menu2").on("click", function () {
        shopid = 2;
        showShop2();
    })

    $(".hide-id").hide();
    $(".buy-btn").on("click", function () {
        $("#my-main-Modal").modal("show");
        tr = $(this).parents("tr");
        dessertid = tr.children("td:eq(1)").html();
        avainum = tr.children("td:eq(4)").html();
        weeknumid = tr.children().children(".hide-id").html();
    })

    $(document).on("click", ".btn-main-primary", function () {
        dessertnum = $("#modal-input").val();

        if (dessertnum == "") {
            alert("请输入数额");
            return false;
        }
        if (!isInteger(dessertnum)) {
            alert("请输入整数");
            return false;
        }
        if (parseInt(dessertnum) > parseInt(avainum)) {
            alert("剩余不足");
            return false;
        }
        var newnum = avainum - dessertnum;
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "addItem.action",
            data: {
                "shopid": shopid,
                "weeknum.id": weeknumid,
                "weeknum.num": newnum,
                "orderitem.dessertid": dessertid,
                "orderitem.num": dessertnum
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "已经加入购物车") {
                    $("#my-main-Modal").modal("hide");
                }
                tr.children("td:eq(4)").html(newnum);
            }
        })
    })

    //pay for cart

    $(".pay-btn").on("click", function () {
        var sumMoney = $("#sum-label").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "payAction.action",
            data: {
                "torder.money": sumMoney,
                "moneySum": sumMoney
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "付款成功") {
                    window.location.href = "customerIndex.action";
                }
            }
        })
    })

    $(".pay-cancel-btn").on("click", function () {

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "cancelPay.action",
            data: {
            },
            success: function (data) {
                alert(data.resultMsg);
                window.location.href = "customerIndex.action";
            }
        })
    })


    // change info of customer
    var newAddr, newAge;
    $(".btn-cha-age").on("click", function () {
        newAddr = $(this).parents("table").find("#addr-td").html();
        $("#my-cha-age-Modal").modal("show");
    })

    $(".btn-cha-addr").on("click", function () {
        newAge = $(this).parents("table").find("#age-td").html();
        $("#my-cha-addr-Modal").modal("show");
    })

    $(document).on("click", ".btn-cha-age-primary", function () {
        newAge = $("#modal-cha-age-input").val();
        if (newAge == "") {
            alert("请输入数额");
            return false;
        }
        if (!isInteger(newAge)) {
            alert("请输入整数");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "changeInfo.action",
            data: {
                "customer.age": newAge,
                "customer.address": newAddr
            },
            success: function (data) {
                alert(data.resultMsg);
                $("#my-cha-age-Modal").modal("hide");
                $(".info-table").find("#age-td").html(newAge)
            }
        })
    })
    $(document).on("click", ".btn-cha-addr-primary", function () {
        newAddr = $("#modal-cha-addr-input").val();
        if (newAddr == "") {
            alert("请输入新地址");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "changeInfo.action",
            data: {
                "customer.age": newAge,
                "customer.address": newAddr
            },
            success: function (data) {
                alert(data.resultMsg);
                $("#my-cha-addr-Modal").modal("hide");
                $(".info-table").find("#addr-td").html(newAddr)
            }
        })
    })
})