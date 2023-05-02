<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- //jstl을 쓰겠다는 뜻!!
c 로 쓰겠다는것, 그래서 밑에 c:out  으로 쓸 수 있음--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
  let chart03={
    init:function (){
      this.getdata1();
      this.getdata2();
      this.getdata3();
    },
    getdata1:function (){
      $.ajax({
        url:'/chart0301',
        success:function (result){
          chart03.display1(result);
        }
      });
    },
    getdata2:function (){
      $.ajax({
        url:'/chart0302',
        success:function (data){
          chart03.display2(data);
        }
      });
    },
    getdata3:function (){
      $.ajax({
        url:'/chart0303',
        success:function (data){
          chart03.display3(data);
        }
      });
    },
    display1:function (result){
      Highcharts.chart('c1', { //c1 div 박스 display
        chart: {
          type: 'pie',
          options3d: {
            enabled: true,
            alpha: 45
          }
        },
        title: {
          text: 'Beijing 2022 gold medals by country',
          align: 'left'
        },
        subtitle: {
          text: '3D donut in Highcharts',
          align: 'left'
        },
        plotOptions: {
          pie: {
            innerSize: 100,
            depth: 45
          }
        },
        series: [{
          name: 'Medals',
          data: result
        }]
      });

    },//c1 div 박스 display 종료==========================================================
    display2:function (data){
      Highcharts.chart('c2', {
      chart: {
        type: 'spline',
        inverted: true
      },
      title: {
        text: 'Atmosphere Temperature by Altitude',
        align: 'left'
      },
      subtitle: {
        text: 'According to the Standard Atmosphere Model',
        align: 'left'
      },
      xAxis: {
        reversed: false,
        title: {
          enabled: true,
          text: 'Altitude'
        },
        labels: {
          format: '{value} km'
        },
        accessibility: {
          rangeDescription: 'Range: 0 to 80 km.'
        },
        maxPadding: 0.05,
        showLastLabel: true
      },
      yAxis: {
        title: {
          text: 'Temperature'
        },
        labels: {
          format: '{value}°'
        },
        accessibility: {
          rangeDescription: 'Range: -90°C to 20°C.'
        },
        lineWidth: 2
      },
      legend: {
        enabled: false
      },
      tooltip: {
        headerFormat: '<b>{series.name}</b><br/>',
        pointFormat: '{point.x} km: {point.y}°C'
      },
      plotOptions: {
        spline: {
          marker: {
            enable: false
          }
        }
      },
      series: [{
        name: 'Temperature',
        data: data
      }]
    });

    },
    display3:function (data) { //c3 diplay ==========================================================================
      Highcharts.chart('c3', {
        chart: {
          type: 'area'
        },
        accessibility: {
          description: 'Image description: An area chart compares the nuclear stockpiles of the USA and the USSR/Russia between 1945 and 2017. The number of nuclear weapons is plotted on the Y-axis and the years on the X-axis. The chart is interactive, and the year-on-year stockpile levels can be traced for each country. The US has a stockpile of 6 nuclear weapons at the dawn of the nuclear age in 1945. This number has gradually increased to 369 by 1950 when the USSR enters the arms race with 6 weapons. At this point, the US starts to rapidly build its stockpile culminating in 32,040 warheads by 1966 compared to the USSR’s 7,089. From this peak in 1966, the US stockpile gradually decreases as the USSR’s stockpile expands. By 1978 the USSR has closed the nuclear gap at 25,393. The USSR stockpile continues to grow until it reaches a peak of 45,000 in 1986 compared to the US arsenal of 24,401. From 1986, the nuclear stockpiles of both countries start to fall. By 2000, the numbers have fallen to 10,577 and 21,000 for the US and Russia, respectively. The decreases continue until 2017 at which point the US holds 4,018 weapons compared to Russia’s 4,500.'
        },
        title: {
          text: 'US and USSR nuclear stockpiles'
        },
        subtitle: {
          text: 'Source: <a href="https://fas.org/issues/nuclear-weapons/status-world-nuclear-forces/" ' +
                  'target="_blank">FAS</a>'
        },
        xAxis: {
          allowDecimals: false,
          labels: {
            formatter: function () {
              return this.value; // clean, unformatted number for year
            }
          },
          accessibility: {
            rangeDescription: 'Range: 1940 to 2017.'
          }
        },
        yAxis: {
          title: {
            text: 'Nuclear weapon states'
          },
          labels: {
            formatter: function () {
              return this.value / 1000 + 'k';
            }
          }
        },
        tooltip: {
          pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
        },
        plotOptions: {
          area: {
            pointStart: 1940,
            marker: {
              enabled: false,
              symbol: 'circle',
              radius: 2,
              states: {
                hover: {
                  enabled: true
                }
              }
            }
          }
        },
        series: [{
          name: 'USA',
          data: data.hundred
        }, {
          name: 'USSR/Russia',
          data: data.ten
        }]
      });
    }
    };
  $(function(){
    chart03.init();
  })
</script>



<div class="col-sm-8 text-left">
  <div class="container" id="chart03">
    <h3>chart03</h3>
    <div class="row">
      <div id="c1" class="col-sm-4"> </div>
      <div id="c2" class="col-sm-4"> </div>
      <div id="c3" class="col-sm-4"> </div>
    </div>
  </div>
</div>