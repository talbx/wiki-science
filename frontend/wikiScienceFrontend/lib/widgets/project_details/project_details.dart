import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

// Diese Klasse gibt eine Übersicht über das Projekt
class ProjectDetails extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.maxFinite,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Text(
            'Unser Vorhaben',
            style: TextStyle(fontWeight: FontWeight.w300, fontSize: 50, color: kMainColor),
          ),
          SizedBox(
            height: 30,
          ),
          Text(
            unser_vorhaben,
            style: TextStyle(fontSize: 21, height: 1.7, color: kMainColor),
          ),
        ],
      ),
    );
  }
}
