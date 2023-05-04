<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- //jstl을 쓰겠다는 뜻!!
c 로 쓰겠다는것, 그래서 밑에 c:out  으로 쓸 수 있음--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
  #container{
    width: 600px;
    height: 400px;
    border: 2px solid red ;
  }
</style>

<script>
  let chart02={
    init:function () {
      $('#chart02>button').on('click',()=>{
       chart02.getdata();
      });
      setInterval(function (){
        chart02.getdata();
      },5000);
  },getdata:function (){ $.ajax({
        url:'/chart02',
        success:function (data){
          chart02.display(data);
        }
      })
      ;},
    display:function (data){
        Highcharts.chart('container', {
          chart: {
            type: 'column',
            options3d: {
              enabled: true,
              alpha: 10,
              beta: 25,
              depth: 70
            }
          },
          title: {
            text: 'External trade in goods by country, Norway 2021',
            align: 'left'
          },
          subtitle: {
            text: 'Source: ' +
                    '<a href="https://www.ssb.no/en/statbank/table/08804/"' +
                    'target="_blank">SSB</a>',
            align: 'left'
          },
          plotOptions: {
            column: {
              depth: 25
            }
          },
          xAxis: {
            categories: (data.category),
            labels: {
              skew3d: true,
              style: {
                fontSize: '16px'
              }
            }
          },
          yAxis: {
            title: {
              text: 'NOK (million)',
              margin: 20
            }
          },
          tooltip: {
            valueSuffix: ' MNOK'
          },
          series: [{
            name: 'Total imports',
            data: (data.datas)
          }]
        });

      }
  };

  $(function(){
    chart02.init();

  })
</script>



<div class="col-sm-8 text-left">
  <div class="container" id="chart02">
    <h3>chart02</h3>
    <button type="button" class="btn btn-danger">Danger</button>
    <div id="container"></div>
  </div>
</div>