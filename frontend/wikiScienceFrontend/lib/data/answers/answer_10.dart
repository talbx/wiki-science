import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'dart:html';

class Answer2 extends StatelessWidget {
  final List<charts.Series> data;
  Answer2(this.data);

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
              barGroupingType: charts.BarGroupingType.groupedStacked,
              defaultInteractions: false,
            ),
          )
        ],
      ),
    );
  }
}
