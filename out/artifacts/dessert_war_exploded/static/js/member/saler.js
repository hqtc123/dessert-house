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
$(function () {
    showMem();
    $("#dessert-menu").on("click", function () {
        showMem();
    })
    $("#weeknum-menu").on("click", function () {
        showStr();
    })
    //manage members
    var dessertId, name, price;
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
        price = $("#cha-priced").val();
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

    //manage strategies
    $("#add-weeknum-tr").hide();
    $("#add-weeknum-tr").hide();
    $("#add-weeknum-cancel").on("click", function () {
        $("#add-weeknum-tr").hide();
        $("#add-weeknum-btn").show();
    })
    $("#add-weeknum-btn").on("click", function () {
        $("#add-weeknum-tr").show();
        $("#add-weeknum-btn").hide();
    })

    $("#add-weeknum-sure").on("click", function () {
        var score = $("#add-sco").val();
        var discount = $("#add-dis").val();
        if (score == "" || discount == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "addStrategy.action",
            data: {
                "weeknum.score": score,
                "weeknum.discount": discount
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "添加成功") {
                    window.location.href = "viewMemAndStr.action";
                    showStr();
                }
            }
        })
    })

    $(".delete-weeknum-mem").on("click", function () {
        var tr = $(this).parents("tr");
        var weeknum = tr.children("td:eq(0)").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "deleteStrategy.action",
            data: {
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