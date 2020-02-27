import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class Answer1 extends StatelessWidget {
  final List<charts.Series> data;
  Answer1(this.data);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      child: Column(
        children: <Widget>[
          Text('Hier sind meine Daten!'),
          Expanded(
            child: charts.BarChart(
              data,
              animate: true,
              barGroupingType: charts.BarGroupingType.grouped,
            ),
          ),
        ],
      ),
    );
  }
}
