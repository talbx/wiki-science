import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

import 'package:wikiScienceFrontend/data/dataModel/sample.dart';
import 'package:wikiScienceFrontend/data/sampleData.dart';

class NetworkHelper {
  final String url;

  NetworkHelper({@required this.url});

  Future fetchData() async {
    http.Response response = await http.get(url);
    if (response.statusCode == 200) {
      String data = response.body;
      print(data);
      return jsonDecode(data);
    } else {
      print(response.statusCode);
    }
  }

  Future<List<Sample>> getData() async {
    List<Sample> data;
    print('vorher');
    var rawData = await fetchData();
    print(3);
    for (var _data in rawData) {
      data.add(
        Sample(domain: _data['title'], measure: _data['id']),
      );
    }
    return data;
  }
}
