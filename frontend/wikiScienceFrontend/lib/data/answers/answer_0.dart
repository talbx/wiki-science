import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:wikiScienceFrontend/data/dataModel/sample.dart';

class Answer0 extends StatelessWidget {
  final List<Sample> data;
  Answer0(this.data);

  @override
  Widget build(BuildContext context) {
    List<charts.Series<Sample, String>> series = [
      charts.Series(
        id: 'Income',
        data: data,
        domainFn: (Sample series, _) => series.year,
        measureFn: (Sample series, _) => series.income,
      )
    ];

    return Container(
      height: 400,
      child: Column(
        children: <Widget>[
          Text('My personal income!'),
          Expanded(
            child: charts.BarChart(
              series,
              animate: true,
            ),
          )
        ],
      ),
    );
  }
}
