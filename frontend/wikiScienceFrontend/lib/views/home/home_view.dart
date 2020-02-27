import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/centered_view/centered_view.dart';
import 'package:wikiScienceFrontend/widgets/navigation_bar/navigation_bar.dart';
import 'package:wikiScienceFrontend/widgets/project_details/project_details.dart';
import 'package:wikiScienceFrontend/widgets/results/results_list.dart';

// Die HomeView Klasse stellt den Generellen Aufbau der Anwendung zusammen.
// Der Inhalt wird in einem CenteredView angezeigt.
// Die einzelnen Widgets werden übereinander in einem Column aufgebaut
class HomeView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Scaffold stellt ein fertiges Grundgerüst für die Anwendung zur Verfügung
    return Scaffold(
      backgroundColor: Colors.blueGrey[10],
      body: CenteredView(
        // in diesem Column werden alle UI-Elemente der Anwendung angeordnet
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            // die NavigationBar zeigt bei uns nur den Titel an, eine Navigation ist nicht vorgesehen
            NavigationBar(),
            // das Expanded Widget nimmt den restlichen Platz der Anwendung ein
            Expanded(
              child: ListView(
                children: <Widget>[
                  SizedBox(height: 150),
                  // eine Übersicht über unser Projekt
                  ProjectDetails(),
                  SizedBox(height: 150),
                  // eine Liste über die Analysefragen, mit entsprechendem Resultat
                  ResultsList(),
                  SizedBox(height: 300),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
