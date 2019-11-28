$.tree = function (menu) {
    var _this = this;
    var animationSpeed = 200;
    var thisUrl = window.location.href;

    $.each($('' + menu + ' li a'), function (i, v) {
        var thishref = $(v).attr('href');
        var dataUrl = $(v).attr('data-url');
        var tabUrl = $.trim(thishref).split('/')[1];

        if (thishref != '' && thishref != "/" && thisUrl.indexOf(tabUrl) > -1) {
            $('' + menu + ' li a').removeClass('is-active');
            $(v).addClass('is-active').siblings().removeClass('is-active');
            $(v).parents('.treeview-menu').show();
        } else if (dataUrl == 'index') {
            $(v).addClass('is-active').siblings().removeClass('is-active');
        }

    })

    $(document).on('click', menu + ' li a', function (e) {
        var $this = $(this);
        var checkElement = $this.next();

        if ((checkElement.is('.treeview-menu')) && (checkElement.is(':visible'))) {
            checkElement.slideUp(animationSpeed, function () {
                checkElement.removeClass('menu-open');
            });
            checkElement.parent("li").removeClass("active");
        } else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
            var parent = $this.parents('ul').first();
            var ul = parent.find('ul:visible').slideUp(animationSpeed);

            ul.removeClass('menu-open');

            var parent_li = $this.parent("li");

            checkElement.slideDown(animationSpeed, function () {
                checkElement.addClass('menu-open');
                parent.find('li.active').removeClass('active');
                parent_li.addClass('active');
            });
        }
        if (checkElement.is('.treeview-menu')) {
            e.preventDefault();
        }
    });
};

$.tree('.aside');

var commonCtx = $('#commonCtx').val();