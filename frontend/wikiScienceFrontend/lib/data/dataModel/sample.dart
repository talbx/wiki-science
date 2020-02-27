import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class Sample {
  final String year;
  final int income;
  final charts.Color color;

  Sample({@required this.year, @required this.income, this.color});
}
