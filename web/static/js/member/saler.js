function showMem() {
    $("#man-weeknum-table").hide();
    $("#man-dessert-table").show();
    $("#weeknum-menu").removeClass("active");
    $("#dessert-menu").addClass("active")
}
function showStr() {
    $("#man-dessert-table").hide();
    $("#man-weeknum-table").show();
    $("#weeknum-menu").addClass("active");
    $("#dessert-menu").removeClass("active")
}

function showTableWeekday(weekday) {
    for (var i = 1; i < 6; i++) {
        $("#tbody" + i).hide();
    }
    $("#tbody" + weekday).show();
}
$(function () {
    showMem();
    $("#dessert-menu").on("click", function () {
        showMem();
    })
    $("#weeknum-menu").on("click", function () {
        showStr();
    })


    //manage desserts
    var dessertId, name, price, weekday = 1;
    $("#add-dessert-tr").hide();
    $("#add-cancel").on("click", function () {
        $("#add-dessert-tr").hide();
        $("#add-dessert-btn").show();
    })
    $("#add-dessert-btn").on("click", function () {
        $("#add-dessert-tr").show();
        $("#add-dessert-btn").hide();
    })
    $("#add-dessert-sure").on("click", function () {
        name = $("#add-name").val();
        price = $("#add-price").val();
        if (name == "" || price == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "addDessert.action",
            data: {
                "dessert.name": name,
                "dessert.price": price
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "添加成功") {
                    window.location.href = "viewDesserts.action";
                }
            }
        })
    })

    $(".change-dessert").on("click", function () {
        var tr = $(this).parents("tr");
        dessertId = tr.children("td:eq(0)").html();
        name = tr.children("td:eq(1)").html();
        price = tr.children("td:eq(2)").html();
        tr.children("td:eq(1)").html('<input class="input-mini" value=' + name + ' id="cha-name">');
        tr.children("td:eq(2)").html('<input class="input-mini" value=' + price + ' id="cha-price">');
        tr.children("td:eq(3)").html(
            '<button class="btn" id="cha-dessert-sure">修改</button>'
        );
    })

    $(document).on("click", "#cha-dessert-sure", function () {
        name = $("#cha-name").val();
        price = $("#cha-price").val();
        if (name == "" || price == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "updateDessert.action",
            data: {
                "dessert.id": dessertId,
                "dessert.name": name,
                "dessert.price": price
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "修改成功") {
                    window.location.href = "viewDesserts.action";
                }
            }
        })
    })

    $(".delete-dessert").on("click", function () {
        var tr = $(this).parents("tr");
        dessertId = tr.children("td:eq(0)").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "deleteDessert.action",
            data: {
                "dessert.id": dessertId
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "删除成功") {
                    tr.hide();
                }
            }
        })
    })

    //manage weeknums

    showTableWeekday(1);
    $("#week-select").on("change", function () {
        weekday = $(this).children('option:selected').val();
        showTableWeekday(weekday);
    })
    $(".add-weeknum-tr").hide();
    $(".add-weeknum-cancel").on("click", function () {
        $(".add-weeknum-tr").hide();
        $(".add-weeknum-btn").show();
    })
    $(".add-weeknum-btn").on("click", function () {
        $(".add-weeknum-tr").show();
        $(".add-weeknum-btn").hide();
    })

    $(".add-weeknum-sure").on("click", function () {
        var tr = $(this).parents("tr");
        var dessertid = tr.children().children(".add-dessert-id").val();
        var num = tr.children().children(".add-dessert-num").val();
        if (dessertid == "" || num == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "addWeeknum.action",
            data: {
                "weeknum.weekday": weekday,
                "weeknum.dessertid": dessertid,
                "weeknum.num": num
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "添加成功") {
                    window.location.href = "viewDesserts.action";
                    showStr();
                }
            }
        })
    })

    $(".delete-weeknum-mem").on("click", function () {
        var tr = $(this).parents("tr");
        var weeknumid = tr.children("td:eq(0)").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "deleteWeeknum.action",
            data: {
                "weeknum.id": weeknumid
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "删除成功") {
                    tr.hide();
                }
            }
        })
    })
})