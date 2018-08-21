
madeAjaxCall();

customMarker = L.Marker.extend({
options: {
seller: ''
}});

var mymap = L.map('mapid').setView([-23.6446169, -46.5283129], 18);

var ma2 = new customMarker([-23.6446169, -46.5283129],{seller: "Julia Tretona"});
ma2.addTo(mymap).on('click', onMapClick);

var ma1 = new customMarker([-23.644454, -46.528120],{seller: 'Julia Tretona'});
ma1.addTo(mymap).on('click', onMapClick);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox.streets',
    accessToken: 'pk.eyJ1Ijoid2lsbGlhbm5jYXJkb3NvIiwiYSI6ImNqamoyb2V3bTRkcDkzcnBlOTRqNmRyYmwifQ.3uvd97U0VQmM7e2imxqDEw'
}).addTo(mymap);


var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent(String(e.seller))
        //.setContent('azul')
        .openOn(mymap);
    myScript();

}

function myScript(){
    var x = document.getElementById("nome");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


// var ID = 2;
// function onMapClick(ID) {
//     popup.setContent(ID);
//
//
//     myScript();
//
// }
// layer UFABC
var geojsonLayer = {"type": "Feature",
    "properties": {
        "stroke": "#008040",
        "stroke-width": 2,
        "stroke-opacity": 1,
        "fill": "#408080",
        "fill-opacity": 2
    },
    "geometry": {
        "type": "Polygon",
        "coordinates": [
            [
                [
                    -46.52933120727539,
                    -23.64308927866194
                ],
                [
                    -46.52938485145568,
                    -23.64346275248227
                ],
                [
                    -46.529545783996575,
                    -23.643767427704216
                ],
                [
                    -46.530532836914055,
                    -23.644730589869493
                ],
                [
                    -46.5295135974884,
                    -23.645094230884396
                ],
                [
                    -46.528977155685425,
                    -23.645261308849765
                ],
                [
                    -46.52871966361999,
                    -23.64537924610864
                ],
                [
                    -46.52834415435791,
                    -23.645526667532778
                ],
                [
                    -46.52814030647278,
                    -23.645683916868812
                ],
                [
                    -46.527979373931885,
                    -23.64582150988282
                ],
                [
                    -46.52786135673523,
                    -23.645968930808706
                ],
                [
                    -46.52766823768616,
                    -23.64611635156853
                ],
                [
                    -46.527003049850464,
                    -23.645762541465952
                ],
                [
                    -46.52617692947388,
                    -23.64528096506696
                ],
                [
                    -46.52618765830994,
                    -23.64491732457093
                ],
                [
                    -46.52686357498169,
                    -23.6438263970201
                ],
                [
                    -46.5276038646698,
                    -23.64363966076201
                ],
                [
                    -46.52851581573486,
                    -23.64340378300254
                ],
                [
                    -46.52890205383301,
                    -23.643285843963383
                ],
                [
                    -46.52933120727539,
                    -23.64308927866194
                ]
            ]
        ]
    }
};


var geojson = L.geoJson(geojsonLayer, {
    style: function (feature) {
        return {
            weight: 5,
            color: feature.properties.fill,
            opacity: 10,
        };
    }
})
    geojson.addTo(mymap);

    function madeAjaxCall(){
      $.ajax({
        type: "get",
        url: "http://localhost:8080/ufabcsnack/src/main/java/add",
        cache: false,
        data:'sellerDesc=' + $("#sellerDesc").val() + "&sellerName;=" + $("#sellerName").val() + "&positionX;=" + $("#positionX").val() + "&positionY;=" + $("#positionY").val() + "&status;=" + $("#status").val(),
        success: function(response){
          $('#result').html("");
          var obj = JSON.parse(response);
          $('#result').html("nome:- " + obj.SellerDesc +"</br>biscoito:- " + obj.SellerName );
        },
        error: function(){
          alert('Error while request..');
        }
      });
    }
