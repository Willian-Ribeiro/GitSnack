//função que tinha o propósito de comunicação com backend
//sellerSearch();

customMarker = L.Marker.extend({
options: {
seller: ''
}});

var mymap = L.map('mapid').setView([-23.6446169, -46.5283129], 18);

mymap.dragging.disable();
mymap.touchZoom.disable();
mymap.doubleClickZoom.disable();
mymap.scrollWheelZoom.disable();
mymap.boxZoom.disable();
mymap.keyboard.disable();

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

//ativa cliquer no mapa e popups
function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent(String(e.seller))
        .setContent('Vendedor')
        .openOn(mymap);
    myScript2("Charli");

}

function myScript(){
    var x = document.getElementById("nome");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function myScript2(sellername){
    //var x = document.querySelector('[data-seller='+sellername+']');

    //    x.style.display = "none";
	var listItems = document.querySelectorAll('.tabela li');
	for (let i = 0; i < listItems.length; i++) {
		alert(String(listItems[i].getAttribute('data-seller')));
		//if (String(listItems[i].getAttribute('data-seller'))=== sellername ){
		//	listItems[i].style.display = "block";
		//}else{
		//	listItems[i].style.display = "none";
		//}
}

}

function crialista(Desc, Preco, vendedor){

   var novo = document.createElement("li");
   novo.setAttribute('id',Desc);
   novo.setAttribute('seller-name',vendedor);
   novo.innerHTML +=  '<strong> ' + Desc + ' </strong></br>' + Preco + '</br>';
   novo.setAttribute('class', 'list-group-item');
   document.getElementById("tabela").appendChild(novo);
   //var anterior = document.getElementById("nome");
   //document.body.insertBefore(novo, anterior);
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

//layer que define o contorno das dependências da universidade
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

//Adiciona a layer no mapa definida pelas bordas verder
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


    // function sellerSearch(){
    //   $.ajax({
    //     type: "get",
    //     url: "http://localhost:8080/add",
    //     cache: false,
    //     data:'sellerDesc=' + $("#sellerDesc").val() + "&sellerName;=" + $("#sellerName").val() + "&positionX;=" + $("#positionX").val() + "&positionY;=" + $("#positionY").val() + "&status;=" + $("#status").val(),
    //     success: function(response){
    //       $('#result').html("");
    //       var obj = JSON.parse(response);
    //       for (var i = 0; i < obj.counters.length; i++) {
    //         var counter =  obj.counters[i];
    //         criamarker(counter.sellerName,counter.positionX,counter.positionY );
    //         }
    //       $('#result').html("nome:- " + obj.SellerDesc +"</br>biscoito:- " + obj.SellerName );
    //     },
    //     error: function(){
    //       alert('Error while request..');
    //     }
    //   });
    // }

function criamarker(Nome, PosX, PosY){

  var ma = new customMarker([PosX, PosY],{seller: Nome});
  ma.addTo(mymap).on('click', onMapClick);

}

criamarker('Claudia', -23.645489, -46.527630);

criamarker('Nicole', -23.645275, -46.527585);

criamarker('Francine', -23.645034, -46.528102);

crialista ('Sanduíches de presunto','Unidade R$3.50', 'Charli');
crialista ('Marmitas saudáveis','Unidade R$10.00', 'Paula');
crialista('Surpresa na Caixa','Unidade R$3,00', 'Charli');
