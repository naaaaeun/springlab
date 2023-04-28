<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- //jstl을 쓰겠다는 뜻!!
c 로 쓰겠다는것, 그래서 밑에 c:out  으로 쓸 수 있음--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
  #container{
    width: 400px;
    height: 400px;
    border: 2px solid red ;
  }
</style>

<script>
  let chart01={
    init:function (){
      Highcharts.chart('container', {
        chart: {
          type: 'spline'
        },
        title: {
          text: 'Monthly Average Temperature'
        },
        subtitle: {
          text: 'Source: ' +
                  '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                  'target="_blank">Wikipedia.com</a>'
        },
        xAxis: {
          categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
          accessibility: {
            description: 'Months of the year'
          }
        },
        yAxis: {
          title: {
            text: 'Temperature'
          },
          labels: {
            formatter: function () {
              return this.value + '°';
            }
          }
        },
        tooltip: {
          crosshairs: true,
          shared: true
        },
        plotOptions: {
          spline: {
            marker: {
              radius: 4,
              lineColor: '#666666',
              lineWidth: 1
            }
          }
        },
        series: [{
          name: 'Tokyo',
          marker: {
            symbol: 'square'
          },
          data: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, 26, 22.8, 17.5, 12.1, 7.6]

        }, {
          name: 'Bergen',
          marker: {
            symbol: 'diamond'
          },
          data: [ 1.0, 1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
        },{
          name: 'Korea',
          marker: {
            symbol: 'diamond'
          },
          data: [ 2.0, 3.6, 4.3, 5.9, 10.5, 18.5, 19.5, 20.4, 11.5, 9.7, 4.7, 3.6]

        }]
      });}
  };


  $(function(){
    chart01.init();

  })
</script>



<div class="col-sm-8 text-left">
  <div class="container">
    <h3>chart01</h3>
    <div id="container"></div>
  </div>
</div>