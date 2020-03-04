import 'package:flutter/material.dart';

// die CenteredView Klasse packt den Inhalt der HomeView in eine ConstrainedBox
class CenteredView extends StatelessWidget {
  final Widget child;
  const CenteredView({this.child});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.fromLTRB(70, 30, 70, 0),
      alignment: Alignment.topCenter,
      child: ConstrainedBox(
        constraints: BoxConstraints(maxWidth: 1200),
        child: child,
      ),
    );
  }
}
