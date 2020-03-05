import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_contributors.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer1 extends StatelessWidget {
  final _widgetList = [
    Column(
      children: <Widget>[
        Text('data'),
        SizedBox(height: 16),
        AnswerContributors(),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/article_length/sheet1.JPG',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
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
