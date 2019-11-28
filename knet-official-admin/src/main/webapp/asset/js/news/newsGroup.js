$(function () {
    // 新建分组
    $('#addGroup').on('click', function () {
        layer.prompt({icon: 6, title: '新建分类', btn: ['确认', '取消']}, function (val, index) {
            $.ajax({
                type: "post",
                url: commonCtx + "/newsgroup/addgroup",
                data: {"groupName": val},
                success: function (res) {
                    if (res) {
                        layer.alert('新建成功', {icon: 6, title: '提示'});
                        groupList();
                    } else {
                        layer.alert('新建失败', {icon: 5, title: '提示'});
                    }
                },
                error: function (XMLResponse, data) {

                }
            });
            layer.close(index);
        });
    })

    groupList();

})

// 列表加载
function groupList() {
    $.ajax({
        type: "post",
        url: commonCtx + "/newsgroup/list",
        // data: thisId,
        success: function (res) {
            var table = '';
            var thisres = res.rows;

            table += "<tr>" +
                "<td>其他分组</td>" +
                "<td>" + res.total + "</td>" +
                "<td width='150' align=\"center\"></td>" +
                "</tr>";

            for (var i = 0; i < thisres.length; i++) {
                table += "<tr>" +
                    "<td>" + thisres[i].groupName + "</td>" +
                    "<td>" + thisres[i].newstotal + "</td>" +
                    "<td width='150' align=\"center\">" +
                    "<a class=\"btn btn-success\" onclick=\"editGroup('" + thisres[i].id + "','" + thisres[i].groupName + "',this)\">编辑</a>" +
                    "<span class=\"btn btn-danger ml10\" onClick=\"deleteGroup('" + thisres[i].id + "',this)\">删除</span>";
                "</td>" +
                "</tr>";
            }

            $('#GroupList').html(table);

        },
        error: function (XMLResponse, data) {

        }
    });
}

// 删除分类
function deleteGroup(thisId) {
    var thisData = {
        'id': thisId
    };

    layer.confirm('您正在删除分组，是否继续？<p class="red">（删除该分组后，文章将自动归为其他分组）</p>', {icon: 3, title: '删除'}, function (index) {
        $.ajax({
            type: "post",
            url: commonCtx + "/newsgroup/deletegroup",
            data: thisData,
            success: function (res) {
                groupList();
                if (res) {
                    layer.alert('删除成功', {icon: 6, title: '提示'});
                } else {
                    layer.alert('删除失败', {icon: 5, title: '提示'});
                }
            },
            error: function (XMLResponse, data) {

            }
        });

    });

}

// 编辑分类
function editGroup(thisId, thisGroupName) {
    layer.prompt({icon: 6, value: thisGroupName, title: '编辑分类', btn: ['确认', '取消']}, function (val, index) {
        var thisData = {
            'id': thisId,
            'groupName': val
        };

        $.ajax({
            type: "post",
            url: commonCtx + "/newsgroup/editgroup",
            data: thisData,
            success: function (res) {
                if (res) {
                    layer.alert('编辑成功', {icon: 6, title: '提示'});
                    groupList();
                } else {
                    layer.alert('编辑失败', {icon: 5, title: '提示'});
                }
            },
            error: function (XMLResponse, data) {

            }
        });
        layer.close(index);
    });

}