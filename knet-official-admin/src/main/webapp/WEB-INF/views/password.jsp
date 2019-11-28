<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/ui/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<script type="text/javascript">
    $(function () {
        var v = $("form").validate(
            {
                submitHandler: function () {
                    $.post("${ctx}/my/changePassword", {
                        newPassword: $("#newPassword").val(),
                        oldPassword: $("#oldPassword").val(),
                    }, function (data) {
                        //alert(data);
                        if (data == 0) {
                            $.ligerDialog.alert('修改成功', '修改成功', 'success');
                            $("form")[0].reset();
                        } else {
                            if (data == -1) {
                                $.ligerDialog.alert("修改失败请确认原密码是否正确",
                                    '修改失败', 'error');
                            } else {
                                $.ligerDialog.alert("未知错误，请联系管理员", '修改失败',
                                    'error');
                            }
                        }
                    }, "html");

                }
            });
    })
</script>


<body>
<form class="l-form" ligeruiid="Form1000">

    <div class="l-group">
        <span>修改密码</span>
    </div>
    <ul>
        <li class='li-lable' style="width:100px">旧密码：</li>
        <li class='li-text'>
            <input type="password" validate="{required: true,messages:{required:'请输入旧密码'} }" class="l-text text-width"
                   name="oldPassword" id="oldPassword">
        </li>
    </ul>

    <ul>
        <li class='li-lable' style="width:100px">新密码：</li>
        <li class='li-text'>
            <input type="password" validate="{required: true,messages:{required:'请输入新密码'} }" class="l-text text-width"
                   name="newPassword" id="newPassword">
        </li>
    </ul>

    <ul>
        <li class='li-lable' style="width:100px">确认密码：</li>
        <li class='li-text'>
            <input type="password"
                   validate="{required: true,equalTo:'#newPassword',messages:{required:'请确认新密码',equalTo:'请确认新密码'} }"
                   class="l-text text-width" name="rePassword" id="rePassword">
        </li>
    </ul>


    <ul>
        <input type="submit" class="l-button" value="提交"
               style="width: 100; margin-left: 200px; margin-top: 40px; padding-bottom: 20px">
    </ul>


</form>
</body>
</html>