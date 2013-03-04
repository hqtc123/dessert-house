/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:01
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    $("#logoutLink").on("click", function () {
        $.ajax({
            url: "ajaxLogout!logout.action",
            type: "POST",
            dataType: "json",
            data: {
            },
            success: function (data) {
                if (data.resultMsg == "success") {
                    $.dialog({
                        lock: "true",
                        title: "提示",
                        content: data.msg,
                        time: 2,
                        close: function () {
                            window.location.reload();
                        }
                    });
                } else {
                    $.dialog({
                        title: "提示",
                        content: data.msg,
                        time: 2
                    });
                    return false;
                }
            }
        })
    })
})