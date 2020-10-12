<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<div id="chart_div" style="width: 800px; height: 500px;"></div>
<script>

// function drawStuff() {
	

 google.charts.load('current', {'packages':['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {

        var button = document.getElementById('change-chart');
        var chartDiv = document.getElementById('chart_div');

//         var data = google.visualization.arrayToDataTable([
//           ['Galaxy', 'Distance', 'Brightness'],
//           ['Canis Major Dwarf', 8000, 23.3],
//           ['Sagittarius Dwarf', 24000, 4.5],
//           ['Ursa Major II Dwarf', 30000, 14.3],
//           ['Lg. Magellanic Cloud', 50000, 0.9],
//           ['Bootes I', 60000, 13.1]
//         ]);
		var jsonData = $.ajax({
			url: "/admin/rest/chartData",
			dataType:"json",
			async: false
			}).responseText;

		var data = new google.visualization.DataTable(jsonData);
		console.log(data);
        var materialOptions = {
          width: 900,
          chart: {
            title: '일일 판매 통계',
            subtitle: '일일 판매량과 판매금액'
          },
          series: {
            0: { axis: 'distance' }, // Bind series 0 to an axis named 'distance'.
            1: { axis: 'brightness' } // Bind series 1 to an axis named 'brightness'.
          },
          axes: {
            y: {
              distance: {label: '판매금액'}, // Left y-axis.
              brightness: {side: 'right', label: '판매량'} // Right y-axis.
            }
          },
          vAxis: {
              viewWindow: {
                  max: 50000
                  
              }
          }          
        };

        function drawMaterialChart() {
          var materialChart = new google.charts.Bar(chartDiv);
          materialChart.draw(data, google.charts.Bar.convertOptions(materialOptions));
        }
        drawMaterialChart();
    };
		
// 			var jsonData = $.ajax({
// 				url : "/member/rest/adminChart",
// 				dataType : "json",
// 				async : false
// 			}).responseText;
// 			alert(jsonData);
			// Create our data table out of JSON data loaded from server.

</script>	
</body>

</html>