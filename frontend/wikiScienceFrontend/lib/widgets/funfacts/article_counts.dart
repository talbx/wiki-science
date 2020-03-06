import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:wikiScienceFrontend/widgets/animated_counter/animated_counter.dart';

class ArticleCounts extends StatefulWidget {
  final String url;
  final String description;

  ArticleCounts({@required this.url, @required this.description});

  @override
  _ArticleCountsState createState() => _ArticleCountsState();
}

class _ArticleCountsState extends State<ArticleCounts> {
  Future<int> _getData() async {
    var empData =
        await http.get('http://localhost:8080/api/articles/${widget.url}');
    var jsonData = json.decode(empData.body);
    return jsonData['amount'];
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          Text(widget.description),
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
            },
          ),
        ],
      ),
    );
  }
}
