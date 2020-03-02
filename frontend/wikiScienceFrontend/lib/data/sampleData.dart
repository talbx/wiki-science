import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dataModel/sample.dart';

final List<Sample> data = [
  Sample(domain: '0000', measure: 0, color: kMainColorCharts),
];

final desktopSalesData = [
  Sample(domain: '2014', measure: 5, color: kMainColorCharts),
  Sample(domain: '2015', measure: 25, color: kMainColorCharts),
  Sample(domain: '2016', measure: 100, color: kMainColorCharts),
  Sample(domain: '2017', measure: 75, color: kMainColorCharts),
];

final tableSalesData = [
  Sample(domain: '2014', measure: 25, color: kMainColorCharts),
  Sample(domain: '2015', measure: 50, color: kMainColorCharts),
  Sample(domain: '2016', measure: 10, color: kMainColorCharts),
  Sample(domain: '2017', measure: 20, color: kMainColorCharts),
];

final mobileSalesData = [
  Sample(domain: '2014', measure: 0, color: kMainColorCharts),
  Sample(domain: '2015', measure: 5, color: kMainColorCharts),
  Sample(domain: '2016', measure: 0, color: kMainColorCharts),
  Sample(domain: '2017', measure: 5, color: kMainColorCharts),
];

List<charts.Series<Sample, String>> groupedData = [
  charts.Series<Sample, String>(
    id: 'Desktop',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    colorFn: (Sample sales, _) => sales.color,
    data: desktopSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Tablet',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    colorFn: (Sample sales, _) => sales.color,
    data: tableSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Mobile',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    colorFn: (Sample sales, _) => sales.color,
    data: mobileSalesData,
  ),
];
