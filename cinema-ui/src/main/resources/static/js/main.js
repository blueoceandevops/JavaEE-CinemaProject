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
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/",
            data: JSON.stringify(datObj),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
            }
        });
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
    });

    $("#by-time").click(function () {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/by-time",
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
            }
        });
    });

    $("#by-new").click(function () {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/by-new",
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
            }
        });
    });

    $("#by-alphabet").click(function () {

    });

});

function getWeekDay(date) {
    var days = ['нд', 'пн', 'вт', 'ср', 'чт', 'пт', 'сб'];
    return days[date.getDay()];
}

function getMonth(date) {
    var days = ['січень', 'лютий', 'березень', 'квітень', 'травень', 'червень', 'липень', 'серпень', 'вересень', 'жовтень', 'листопад', 'грудень'];
    return days[date.getMonth()];
}