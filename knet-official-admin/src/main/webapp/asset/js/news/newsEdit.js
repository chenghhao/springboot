function upload() {
    var f = document.getElementById("file").files;
    for (var i = 0; i < f.length; i++) {
        //上传方法开始
        upladFile(f[i], function (data) {
            if (data.url == '') {
                alert("上传失败,请稍后再试!");
            }
            $("#cover1").attr("src", data.url);
            $("#cover").val(data.url);
            $('#fileImgUrl').attr("href", data.url);
        })//上传方法结束
    }
}

$(function () {
    $('#query').on('click', function () {
        var _title = $('#title').val();

        var thisData = {
            'id': $('#id').val(), //主体
            'title': _title,		//标题
            'digest': $('#digest').val(),   //摘要
            'cover': $('#cover').val(),		//图片
            'keyword': $('#keyword').val(),
            'createDate':new Date($('#createDate').val()),
            "group": String($('#selectpicker').val()),
            "content": $('#summernote').summernote('code')   //编辑器内容
        };

        if (_title != '') {
            $.ajax({
                type: "post",
                url: commonCtx + "/news/save",
                data: thisData,
                success: function (res) {
                    if (res.flag) {
                        layer.alert('保存成功', {icon: 6, title: '提示', btn: ['返回列表页']}, function () {
                            location.href = commonCtx + "/news/index";
                        });
                    }
                },
                error: function (XMLResponse, data) {

                }
            });
        }
    })

    var dh = $(window).height() - 160;

    $('#summernote').summernote({
        placeholder: '请输入...',
        lang: 'zh-CN',
        tabsize: 2,
        fontNames: ['微软雅黑', '宋体', '黑体', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New'],
        height: dh,
        toolbar: [
            ['undo', ['undo']],
            ['redo', ['redo']],
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['color', ['color']],
            ['style', ['style']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            // ['table',['table']],
            ['hr', ['hr']],
            ['link', ['link']],
            ['picture', ['picture']],
            ['fullscreen', ['fullscreen']],
            ['codeview', ['codeview']],
        ],
        callbacks: {
            onImageUpload: function (files) {

                var formData = new FormData();
                formData.append("file", files[0]);

                $.ajax({
                    url: "/upload",
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    type: 'POST',
                    success: function (data) {
                        $('#summernote').summernote('insertImage', data.url, 'img');
                    }
                });
            }
        }
    });


    // 下拉框
    $('.selectpicker').selectpicker({
        noneSelectedText: '请选择' //默认显示内容
    });

})
$('#createDate').datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm-dd hh:ii:ss',
    weekStart: 1, /*以星期一为一星期开始*/
    todayBtn: 1,
    autoclose: 1,
    pickerPosition: "bottom-left",
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showSecond:1,
    minuteStep:1
}).on("changeDate", function (ev) {
    //选择的日期不能小于第一个日期控件的日期
    if (ev.date) {
        $("#createDate").datetimepicker('setEndDate', new Date(ev.date.valueOf()));
    } else {
        $("#createDate").datetimepicker('setEndDate', new Date());
    }
});