$.tree = function (menu) {
    var _this = this;
    var animationSpeed = 200;
    $(document).on('click', menu + ' li a', function (e) {
        //Get the clicked link and the next element
        var $this = $(this);
        var checkElement = $this.next();

        //Check if the next element is a menu and is visible
        if ((checkElement.is('.treeview-menu')) && (checkElement.is(':visible'))) {
            //Close the menu
            checkElement.slideUp(animationSpeed, function () {
                checkElement.removeClass('menu-open');
                //Fix the layout in case the sidebar stretches over the height of the window
                //_this.layout.fix();
            });
            checkElement.parent("li").removeClass("active");
        }
        //If the menu is not visible
        else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
            //Get the parent menu
            var parent = $this.parents('ul').first();
            //Close all open menus within the parent
            var ul = parent.find('ul:visible').slideUp(animationSpeed);
            //Remove the menu-open class from the parent
            ul.removeClass('menu-open');
            //Get the parent li
            var parent_li = $this.parent("li");

            //Open the target menu and add the menu-open class
            checkElement.slideDown(animationSpeed, function () {
                //Add the class active to the parent li
                checkElement.addClass('menu-open');
                parent.find('li.active').removeClass('active');
                parent_li.addClass('active');
            });
        }
        //if this isn't a link, prevent the page from being redirected
        if (checkElement.is('.treeview-menu')) {
            e.preventDefault();
        }
    });
};

$.tree('.aside');


$('#fromDate').datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    weekStart: 1, /*以星期一为一星期开始*/
    todayBtn: 1,
    autoclose: 1,
    minView: 2, /*精确到天*/
    pickerPosition: "bottom-left"
}).on("changeDate", function (ev) {  //值改变事件
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