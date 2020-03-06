import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dart:convert';
import 'package:wikiScienceFrontend/widgets/animated_counter/animated_counter.dart';

class FindByTime extends StatefulWidget {
  @override
  _FindByTimeState createState() => _FindByTimeState();
}

class _FindByTimeState extends State<FindByTime> {
  String time = '00';
  Future<int> _getData() async {
    var empData = await http
        .get('http://localhost:8080/api/contributors/findByTime/$time');
    var jsonData = json.decode(empData.body);
    return jsonData;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Text('Die Anzahl der Wikipedia-Autoren, die ihr letzte Bearbeitung um '),
              DropdownButton<String>(
                value: time,
                elevation: 16,
                style: TextStyle(color: kMainColor),
                underline: Container(
                  height: 2,
                  color: kMainColor,
                ),
                onChanged: (String newValue) {
                  setState(() {
                    time = newValue;
                  });
                },
                items: kUhrzeiten.map<DropdownMenuItem<String>>((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
              ),
              Text(' Uhr gemacht haben:'),
            ],
          ),
          SizedBox(height: 32),
          FutureBuilder(
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
                  return AnimatedCounter(snapshot.data);
                }
              }),
        ],
      ),
    );
  }
}
