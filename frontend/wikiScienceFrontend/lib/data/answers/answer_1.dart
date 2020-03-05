import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer1 extends StatelessWidget {
  final _widgetList = [
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Anzahl der Wörter in den längsten Artikeln'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/article_length/sheet1.JPG',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Die Größe und Farbintensität des Kreises spiegelt die Anzahl der Wörter in einem Artikel wieder'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/article_length/sheet2.png',
          height: 500,
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
