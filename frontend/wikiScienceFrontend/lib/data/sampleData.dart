import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'dataModel/sample.dart';

final List<Sample> data = [
  Sample(year: '2008', income: 10000),
  Sample(year: '2009', income: 12500),
  Sample(year: '2010', income: 15000),
  Sample(year: '2001', income: 22500),
  Sample(year: '2002', income: 28000),
  Sample(year: '2003', income: 38000),
  Sample(year: '2004', income: 49000),
  Sample(year: '2005', income: 85000),
];

final desktopSalesData = [
  Sample(year: '2014', income: 5),
  Sample(year: '2015', income: 25),
  Sample(year: '2016', income: 100),
  Sample(year: '2017', income: 75),
];

final tableSalesData = [
  Sample(year: '2014', income: 25),
  Sample(year: '2015', income: 50),
  Sample(year: '2016', income: 10),
  Sample(year: '2017', income: 20),
];

final mobileSalesData = [
  Sample(year: '2014', income: 0),
  Sample(year: '2015', income: 5),
  Sample(year: '2016', income: 0),
  Sample(year: '2017', income: 5),
];

List<charts.Series<Sample, String>> groupedData = [
  charts.Series<Sample, String>(
    id: 'Desktop',
    domainFn: (Sample sales, _) => sales.year,
    measureFn: (Sample sales, _) => sales.income,
    data: desktopSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Tablet',
    domainFn: (Sample sales, _) => sales.year,
    measureFn: (Sample sales, _) => sales.income,
    data: tableSalesData,
  ),
  charts.Series<Sample, String>(
    id: 'Mobile',
    domainFn: (Sample sales, _) => sales.year,
    measureFn: (Sample sales, _) => sales.income,
    data: mobileSalesData,
  ),
];
