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
            url: "user/ajaxLogout!logout.action",
            type: "POST",
            dataType: "json",
            data: {
            },
            success: function (data) {
                if (data.resultMsg == "success") {
                    window.location.reload();
                }
            }
        })
    })
})