$(function () {
    BannerList();

    $('#addBanBtn').on('click', function () {
        BannerAddAlert('add');
    })

    $("#bannerList").sortable({
        placeholder: "ui-state-highlight",
        stop: function (evt, ui) {

            var thisId = $(ui.item[0]).attr('data-id'),
                thisSort = $(ui.item[0]).index() + 1;

            var thisData = {
                'id': thisId,
                'newsort': thisSort
            }

            $.ajax({
                type: "post",
                url: commonCtx + "/newsbanner/setSort",
                data: thisData,
                success: function (res) {
                    if (res) {
                        BannerList();
                    } else {
                        layer.alert('移动失败，请重试', {icon: 5, title: '提示'});
                    }
                },
                error: function (XMLResponse, data) {

                }
            });


        }
    });
    $("#bannerList").disableSelection();

})

function upload(that) {
    var f = that.files;
    for (var i = 0; i < f.length; i++) {
        //上传方法开始
        upladFile(f[i], function (data) {
            if (data.url == '') {
                alert("上传失败,请稍后再试!");
            }
            $(".layui-layer #cover1").attr("src", data.url);
            $('.layui-layer #fileImgUrl').attr("href", data.url);
        })//上传方法结束
    }
}

function BannerAddAlert(type, Id, thisImg, thisUrl) {
    layer.open({
        scrollbar: false,
        btn: ['保存', '关闭'],
        content: $('#bannerAdd').html(),
        title: '添加Banner',
        area: '500px',
        yes: function (index, layero) {
            if (type == "edit") {
                BannerAdd('edit', Id, thisImg, thisUrl);
            } else {
                BannerAdd();
            }
        },
        btn2: function (index, layero) {
        },
        cancel: function () {
        },
        success: function (layero) {
            $('.layui-layer-content #cover1').attr({'src': thisImg});
            $('.layui-layer-content #link').val(thisUrl);
        }
    });
}

// 列表加载
function BannerList() {
    $.ajax({
        type: "post",
        url: commonCtx + "/newsbanner/list",
        // data: thisId,
        success: function (res) {
            var table = '';
            var thisres = res.rows;

            for (var i = 0; i < thisres.length; i++) {

                table += "<dl class=\"scene-item\" data-id='" + thisres[i].id + "'>" +
                    "<dt><img src=\"" + thisres[i].image + "\" alt=\"\"></dt>" +
                    "<dd><p class=\"banLink\"><label>链接地址：</label><span>" + thisres[i].url + "</span></p>" +
                    "<div>";

                if (thisres[i].status == "Y") {
                    table += "<span class=\"btn btn-custom\" onClick=\"recallnews('" + thisres[i].id + "','N',this)\">下线</span>";
                } else if (thisres[i].status == "N") {
                    table += "<span class=\"btn btn-warning\" onClick=\"recallnews('" + thisres[i].id + "','Y',this)\">发布</span>";
                }

                table += "<a class=\"btn btn-success ml10\" onclick=\"BannerAddAlert('edit','" + thisres[i].id + "','" + thisres[i].image + "','" + thisres[i].url + "')\">编辑</a>" +
                    "<span class=\"btn btn-danger ml10\" onclick=\"deleteBanner('" + thisres[i].id + "')\">删除</span>" +
                    "</div>" +
                    "</dd>" +
                    "</dl>";
            }

            $('#bannerList').html(table);

        },
        error: function (XMLResponse, data) {

        }
    });
}

// 添加Banner
function BannerAdd(type, vipId) {
    var _img = $('.layui-layer-content #cover1').attr('src');
    var _url = $('.layui-layer-content #link').val();

    if (type == "edit") {
        var thisData = {
            'id': vipId,
            'image': _img,
            'url': _url,
        };
    } else {
        var thisData = {
            'image': _img,
            'url': _url,
        };
    }

    $.ajax({
        type: "post",
        url: commonCtx + "/newsbanner/addBanner",
        data: thisData,
        success: function (res) {
            if (res) {
                BannerList();
                layer.alert('保存成功', {icon: 6, title: '提示'});
            } else {
                layer.alert('保存失败', {icon: 5, title: '提示'});
            }
        },
        error: function (XMLResponse, data) {

        }
    });

}

// 发布
function recallnews(thisId, status, that) {
    var tit = $(that).html();

    $.ajax({
        type: "post",
        url: commonCtx + "/newsbanner/setStatus",
        data: {
            'id': thisId,
            'status': status
        },
        success: function (res) {
            if (res) {
                layer.msg(tit + '成功');
                tit == "下线" ? $(that).html('发布').attr({'class': 'btn btn-warning'}) : $(that).html('下线').attr({'class': 'btn btn-custom'});
            }
        },
        error: function (XMLResponse, data) {

        }
    });
}

// 删除
function deleteBanner(thisId, that) {
    layer.confirm('您正在删除Banner，是否继续？<p class="red">（删除该Banner后，将无法恢复）</p>', {icon: 3, title: '删除'}, function (index) {
        $.ajax({
            type: "post",
            url: commonCtx + "/newsbanner/deleteBanner",
            data: {
                'id': thisId
            },
            success: function (res) {
                if (res) {
                    BannerList();
                    layer.alert('删除成功', {icon: 6, title: '提示'});
                }
            },
            error: function (XMLResponse, data) {

            }
        });
    });
}