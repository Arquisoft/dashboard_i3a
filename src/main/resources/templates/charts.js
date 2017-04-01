google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(dibujarGraficaVistas2013);

 function dibujarGraficaVistas2013() {
 var visitas2013 = google.visualization.arrayToDataTable([
 ['Mes', 'Visitas', 'Visitantes Únicos','Páginas Vistas' ],
 ['Avg2012', 1161, 910, 2053 ],
 ['Ene13', 4505, 3655, 6482 ],
 ['Feb13', 8090, 6400, 11503 ],
 ['Mar13', 7493, 5818, 11937 ],
 ['Abr13', 7048, 5581, 9751 ],
 ['May13', 11408, 8529, 16061 ],
 ['Jun13', 10886, 8261, 15643 ],
 ['Jul13', 11095, 8372, 16258 ],
 ['Ago13', 12900, 9848, 18585 ],
 ['Sep13', 15428, 11805, 21873 ],
 ['Oct13', 19978, 15455, 27169 ],
 ['Nov13', 20159, 15531, 27470 ],
 ['Dic13', 15093, 11358, 20863 ],
 ['Ene14', 16311, 12036, 24678 ],
 ['Feb14', 20572, 15450, 29638 ],
 ['Mar14', 25625, 19129, 36395 ],
 ['Abr14', 27106, 20059, 37410 ],
 ['May14', 34810, 25617, 48192 ],
 ['Jun14', 35255, 25868, 49291 ],
 ['Jul14', 37605, 27251, 53759 ]
 ]);

 var options = {
 legend: { position: 'bottom' },
 pointSize: 5,
 hAxis: {title: 'Meses', titleTextStyle: {color: '#0000FF'}},
 vAxis: {title: 'Número de Visitas', titleTextStyle: {color: '#0000FF'}},
 curveType: 'function',
 };

 var graficaVisitas2013 = new google.visualization.LineChart(document.getElementById('graficaVisitas2013_div'));
 graficaVisitas2013.draw(visitas2013, options);
 }