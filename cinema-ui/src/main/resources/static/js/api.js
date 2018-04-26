
function getByDate(datObj) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/by-date",
        data: JSON.stringify(datObj),
        dataType: 'json',
        async: true,
        success: function (date) {
            console.log("SUCCESS: ",  date);
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
            console.log("SUCCESS " + date);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR : ", textStatus);
        }
    });
}
