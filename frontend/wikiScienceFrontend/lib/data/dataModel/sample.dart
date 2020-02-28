import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class Sample {
  final String domain;
  final int measure;
  final charts.Color color;

  Sample({@required this.domain, @required this.measure, this.color});
}
