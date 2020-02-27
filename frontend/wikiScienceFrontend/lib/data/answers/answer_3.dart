import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class Answer3 extends StatelessWidget {
  final List<charts.Series> data;
  Answer3(this.data);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      child: Column(
        children: <Widget>[
          Text('My personal income!'),
          Expanded(
            child: charts.BarChart(
              data,
              animate: true,
              barGroupingType: charts.BarGroupingType.grouped,
              defaultInteractions: false,
              vertical: false,
            ),
          )
        ],
      ),
    );
  }
}
