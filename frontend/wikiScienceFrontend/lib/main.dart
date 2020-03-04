import 'package:flutter/material.dart';
import 'views/home/home_view.dart';

// hier ist der Startpunkt in die Anwendung
void main() => runApp(WikiScience());

// das ist die eigentliche Applikation 
class WikiScience extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'WikiScience.',
      home: HomeView(),
    );
  }
}
