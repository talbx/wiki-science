import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_0.dart';
import 'package:wikiScienceFrontend/data/answers/answer_1.dart';
import 'package:wikiScienceFrontend/data/answers/answer_2.dart';
import 'package:wikiScienceFrontend/data/sampleData.dart';

import 'answers/answer_3.dart';
import 'answers/answer_4.dart';

// In diesem Dokument werden notwendige Konstanten und Informationen gespeichert.
// Die Klassen und Widgets können die Informationen direkt von hier abgreifen.

// Dieser String gibt eine kurze Einleitung und eine Übersicht in das Projekt.
// Der Text wird wir ganz oben auf der Anwendung angezeigt.
const unser_vorhaben =
    'Die Online-Enzyklopädie Wikipedia ist aktuell auf Platz 5 der meist besuchten Webseiten und gilt mit über 6 Millionen Artikeln als die größte Wissenssammlung weltweit. Welche Schlüsse lassen sich ziehen, wenn man diese gewaltige Datenmenge mit modernster Analysesoftware genauer unter die Lupe nimmt? Im Rahmen des Projekts WikiScience stellten wir uns dieser Herausforderung und kam zu verblüffenden Ergebnissen.';

// Hier sind die Analysefragen gespeichert.
final questions = const {
  0: 'erste Frage',
  1: 'zweite Frage',
  2: 'dritte Frage',
  3: 'vierte Frage',
  4: 'erste Frage',
  5: 'erste Frage',
  6: 'erste Frage',
  7: 'erste Frage',
  8: 'erste Frage',
  9: 'erste Frage',
  10: 'die Anzahl aller Wörter in allen Artikeln',
};

// Hier sind die jeweiligen Resultate gespeichert.
final answers = {
  0: Answer0(data),
  1: Answer1(groupedData),
  2: Answer2(groupedData),
  3: Answer3(groupedData),
  4: Answer4(groupedData),
  5: Answer1(groupedData),
  6: Answer0(data),
  7: Answer1(groupedData),
  8: Answer1(groupedData),
  9: Answer0(data),
  10: Answer1(groupedData),
};
