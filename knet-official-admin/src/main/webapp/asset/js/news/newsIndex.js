$('#fromDate').datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    weekStart: 1,
    todayBtn: 1,
    autoclose: 1,
    minView: 2,
    pickerPosition: "bottom-left"
}).on("changeDate", function (ev) {
    if (ev.date) {
        $("#toDate").datetimepicker('setStartDate', new Date(ev.date.valueOf()));
    } else {
        $("#toDate").datetimepicker('setStartDate', null);
    }
});

$('#toDate').datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    weekStart: 1, /*以星期一为一星期开始*/
    todayBtn: 1,
    autoclose: 1,
    minView: 2, /*精确到天*/
    pickerPosition: "bottom-left"
}).on("changeDate", function (ev) {
    //选择的日期不能小于第一个日期控件的日期
    if (ev.date) {
        $("#fromDate").datetimepicker('setEndDate', new Date(ev.date.valueOf()));
    } else {
        $("#fromDate").datetimepicker('setEndDate', new Date());
    }
});

// 下线
function recallnews(thisId, that) {
    var tit = $(that).html();

    $.ajax({
        type: "post",
        url: commonCtx + "/news/recallnews",
        data: {
            'newsId': thisId
        },
        success: function (res) {
            if (res) {
                layer.msg(tit + '成功');
                location.reload();
                //tit == "下线" ? $(that).html('发布').attr({'class': 'btn btn-warning'}) : $(that).html('下线').attr({'class': 'btn btn-custom'});
            }
        },
        error: function (XMLResponse, data) {

        }
    });
}

// 删除
function deletenews(thisId,that){
layer.confirm('您正在删除文章，是否继续？<p class="red">（删除该文章后，将无法恢复）</p>', {icon: 3, title:'删除'}, function(index){
       $.ajax({
            type: "post",
            url: commonCtx+"/news/deletenews",
            data:{
                'newsId':thisId
            },
             success:function(res){
                 if (res){
                     $(that).parents('tr').remove();
                     layer.alert('删除成功', {icon: 6,title:'提示'});
                 }
             },
             error:function(XMLResponse,data){

             }
         });
     });
 }


$(function () {
    var pageDetail = {
        "list": function (data) {

            var table = '';
            var thisRows = data.rows;

            for (var i = 0; i < thisRows.length; i++) {
                table += "<tr>" +
                    "<td>" + thisRows[i].title + "</td>" +
                    "<td>" + thisRows[i].createDate + "</td>";
                if (thisRows[i].status == "Y"){
                    table += "<td>已发布</td>";
                }else{
                    table += "<td>未发布</td>";
                }
                table += "<td>" + thisRows[i].readingVolume + "</td>" +
                    "<td width='250' align=\"center\">";
                if (thisRows[i].status == "Y") {
                    table += "<span class=\"btn btn-custom\" onClick=\"recallnews(" + thisRows[i].id + ",this)\">下线</span>";
                } else if (thisRows[i].status == "N") {
                    table += "<span class=\"btn btn-warning\" onClick=\"recallnews(" + thisRows[i].id + ",this)\">发布</span>";
                    table += "<a class=\"btn btn-success ml10\" href=\"" + commonCtx + "/news/toedit?newsId=" + thisRows[i].id + "\">编辑</a>";
                    table += "<span class=\"btn btn-danger ml10\" onClick=\"deletenews('" + thisRows[i].id + "',this)\">删除</span>";
                }
                table += "</td>" +
                    "</tr>";
            }

            $('#NewsTable').html(table);
        }
    };

    // 10:新闻总条数，
    // 1：当前页
    // newsUrl：列表接口
    // pageDetail.list：新闻列表内容
    $("#page").initPage(10, 1, commonCtx + "/news/list", pageDetail.list, 'all');


    $("#query").click(function () {
        var title = $("#title").val();
        var fromDate = $("#fromDate").val();
        var toDate = $("#toDate").val();
        var group = $("#group").val();
        var status=$("#status").val();
        var condition = {
            'title': title,
            'fromDate': fromDate,
            'toDate': toDate,
            'group': group,
            'status':status,
            'page': 1,
            'pageSize': 10
        };

        $("#page").initPage(10, 1, commonCtx + "/news/list", pageDetail.list, condition);
    })

})