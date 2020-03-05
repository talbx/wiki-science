import 'package:flutter/material.dart';

// Diese Klasse stellt einen Rahmen für das Resultat genau einer Frage zur Verfügung.
class Answer extends StatelessWidget {
  final Widget child;
  Answer({this.child});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 40, vertical: 32),
      child: child,
    );
  }
}
