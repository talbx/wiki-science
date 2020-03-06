import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer4 extends StatelessWidget {
  final _widgetList = [
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
            'Anzahl der am häufigsten verwendeten Wörter in den Titeln aller Artikel '),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/topics/topicsBars.JPG',
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
