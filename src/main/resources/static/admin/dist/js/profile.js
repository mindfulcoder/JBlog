$(function () {
    //修改个人信息
    $('#updateUserDetailButton').click(function () {
        $("#updateUserDetailButton").attr("disabled",true);
        var nickName = $('#nickName').val();
        if (validNickNameForUpdate(nickName)) {
            var params = $("#userDetailForm").serialize();
            $.ajax({
                type: "POST",
                url: "/admin/profile/detail",
                data: params,
                success: function (r) {
                    if (r == 'success') {
                        alert('修改成功');
                    } else {
                        alert('修改失败');
                        $("#updateUserNameButton").prop("disabled",false);
                    }
                }
            });
        } else {
            $("#updateUserNameButton").prop("disabled",false);
        }
    });
    //修改密码
    $('#updatePasswordButton').click(function () {
        $("#updatePasswordButton").attr("disabled",true);
        var oldPassword = $('#oldPassword').val();
        var newPassword = $('#newPassword').val();
        if (validPasswordForUpdate(oldPassword, newPassword)) {
            var params = $("#userPasswordForm").serialize();
            $.ajax({
                type: "POST",
                url: "/admin/profile/password",
                data: params,
                success: function (r) {
                    console.log(r);
                    if (r == 'success') {
                        alert('修改成功');
                        window.location.href = '/admin/login';
                    } else {
                        alert('修改失败');
                        $("#updatePasswordButton").attr("disabled",false);
                    }
                }
            });
        } else {
            $("#updatePasswordButton").attr("disabled",false);
        }
    });
})

/**
 * 名称验证
 */
function validNickNameForUpdate(nickName) {
    if (isNull(nickName) || nickName.trim().length < 1) {
        $('#updateUserName-info').css("display", "block");
        $('#updateUserName-info').html("昵称不能为空！");
        return false;
    }
    if (!validCN_ENString2_18(nickName)) {
        $('#updateUserName-info').css("display", "block");
        $('#updateUserName-info').html("请输入符合规范的昵称！");
        return false;
    }
    return true;
}

/**
 * 密码验证
 */
function validPasswordForUpdate(originalPassword, newPassword) {
    if (isNull(originalPassword) || originalPassword.trim().length < 1) {
        $('#updatePassword-info').css("display", "block");
        $('#updatePassword-info').html("请输入原密码！");
        return false;
    }
    if (isNull(newPassword) || newPassword.trim().length < 1) {
        $('#updatePassword-info').css("display", "block");
        $('#updatePassword-info').html("新密码不能为空！");
        return false;
    }
    if (!validPassword(newPassword)) {
        $('#updatePassword-info').css("display", "block");
        $('#updatePassword-info').html("请输入符合规范的密码！");
        return false;
    }
    return true;
}
