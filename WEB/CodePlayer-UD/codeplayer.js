$(function() {
    resizeColumns();

    $('.toggle').click(function() {
        var $this   = $(this),
            $column = $('#' + $this.text().toLowerCase());

        $this.toggleClass('enabled');
        $column.toggleClass('enabled');

        resizeColumns();
    });

    $('#run').click( function() {
        $('iframe').contents().find("html").html(
            '<style>' + $('#cssText').val() + '</style>' +
            $('#htmlText').val()
//            '<script>' + $('#jsText').val() + '</script>'
        );

        document.getElementById('result-frame').contentWindow.eval($('#jsText').val());
    });
});

function resizeColumns() {
    var count = visibleColumns(),
        width = 100 / count;        // box-sizing: border-box takes care of padding / border etc

    $('.column').each(function() {
        $(this).css('width', width + '%')
    })

    var winHeight   = $(window).height(),
        headHeight  = $('header').outerHeight(),
        colHeight   = winHeight - headHeight - 10;

    $('.column').height(colHeight + 'px')
}

function visibleColumns() {
    return $('.column').filter( function() {
        return $(this).hasClass('enabled');
    }).length;
}
