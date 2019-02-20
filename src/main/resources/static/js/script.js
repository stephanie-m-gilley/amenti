function openCity(evt, cityName) {
    var i;
    var x = document.getElementByClassName("city");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(city Name).style.display = "block";
    }