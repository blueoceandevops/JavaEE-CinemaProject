$(document).ready(function () {
    $(".bottom-menu .nav-link").removeClass("active");
     var price = 60;

    $('.seat').on('click', function(e) {
        $(e.currentTarget).toggleClass('bay');
        showBaySeat();
    });

    function showBaySeat() {
        result = '';
        k = 0;
        $.each($('.seat.bay'), function(key, item) {
            result += '<div class="ticket">Ряд: ' +
                $(item).data().row + ' Місце:' +
                $(item).data().seat + '</div>';
            k++;
        });
        if(k == 0){
            result = 'Для того щоб продовжити оберіть місце';
            $('.pay-button').addClass('disabled');
        } else {
            $('.pay-button').removeClass('disabled');
        }
        $('.all-price-count').text(k*price + ' грн');
        $('.result-places').html(result);
    }
});