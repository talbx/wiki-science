import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_contributors.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer2 extends StatelessWidget {
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
          'web/assets/images/contributors_10k/top10ktops.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributors_10k/top10kEU.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributors_10k/top10kworld.png',
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
