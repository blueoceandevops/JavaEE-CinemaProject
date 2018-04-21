$(document).ready(function () {
    var price = 60;
    var cinemaHall1 = {
            row: [10, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30]
        }, cinemaHallMap = '';
    var j = 1;
    $.each(cinemaHall1.row, function(row, numberOfSeats) {
        cinemaHallRow = '';
        for (i = 1; i <= numberOfSeats; i++) {
            cinemaHallRow += '<button type="button" class="btn btn-secondary seat " data-row="' +
                j + '" data-seat="' + i + '"' +
                'data-toggle="tooltip"' +
                'data-placement="top"' +
                'title="Ряд - ' + j + '\nМісце - ' + i +'\nЦіна - ' + price + ' грн'+'">&nbsp;</button>';
        }
        cinemaHallMap += cinemaHallRow + '<div class="passageBetween">&nbsp;</div>';
        j++;
    });

    $('.zal1').html(cinemaHallMap);
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
        $('.all-price-count').text(k*price);
        $('.result-places').html(result);
    }
});