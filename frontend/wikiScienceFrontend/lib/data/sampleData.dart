import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dataModel/dataModel.dart';

final List<DataModel> data = [
  DataModel(domain: '0000', measure: 0, color: kMainColorCharts),
];

final desktopSalesData = [
  DataModel(domain: '2014', measure: 5, color: kMainColorCharts),
  DataModel(domain: '2015', measure: 25, color: kMainColorCharts),
  DataModel(domain: '2016', measure: 100, color: kMainColorCharts),
  DataModel(domain: '2017', measure: 75, color: kMainColorCharts),
];

final tableSalesData = [
  DataModel(domain: '2014', measure: 25, color: kMainColorCharts),
  DataModel(domain: '2015', measure: 50, color: kMainColorCharts),
  DataModel(domain: '2016', measure: 10, color: kMainColorCharts),
  DataModel(domain: '2017', measure: 20, color: kMainColorCharts),
];

final mobileSalesData = [
  DataModel(domain: '2014', measure: 0, color: kMainColorCharts),
  DataModel(domain: '2015', measure: 5, color: kMainColorCharts),
  DataModel(domain: '2016', measure: 0, color: kMainColorCharts),
  DataModel(domain: '2017', measure: 5, color: kMainColorCharts),
];

List<charts.Series<DataModel, String>> groupedData = [
  charts.Series<DataModel, String>(
    id: 'Desktop',
    domainFn: (DataModel sales, _) => sales.domain,
    measureFn: (DataModel sales, _) => sales.measure,
    colorFn: (DataModel sales, _) => sales.color,
    data: desktopSalesData,
  ),
  charts.Series<DataModel, String>(
    id: 'Tablet',
    domainFn: (DataModel sales, _) => sales.domain,
    measureFn: (DataModel sales, _) => sales.measure,
    colorFn: (DataModel sales, _) => sales.color,
    data: tableSalesData,
  ),
  charts.Series<DataModel, String>(
    id: 'Mobile',
    domainFn: (DataModel sales, _) => sales.domain,
    measureFn: (DataModel sales, _) => sales.measure,
    colorFn: (DataModel sales, _) => sales.color,
    data: mobileSalesData,
  ),
];
