function getByDate(datObj) {
    $.ajax({
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        url: "/movie/by-date?id=" + $(".about-movie-text").attr("id") + "&date=" + datObj.date,
        async: true,
        success: function (date) {
            var v = $(date).find(".time-panel").html();
            $(".time-panel").html(v);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}