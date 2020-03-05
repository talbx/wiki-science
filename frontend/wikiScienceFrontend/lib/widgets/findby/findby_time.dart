import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
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
        .get('http://basecamp-demos.informatik.uni-hamburg.de:8080/wiki-scicence-backend-1.0.1.RELEASE//api/contributors/findByTime/$time');
    var jsonData = json.decode(empData.body);
    return jsonData;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          DropdownButton<String>(
            value: time,
            icon: Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            style: TextStyle(color: Colors.deepPurple),
            underline: Container(
              height: 2,
              color: Colors.deepPurpleAccent,
            ),
            onChanged: (String newValue) {
              setState(() {
                time = newValue;
              });
            },
            items: <String>[
              '00',
              '01',
              '02',
              '03',
              '04',
              '05',
              '06',
              '07',
              '08',
              '09',
              '10',
              '11',
              '12',
              '13',
              '14',
              '15',
              '16',
              '17',
              '18',
              '19',
              '20',
              '21',
              '22',
              '23',
              '24'
            ].map<DropdownMenuItem<String>>((String value) {
              return DropdownMenuItem<String>(
                value: value,
                child: Text(value),
              );
            }).toList(),
          ),
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
