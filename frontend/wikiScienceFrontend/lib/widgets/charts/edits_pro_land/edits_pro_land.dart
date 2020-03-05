import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:wikiScienceFrontend/data/dataModel/dataModel.dart';
import 'package:charts_flutter/flutter.dart' as charts;

class EditsProLand extends StatefulWidget {
  @override
  _EditsProLandState createState() => _EditsProLandState();
}

class _EditsProLandState extends State<EditsProLand> {
  Future<List<DataModel>> _getData() async {
    var empData = await http
        .get('http://basecamp-demos.informatik.uni-hamburg.de:8080/wiki-scicence-backend-1.0.1.RELEASE//api/contributors/contributionsPerCountry');
    var jsonData = json.decode(empData.body);
    List<DataModel> data = [];
    for (var countryData in jsonData) {
      DataModel _data =
          DataModel(domain: countryData["country"], measure: countryData["count"]);
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
              List<charts.Series<DataModel, String>> series = [
                charts.Series(
                  id: 'contributionsPerCountry',
                  data: snapshot.data,
                  domainFn: (DataModel series, _) => series.domain,
                  measureFn: (DataModel series, _) => series.measure,
                )
              ];
              return Container(
                height: 400,
                child: charts.PieChart(
                  series,
                  animate: true,
                  defaultRenderer: charts.ArcRendererConfig(
                    arcWidth: 100,
                    arcRendererDecorators: [
                      new charts.ArcLabelDecorator()
                    ],
                  ),
                ),
              );
            }
          }),
    );
  }
}
