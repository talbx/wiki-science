import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/charts/autoren_pro_land/autoren_pro_land.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer2 extends StatelessWidget {
  final _widgetList = [
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
            'Zu sehen sind die 100 aktivsten Wikipedia-Autoren, deren IP-Adresse verfügbar ist, verteilt auf ihre Länder'),
        SizedBox(height: 16),
        AutorenProLand(),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
            'Länder sortiert nach der Anzahl der darin lebenden Top 10.000 Nutzern, deren IP-Adresse verfügbar ist'),
        SizedBox(height: 16),
        ConstrainedBox(
          constraints: BoxConstraints(maxHeight: 500),
          child: Scrollbar(
            child: ListView(
              children: <Widget>[
                Image.asset(
                  'web/assets/images/contributors_10k/top10ktops.png',
                  fit: BoxFit.contain,
                ),
              ],
            ),
          ),
        ),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
            'Verteilung der aktivsten Nutzer weltweit, deren IP-Adresse verfügbar ist,'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributors_10k/top10kworld.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
            'Verteilung der aktivsten Nutzer weltweit, deren IP-Adresse verfügbar ist, mit Fokus auf Europa'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributors_10k/top10kEU.png',
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
