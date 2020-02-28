import 'package:flutter/material.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:wikiScienceFrontend/data/dataModel/sample.dart';
import 'package:wikiScienceFrontend/networking/networking.dart';

class Answer0 extends StatefulWidget {
  @override
  _Answer0State createState() => _Answer0State();
}

class _Answer0State extends State<Answer0> {
  List<Sample> data;

  @override
  void initState() {
    super.initState();
    print(1);
    getData();
    print(2);
  }

  void getData() async {
    NetworkHelper networkHelper = NetworkHelper(url:'https://jsonplaceholder.typicode.com/todos/1');
    data = await networkHelper.getData();
    print(5);
  }

  @override
  Widget build(BuildContext context) {
    List<charts.Series<Sample, String>> series = [
      charts.Series(
        id: 'Income',
        data: data,
        domainFn: (Sample series, _) => series.domain,
        measureFn: (Sample series, _) => series.measure,
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
