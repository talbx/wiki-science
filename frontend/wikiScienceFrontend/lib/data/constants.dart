import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/answers/answer_contributors.dart';
import 'package:wikiScienceFrontend/data/answers/answer_gallerie.dart';
import 'package:wikiScienceFrontend/data/answers/redirect_counter.dart';
import 'package:wikiScienceFrontend/data/sampleData.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'answers/answer_3.dart';
import 'answers/answer_4.dart';

// In diesem Dokument werden notwendige Konstanten und Informationen gespeichert.
// Die Klassen und Widgets können die Informationen direkt von hier abgreifen.

final kMainColor = Colors.grey.shade900;
final kMainColorCharts = charts.ColorUtil.fromDartColor(Colors.grey.shade700);

const url = 'http://basecamp-demos.informatik.uni-hamburg.de:8080/wiki-scicence-backend-1.0.0.RELEASE';

// Hier sind die Analysefragen gespeichert.
final questions = const {
  0: 'dynamische Dateneinbindung',
  1: 'Anzahl der Bearbeitungen pro Autor, zwischen 2002 und 2020',
  2: 'Anzahl der Verlinkungen in Artikeln, zwischen 2002 und 2020',
  3: 'Bild',
  4: 'erste Frage',
  5: 'erste Frage',
  6: 'erste Frage',
};

// Hier sind die jeweiligen Resultate gespeichert.
final answers = {
  0: AnswerContributors(),
  1: AnswerGallerie(),
  2: RedirectCounter(),
  3: Answer3(),
  4: Answer4(groupedData),
  5: Answer3(),
  6: Answer4(groupedData),
};
