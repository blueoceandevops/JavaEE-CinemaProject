function getByDate(datObj) {
    $.ajax({
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        url: "/movie/by-date?date=" + datObj.date,
        async: true,
        success: function (date) {
            var v = $(date).find(".all-films").html();
            $(".all-films").html(v);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}