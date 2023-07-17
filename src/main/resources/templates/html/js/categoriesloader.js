// JavaScript код для открытия/закрытия информации при щелчке на плитку
document.addEventListener('DOMContentLoaded', function() {
    var tiles = document.getElementsByClassName('tile');

    for (var i = 0; i < tiles.length; i++) {
        tiles[i].addEventListener('click', function() {
            var activeTile = document.querySelector('.tile.active');
            if (activeTile) {
                activeTile.classList.remove('active');
            }

            this.classList.add('active');
        });
    }
});