function showMem() {
    $("#man-strategy-table").hide();
    $("#man-mem-table").show();
    $("#strategy-menu").removeClass("active");
    $("#mem-menu").addClass("active")
}
function showStr() {
    $("#man-mem-table").hide();
    $("#man-strategy-table").show();
    $("#strategy-menu").addClass("active");
    $("#mem-menu").removeClass("active")
}
$(function () {
    showMem();
    $("#mem-menu").on("click", function () {
        showMem();
    })
    $("#strategy-menu").on("click", function () {
        showStr();
    })
    //manage members
    var memberId, account, position, shopid;
    $("#add-mem-tr").hide();
    $("#add-cancel").on("click", function () {
        $("#add-mem-tr").hide();
        $("#add-mem-btn").show();
    })
    $("#add-mem-btn").on("click", function () {
        $("#add-mem-tr").show();
        $("#add-mem-btn").hide();
    })
    $("#add-sure").on("click", function () {
        account = $("#add-acc").val();
        var password = $("#add-acc").val();
        position = $("#add-pos").val();
        shopid = $("#add-shop-id").val();
        if (account == "" || position == "" || shopid == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "addMember.action",
            data: {
                "member.account": account,
                "member.password": password,
                "member.position": position,
                "member.shop.id": shopid
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "添加成功") {
                    window.location.href = "viewMemAndStr.action";
                }
            }
        })
    })

    $(".change-mem").on("click", function () {
        var tr = $(this).parents("tr");
        memberId = tr.children("td:eq(0)").html();
        account = tr.children("td:eq(1)").html();
        position = tr.children("td:eq(2)").html();
        shopid = tr.children("td:eq(3)").html();
        tr.children("td:eq(2)").html('<input class="input-mini" value=' + position + ' id="cha-pos">');
        tr.children("td:eq(3)").html('<input class="input-mini" value=' + shopid + ' id="cha-shop-id">');
        tr.children("td:eq(4)").html(
            '<button class="btn" id="cha-sure">修改</button>'
        );
    })

    $(document).on("click", "#cha-sure", function () {
        position = $("#cha-pos").val();
        shopid = $("#cha-shop-id").val();
        if (position == "" || shopid == "") {
            alert("请输入完整的信息");
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "updateMember.action",
            data: {
                "member.id": memberId,
                "member.position": position,
                "member.shop.id": shopid
            },
            success: function (data) {
                alert(data.resultMsg);
                if (data.resultMsg == "修改成功") {
                    window.location.href = "viewMemAndStr.action";
                }
            }
        })
    })

    $(".delete-mem").on("click", function () {
        var tr = $(this).parents("tr");
        memberId = tr.children("td:eq(0)").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "deleteMember.action",
            data: {
                "member.id": memberId
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
    $("#add-strategy-tr").hide();
    $("#add-strategy-tr").hide();
    $("#add-strategy-cancel").on("click", function () {
        $("#add-strategy-tr").hide();
        $("#add-strategy-btn").show();
    })
    $("#add-strategy-btn").on("click", function () {
        $("#add-strategy-tr").show();
        $("#add-strategy-btn").hide();
    })

    $("#add-strategy-sure").on("click", function () {
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
                "strategy.score": score,
                "strategy.discount": discount
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

    $(".delete-strategy-mem").on("click", function () {
        var tr = $(this).parents("tr");
        var strategyId = tr.children("td:eq(0)").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "deleteStrategy.action",
            data: {
                "strategy.id": strategyId
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