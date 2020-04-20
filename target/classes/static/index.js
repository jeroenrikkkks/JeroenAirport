$(document).ready(function(){

                $.ajax({
                    url: "http://localhost:8080/api/airplanes/initialize",
                    type: 'GET',
                    contentType: "application/json",
                    dataType: 'json',
                    data: JSON.stringify({
                        name : name
                    }),
                    success: function(data){
                    console.log(data);
                    },
                });
});

//      function getPlanes(){
//
//            $('#error').empty();
//
//            $.getJSON(api, function(data){
//                var output = '';
//
//                $.each(data, function(index, value)
//                    output += '<tr><th scope= \"row\"></th><td>'+ value.name + '</td><td>' + value.getFuel() + '</td><td>' +  + '</td></tr>';
//                });
//                $('#').empty().append(output).listview('refresh');
//            });
//        }