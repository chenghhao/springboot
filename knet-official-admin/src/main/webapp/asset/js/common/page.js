$.fn.extend({
    "initPage": function (listCount, currentPage, thisurl, fun, condition) {
        var maxshowpageitem = $(this).attr("maxshowpageitem");
        if (maxshowpageitem != null && maxshowpageitem > 0 && maxshowpageitem != "") {
            page.maxshowpageitem = maxshowpageitem;
        }
        var pagelistcount = $(this).attr("pagelistcount");
        if (pagelistcount != null && pagelistcount > 0 && pagelistcount != "") {
            page.pagelistcount = pagelistcount;
        }
        var pageId = $(this).attr("id");
        page.pageId = pageId;
        if (listCount < 0) {
            listCount = 0;
        }
        if (currentPage <= 0) {
            currentPage = 1;
        }
        page.setPageListCount(pageId, listCount, currentPage, fun, thisurl, condition);
    }
});
var page = {
    "maxshowpageitem": 5,
    "pageSize": 10,
    "pagelistcount": 10,
    "initWithUl": function (pageId, listCount, currentPage) {
        var pageCount = 1;
        if (listCount > 0) {
            var pageCount = listCount % page.pagelistcount > 0 ? parseInt(listCount / page.pagelistcount) + 1 : parseInt(listCount / page.pagelistcount);
        }
        var appendStr = page.getPageListModel(pageCount, currentPage);
        $("#" + pageId).html(appendStr);
    },
    "setPageListCount": function (pageId, listCount, currentPage, fun, thisurl, condition) {
        if (condition == "all") {
            var thisData = {
                'pageSize': page.pageSize,
                'page': currentPage
            }
        } else {
            var thisData = condition;
            thisData.page = currentPage;
        }
        $.ajax({
            type: "post",
            url: thisurl,
            data: thisData,
            success: function (res) {
                listCount = parseInt(res.total);  //总条数
                currentPage = parseInt(currentPage);
                page.initWithUl(pageId, listCount, currentPage);
                page.initPageEvent(pageId, listCount, fun, res, thisurl, condition);
            },
            error: function (XMLResponse, data) {

            }
        });

    },
    "initPageEvent": function (pageId, listCount, fun, listData, thisurl, condition) {
        if (typeof fun == "function") {
            fun(listData);
        }
        $("#" + pageId + " li[class='pageItem']").on("click", function () {
            // if (typeof fun == "function") {
            //     fun( listData );
            // }
            page.setPageListCount(pageId, listCount, $(this).attr("page-data"), fun, thisurl, condition);
        });
    },
    "getPageListModel": function (pageCount, currentPage) {
        var prePage = currentPage - 1;
        var nextPage = currentPage + 1;
        var prePageClass = "pageItem";
        var nextPageClass = "pageItem";

        if (prePage <= 0) {
            prePageClass = "pageItemDisable";
        }
        if (nextPage > pageCount) {
            nextPageClass = "pageItemDisable";
        }
        var appendStr = "";
        appendStr += "<li class='" + prePageClass + "' page-data='1' page-rel='firstpage'><a href=\"#\">首页</a></li>";
        appendStr += "<li class='" + prePageClass + "' page-data='" + prePage + "' page-rel='prepage'><a href=\"#\">上一页</a></li>";
        var miniPageNumber = 1;
        if (currentPage - parseInt(page.maxshowpageitem / 2) > 0 && currentPage + parseInt(page.maxshowpageitem / 2) <= pageCount) {
            miniPageNumber = currentPage - parseInt(page.maxshowpageitem / 2);
        } else if (currentPage - parseInt(page.maxshowpageitem / 2) > 0 && currentPage + parseInt(page.maxshowpageitem / 2) > pageCount) {
            miniPageNumber = pageCount - page.maxshowpageitem + 1;
            if (miniPageNumber <= 0) {
                miniPageNumber = 1;
            }
        }
        var showPageNum = parseInt(page.maxshowpageitem);
        if (pageCount < showPageNum) {
            showPageNum = pageCount
        }
        for (var i = 0; i < showPageNum; i++) {
            var pageNumber = miniPageNumber++;
            var itemPageClass = "pageItem";
            if (pageNumber == currentPage) {
                itemPageClass = "pageItemActive active";
            }
            appendStr += "<li class='" + itemPageClass + "' page-data='" + pageNumber + "' page-rel='itempage'><a href=\"#\">" + pageNumber + "</a></li>";
        }
        appendStr += "<li class='" + nextPageClass + "' page-data='" + nextPage + "' page-rel='nextpage'><a href=\"#\">下一页</a></li>";
        appendStr += "<li class='" + nextPageClass + "' page-data='" + pageCount + "' page-rel='lastpage'><a href=\"#\">尾页</a></li>";
        return appendStr;
    }
}

