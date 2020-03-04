import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dart:convert';

import 'package:wikiScienceFrontend/data/dataModel/dataModel.dart';
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

  Future<List<DataModel>> getData() async {
    List<DataModel> data;
    var rawData = await fetchData();
    for (var _data in rawData) {
      data.add(
        DataModel(domain: _data['title'], measure: _data['id'], color: kMainColorCharts),
      );
    }
    return data;
  }
}
