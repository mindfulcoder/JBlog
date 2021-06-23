$(function () {
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
    }
    );
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

