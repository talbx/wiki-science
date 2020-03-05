import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_contributors.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer3 extends StatelessWidget {
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
          'web/assets/images/contributions_10k/contributionsPerCountryBar.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
        SizedBox(height: 16),
        Image.asset(
          'web/assets/images/contributions_10k/contributionsPerCountryEU.png',
          fit: BoxFit.contain,
        ),
      ],
    ),
    Column(
      children: <Widget>[
        Text('data'),
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