$(document).ready(function(){
    $("#dateScroller")
    {
        var d0 = new Date();
        var d1 = new Date(d0.getTime() + (24 * 60 * 60 * 1000));
        var d2 = new Date(d1.getTime() + (24 * 60 * 60 * 1000));
        var d3 = new Date(d2.getTime() + (24 * 60 * 60 * 1000));


        $("#d0 .week-day").text(getWeekDay(d0));
        $("#d0 .date").text(d0.getDate());
        $("#d0 .month").text(getMonth(d0));

        $("#d1 .week-day").text(getWeekDay(d1));
        $("#d1 .date").text(d1.getDate());
        $("#d1 .month").text(getMonth(d1));

        $("#d2 .week-day").text(getWeekDay(d2));
        $("#d2 .date").text(d2.getDate());
        $("#d2 .month").text(getMonth(d2));

        $("#d3 .week-day").text(getWeekDay(d3));
        $("#d3 .date").text(d3.getDate());
        $("#d3 .month").text(getMonth(d3));
    }


});

function getWeekDay(date) {
    var days = ['нд', 'пн', 'вт', 'ср', 'чт', 'пт', 'сб'];
    return days[date.getDay()];
}

function getMonth(date) {
    var days = ['січень', 'лютий', 'березень', 'квітень', 'травень', 'червень', 'липень', 'серпень', 'вересень', 'жовтень', 'листопад', 'грудень'];
    return days[date.getMonth()];
}