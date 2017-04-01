google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(porcentajeVisitasPaises);

 function porcentajeVisitasPaises() {
 var porcentajeVisitas = google.visualization.arrayToDataTable([
 ['Pais', 'Visitas'],
 ['España', 111740],    ['Mexico', 75735]]);

 var options = {
 title: 'Porcentajes'
 };

 var porVisitasChart = new google.visualization.PieChart(document.getElementById('porcentajePaises_div'));
 porVisitasChart.draw(porcentajeVisitas, options);
 }