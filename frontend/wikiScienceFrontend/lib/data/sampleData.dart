import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'dataModel/sample.dart';

final List<Sample> data = [
  Sample(domain: '0000', measure: 0),
];

final desktopSalesData = [
  Sample(domain: '2014', measure: 5),
  Sample(domain: '2015', measure: 25),
  Sample(domain: '2016', measure: 100),
  Sample(domain: '2017', measure: 75),
];

final tableSalesData = [
  Sample(domain: '2014', measure: 25),
  Sample(domain: '2015', measure: 50),
  Sample(domain: '2016', measure: 10),
  Sample(domain: '2017', measure: 20),
];

final mobileSalesData = [
  Sample(domain: '2014', measure: 0),
  Sample(domain: '2015', measure: 5),
  Sample(domain: '2016', measure: 0),
  Sample(domain: '2017', measure: 5),
];

List<charts.Series<Sample, String>> groupedData = [
  charts.Series<Sample, String>(
    id: 'Desktop',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    data: desktopSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Tablet',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    data: tableSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Mobile',
    domainFn: (Sample sales, _) => sales.domain,
    measureFn: (Sample sales, _) => sales.measure,
    data: mobileSalesData,
  ),
];
