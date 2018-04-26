function sortByTime() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/by-time",
        dataType: 'json',
        async: true,
        success: function() {
            console.log("SUCCESS");
        },
        error: function(e) {
            console.log("ERROR : ", e);
        }
    });
}

function sortByNew() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/by-new",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function () {
            console.log("SUCCESS");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function sortByAlfabet() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/by-alphabet",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function () {

            console.log("SUCCESS");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function getByDate(datObj) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/",
        data: JSON.stringify(datObj),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function () {
            console.log("SUCCESS");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

