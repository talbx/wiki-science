import 'package:flutter/material.dart';
import 'views/home/home_view.dart';
// import 'package:wikiScience/landing_page.dart';

void main() => runApp(WikiScience());

class WikiScience extends StatelessWidget {
  // Diese Klasse ist der Startpunkt der Anwendung
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'WikiScience',
      theme: ThemeData(
        textTheme: Theme.of(context).textTheme.apply(
          fontFamily: 'Open Sans'
        )
      ),
      home: HomeView(),
    );
  }
}