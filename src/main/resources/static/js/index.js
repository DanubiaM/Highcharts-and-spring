$.ajax({
	url: "multiplelinechart",
	success: function(result){
		
		console.log(result);
		var formatteddata = [];
	
		for(var key in result){
			var singleObject = {
				name: '',
				data: []
			}
			singleObject.name = key.toLocaleUpperCase();
			for(var i = 0; i < result[key].length; i++){
				console.log(result[key][i].subscribers);
				singleObject.data.push(parseInt(result[key][i].subscribers));
			}
			
			formatteddata.push(singleObject);
			
		}
		
		
		drawMultipleLineChart(formatteddata);
		
	}
});

function drawMultipleLineChart(formatteddata){
	
	//console.log(formatteddata);

	Highcharts.chart('container',{
		title:{
			text:'<img src="/image/brf-logo.png" height="50px" width="100px" />',
			useHTML:true,
		},
		subtitle:{
			text: 'System Example'
		},
		yAxis:{
			title:{
				text:'Number of Employees'
			}
		},
		legend:{
			layout: 'vertical',
			align:'right',
			verticalAlign: 'middle'
		},
		plotOptions: {
			series: {
				label:{
					connectorAllowed: false
				},
				popintStart: 2011
			}
		},
		series: formatteddata,	
		responsive:{
			rules:[{
				condition:{
					maxWidth:600
				},
			
				charOptions:{
					legend:{
						layout: 'horizontal',
						align:'center',
						verticalAlign:'bottom'
					}
				}
			}]
		}
	});
}

document.getElementById('pdf').addEventListener('click', function () {
    Highcharts.charts[0].exportChart
({
        type: 'application/pdf',
 		scale:1
    });
});