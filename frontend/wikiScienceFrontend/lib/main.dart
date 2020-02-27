import 'package:flutter/material.dart';
import 'views/home/home_view.dart';

// Diese Funktion ist der Startpunkt in die Anwendung.
void main() => runApp(WikiScience());

// Diese Klasse wird von der main-Funktion aufgerufen.
// Sie stellt ein Grundgerüst für die Anwendung zur Verfügung,
// zusammen mit dem Titel 'WikiScience'.
// Diese Klasse zeigt die Klasse HomeView an, womit die eigentliche UI startet
class WikiScience extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'WikiScience',
      home: HomeView(),
    );
  }
}
