<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>구글맵</title>
    <style>
        * {margin: 0;padding: 0;}
        html,body {width: 100%;height: 100%}
        #map{width: 100%;height: 80%}
    </style>
    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <!-- Axois -->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>


</head>

<body>
    <h1>구글 맵</h1>
    <br>
    <div id="map">
    
    </div>

    <!-- 구글 맵 -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAgQnQTrVIG7rNPGo1L6nDQoVkEqCCzlQE&callback=initMap" async defer></script>
    <script>
        var map;
        
        function initMap() {
            map = new google.maps.Map(
                document.getElementById('map'),
                {
                    center : {
                        lat:37.514320,
                        lng:127.030685
                    },
                    zoom:17
                }
                
            );
        }
    </script>
</body>

</html>