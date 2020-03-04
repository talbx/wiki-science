import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class DataModel {
  final String domain;
  final int measure;
  final charts.Color color;

  DataModel({@required this.domain, @required this.measure, this.color});
}
