import 'package:flutter/material.dart';

// Die CenteredView Klasse nimmt im Konstruktor ein Widget 'child' entgegen
// und sorgt dafür, dass die Anwendung gewisse Constraints einhält.
// Das Child Widget ist der Inhalt der CenteredView.
// Die CenteredView hält zum linken und rechten Rand des Bildschirms einen minimalen Abstand von 70 Pixeln,
// und zum oberen Rand immer einen Abstand von 30 Pixeln,
// zum unteren Rand wird kein Abstand gehalten.
// Die CenteredView hat eine maximale Breite von 1200 Pixeln, um die Übersicht zu bewahren.
class CenteredView extends StatelessWidget {
  // Klassenparameter child vom Typ Widget
  // nimmt ein beliebiges Widget entgegen und zeigt es in der View an
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
