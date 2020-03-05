import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_0.dart';
import 'package:wikiScienceFrontend/data/answers/answer_1.dart';
import 'package:wikiScienceFrontend/data/answers/answer_2.dart';
import 'package:wikiScienceFrontend/data/answers/answer_3.dart';
import 'package:wikiScienceFrontend/data/answers/answer_4.dart';
import 'package:wikiScienceFrontend/data/answers/answer_5.dart';
import 'package:charts_flutter/flutter.dart' as charts;

// In diesem Dokument werden notwendige Konstanten und Informationen gespeichert.
// Die Klassen und Widgets können die Informationen direkt von hier abgreifen.

final kMainColor = Colors.grey.shade900;
final kMainColorCharts = charts.ColorUtil.fromDartColor(Colors.grey.shade700);

const url =
    'http://basecamp-demos.informatik.uni-hamburg.de:8080/wiki-scicence-backend-1.0.0.RELEASE';

// Hier sind die Analysefragen gespeichert.
final questions = const {
  0: 'Edits pro Zeitpunkt',
  1: 'Längste Artikel',
  2: 'Länder mit meisten Autoren',
  3: 'Länder mit meisten Edits',
  4: 'Topics',
  5: 'Funfacts',
};

// Hier sind die jeweiligen Resultate gespeichert.
final answers = {
  0: Answer0(),
  1: Answer1(),
  2: Answer2(),
  3: Answer3(),
  4: Answer4(),
  5: Answer5(),
};
