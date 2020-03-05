import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_contributors.dart';
import 'package:wikiScienceFrontend/widgets/animated_counter/animated_counter.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer5 extends StatelessWidget {
  final _widgetList = [
    Column(
      children: <Widget>[
        Text('Hier ist ein Beispiel'),
        SizedBox(height: 16),
        AnimatedCounter(123456),
      ],
    ),
    Column(
      children: <Widget>[
        Text('Hier ist ein ANDERES Beispiel'),
        SizedBox(height: 16),
        AnimatedCounter(123456),
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
