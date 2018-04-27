
function getByDate(datObj) {
    $.ajax({
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        url: "/by-date?date=" + datObj.date,
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

function getByFilm() {
    prefix = "/by-film"
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/by-film",
        async: true,
        success: function (date) {
            var v = $(date).find(".all-films").html();
            $(".all-films").html(v);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR : ", textStatus);
        }
    });
}
