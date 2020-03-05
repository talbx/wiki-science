import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

// Dieser String gibt eine kurze Einleitung und eine Übersicht in das Projekt.
// Der Text wird wir ganz oben auf der Anwendung angezeigt.
const unser_vorhaben =
    'Die Online-Enzyklopädie Wikipedia ist aktuell auf Platz 5 der meist besuchten Webseiten und gilt mit über 6 Millionen Artikeln als die größte Wissenssammlung weltweit. Welche Schlüsse lassen sich ziehen, wenn man diese gewaltige Datenmenge mit modernster Analysesoftware genauer unter die Lupe nimmt? Im Rahmen des Projekts WikiScience stellten wir uns dieser Herausforderung und kam zu erschaunlichen Ergebnissen.';

// diese Klasse gibt eine Übersicht über das Projekt
class ProjectDetails extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.maxFinite,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          SelectableText(
            'Unser Vorhaben',
            style: TextStyle(
                fontWeight: FontWeight.w300, fontSize: 50, color: kMainColor),
          ),
          SizedBox(
            height: 30,
          ),
          SelectableText(
            unser_vorhaben,
            style: TextStyle(fontSize: 21, height: 1.7, color: kMainColor),
          ),
        ],
      ),
    );
  }
}
