import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/charts/edits_pro_land/edits_pro_land.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer3 extends StatelessWidget {
  final _widgetList = [
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Zu sehen ist die Anzahl der Bearbeitungen der 100 aktivsten Wikipedia-Autoren, verteilt auf ihre Länder'),
        SizedBox(height: 16),
        EditsProLand(),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Länder sortiert nach der Anzahl an Beiträgen, die von den Top 10.000 Nutzern weltweit kommen'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributions_10k/contributionsPerCountryBar.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Verteilung Europa'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributions_10k/contributionsPerCountryEU.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Verteilung weltweit'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributions_10k/contributionsPerCountryWorld.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
  ];

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Gallery(_widgetList),
    );
  }
}