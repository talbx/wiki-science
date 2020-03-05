import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dart:convert';
import 'package:wikiScienceFrontend/widgets/animated_counter/animated_counter.dart';

class FindByYear extends StatefulWidget {
  @override
  _FindByYearState createState() => _FindByYearState();
}

class _FindByYearState extends State<FindByYear> {
  String year = '2002';
  Future<int> _getData() async {
    var empData = await http
        .get('http://localhost:8080/api/contributors/findByMoment/$year');
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
              Text('Die Anzahl der Bearbeitungen von Wikipedia-Artikeln, im Jahr '),
              DropdownButton<String>(
                value: year,
                elevation: 16,
                style: TextStyle(color: kMainColor),
                underline: Container(
                  height: 2,
                  color: kMainColor,
                ),
                onChanged: (String newValue) {
                  setState(() {
                    year = newValue;
                  });
                },
                items: kJahre.map<DropdownMenuItem<String>>((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
              ),
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
