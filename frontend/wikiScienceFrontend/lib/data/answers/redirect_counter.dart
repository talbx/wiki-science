import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/animated_counter/animated_counter.dart';

class RedirectCounter extends StatelessWidget {
  final _counterMax = 221607;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Hier steht eine Erklärung über redirects'),
        SizedBox(height: 20),
        AnimatedCounter(_counterMax),
      ],
    );
  }
}
