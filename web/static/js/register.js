$(function () {
//
//    $("#registerBtn").on("click", function () {
//        var account = $("#accountField").val();
//        var password = $("#passwordField").val();
//        var rePassword = $("#rePasswordField").val();
//        var age = $("#ageField").val();
//        var sex = $('input:radio[name=sex]:checked').val();
//        var address = $("#addressField").val();
//        if (account == "") {
//            $('<div id="msg"/>').html("请填写账户名").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        if (password == "") {
//            $('<div id="msg" />').html("请输入密码").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        if (rePassword == "") {
//            $('<div id="msg" />').html("请输入确认密码").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        if (rePassword != password) {
//            $('<div id="msg" />').html("两次密码不一致").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        if (age == "") {
//            $('<div id="msg" />').html("请输入年龄").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        var regNum = /^[1-9][0-9]$/;
//        if (!regNum.test(age)) {
//            $('<div id="msg" />').html("请填写有效年龄").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        if (address == "") {
//            $('<div id="msg" />').html("请填写地址信息").appendTo('.sub').fadeOut(2000);
//            return false;
//        }
//        $.ajax({
//            url: "ajaxRegister!register.action",
//            type: "POST",
//            dataType: "json",
//            data: {
//                "customer.account": account,
//                "customer.password": password,
//                "customer.age": age,
//                "customer.sex": sex,
//                "customer.address": address
//            },
//            success: function (data) {
//                if (data.resultMsg == "success") {
//                    $.dialog({
//                        lock:"true",
//                        title:"提示",
//                        content:data.msg,
//                        time:2
//                    });
//                } else {
//                    $.dialog({
//                        title:"提示",
//                        content:data.msg,
//                        time:2
//                    });
//                    return false
//                }
//            }
//        });
//    })
})