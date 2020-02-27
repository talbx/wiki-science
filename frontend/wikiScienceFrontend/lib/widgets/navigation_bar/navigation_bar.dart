import 'package:flutter/material.dart';

// Die NavigationBar Klasse stellt eine Leiste mit möglichen Widgets zur Verfügung.
// In unserem brauchen wir nur den Titel.
class NavigationBar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text('WikiScience.',
        style: TextStyle(fontWeight: FontWeight.w900, fontSize: 80));
  }
}
