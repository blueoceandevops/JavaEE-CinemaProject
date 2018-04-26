
$(document).ready(function(){
    var first = $( '.carousel-item' ).filter( ':first' );
    first.addClass("active");
    $("#dateScroller")
    {
        var d0 = new Date();
        var d1 = new Date(d0.getTime() + (24 * 60 * 60 * 1000));
        var d2 = new Date(d1.getTime() + (24 * 60 * 60 * 1000));
        var d3 = new Date(d2.getTime() + (24 * 60 * 60 * 1000));


        $("#d0 .week-day").text(getWeekDay(d0));
        $("#d0 .date").text(d0.getDate());
        $("#d0 .month").text(getMonth(d0));
        $("#d0").attr("date-date", d0);

        $("#d1 .week-day").text(getWeekDay(d1));
        $("#d1 .date").text(d1.getDate());
        $("#d1 .month").text(getMonth(d1));
        $("#d1").attr("date-date", d1);

        $("#d2 .week-day").text(getWeekDay(d2));
        $("#d2 .date").text(d2.getDate());
        $("#d2 .month").text(getMonth(d2));
        $("#d2").attr("date-date", d2);

        $("#d3 .week-day").text(getWeekDay(d3));
        $("#d3 .date").text(d3.getDate());
        $("#d3 .month").text(getMonth(d3));
        $("#d3").attr("date-date", d3);
    }

    $(".date-link").click(function () {
        $(".date-link").removeClass("active");
        $(this).addClass("active");
        var date = $(this).find(".date-info");
        var datObj = {date : date.attr("date-date")};
        getByDate(datObj);
    });

    $("#by-date").click(function () {
        $(".nav-link").removeClass("active");
        $(this).addClass("active");
        $(".calendar").removeClass("disable-calendar");

    });

    $("#by-film").click(function () {
        $(".nav-link").removeClass("active");
        $(this).addClass("active");
        $(".calendar").addClass("disable-calendar");
        getByFilm();
    });

    $("#by-new").click(function () {
        sortByNew();
    });

    $("#by-alphabet").click(function () {
        sortByAlphabet();
    });
});


function sortByAlphabet(){

    var films = jQuery.makeArray($('.one-film'));
    films.sort(function f(a, b) {
        a = $(a).attr('title');
        b = $(b).attr('title');
        var c = 0;
        if (a > b) c = 1;
        if (a < b) c = -1;
        return c;
    });
    $(".all-films").html("");
    films.forEach(function (div) {
        $(".all-films").append(div);
    });
}

function sortByNew() {
    var films = jQuery.makeArray($(".one-film"));
    films.sort(function f(a, b) {
        a = $(a).attr('date');
        b = $(b).attr('date');
        var c = 0;
        if (a > b) c = 1;
        if (a < b) c = -1;
        return c;
    });
    $(".all-films").html("");
    films.forEach(function (div) {
        $(".all-films").append(div);
    });
}

function getWeekDay(date) {
    var days = ['нд', 'пн', 'вт', 'ср', 'чт', 'пт', 'сб'];
    return days[date.getDay()];
}

function getMonth(date) {
    var days = ['січень', 'лютий', 'березень', 'квітень', 'травень', 'червень', 'липень', 'серпень', 'вересень', 'жовтень', 'листопад', 'грудень'];
    return days[date.getMonth()];
}