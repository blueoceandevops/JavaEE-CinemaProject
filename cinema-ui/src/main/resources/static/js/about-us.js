$(document).ready(function() {
    $(".bottom-menu .nav-link").removeClass("active");
    $(".about-us").addClass("active");
});

function initCinemaMap() {
    var uluru = {lat: 50.464487, lng:  30.519826};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 17,
        center: uluru
    });
    var marker = new google.maps.Marker({
        position: uluru,
        map: map
    });
}