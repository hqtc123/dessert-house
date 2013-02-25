$(function () {

    $("#loginBtn").on("click", function () {
        var account = $("#accountField").val();
        var password = $("#passwordField").val();

        if (account == "") {
            $('<div id="msg"/>').html("请填写账户名").appendTo('.sub').fadeOut(2000);
            return false;
        }
        if (password == "") {
            $('<div id="msg" />').html("请输入密码").appendTo('.sub').fadeOut(2000);
            return false;
        }


        $.ajax({
            url: "ajaxLogin!login.action",
            type: "POST",
            dataType: "json",
            data: {
                "customer.account": account,
                "customer.password": password
            },
            success: function (data) {
                if (data.resultMsg == "success") {
                    $.dialog({
                        lock: "true",
                        title: "提示",
                        content: data.msg,
                        time: 2
                    });
                    setTimeout("javascript:location.href='../index.jsp'", 1000);
                } else {
                    $.dialog({
                        title: "提示",
                        content: data.msg,
                        time: 2
                    });
                    return false;
                }
            }
        });
    })
})