import 'package:flutter/material.dart';

class Answer extends StatelessWidget {
  final Widget child;
  Answer({this.child});

  @override
  Widget build(BuildContext context) {
    return Container(height: 100, width: 100, child: child,);
  }
}
