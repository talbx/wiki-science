import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:wikiScienceFrontend/data/dataModel/sample.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class Answer9 extends StatefulWidget {
  @override
  _Answer0State createState() => _Answer0State();
}

class _Answer0State extends State<Answer9> {
  Future<List<Sample>> _getData() async {
    var empData = await http.get('http://localhost:8080/api/misc/topCategories');
    var jsonData = json.decode(empData.body);
    List<Sample> data = [];
    for (var x in jsonData) {
      Sample _data = Sample(domain: x['name'], measure: x['amount']);
      data.add(_data);
    }
    return data;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: FutureBuilder(
          future: _getData(),
          builder: (BuildContext context, AsyncSnapshot snapshot) {
            if (snapshot.data == null) {
              return Container(
                width: double.maxFinite,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
                    CircularProgressIndicator(),
                    Text("Loading..."),
                  ],
                ),
              );
            } else {
              List<charts.Series<Sample, String>> series = [
                charts.Series(
                  id: 'Income',
                  data: snapshot.data,
                  domainFn: (Sample series, _) => series.domain,
                  measureFn: (Sample series, _) => series.measure,
                )
              ];
              return Container(
                height: 400,
                child: Column(
                  children: <Widget>[
                    Text('Mitarbeiter IDs'),
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
          }),
    );
  }
}
