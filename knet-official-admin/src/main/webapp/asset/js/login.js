var commonCtx = $('#commonCtx').val();
$(function () {
    if (window != top)
        top.location.href = location.href;
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            $("#go").click();
        }
    }
    $("#go").click(function () {
        if (!$("#j_username").val()) {
            $("#error").html("请输入用户名");
            return false;
        }
        if (!$("#j_password").val()) {
            $("#error").html("请输入密码");
            return false;
        }
        $.post(commonCtx + "/login", $("form").serialize(), function (data) {
            if (data.code != "0") {
                $("#error").html(data.msg);
            } else {
                window.location.replace(commonCtx + "/");
            }
        })
    });
})