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

const url = 'http://localhost:8080';

// Hier sind die Analysefragen gespeichert.
final questions = const {
  0: 'Letzte Bearbeitungen von Autoren',
  1: 'Längste Artikel',
  2: 'Länder mit den aktivsten Autoren',
  3: 'Länder mit den meisten Bearbeitungen',
  4: 'Wörter mit meistem Vorkommen in Wikipedia-Artikel Titeln',
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

// ab hier liegen Hilfsdaten
const kUhrzeiten = <String>[
  '00',
  '01',
  '02',
  '03',
  '04',
  '05',
  '06',
  '07',
  '08',
  '09',
  '10',
  '11',
  '12',
  '13',
  '14',
  '15',
  '16',
  '17',
  '18',
  '19',
  '20',
  '21',
  '22',
  '23',
  '24'
];

const kMonate = <String>[
  '01',
  '02',
  '03',
  '04',
  '05',
  '06',
  '07',
  '08',
  '09',
  '10',
  '11',
  '12'
];

const kJahre = <String>[
  '2002',
  '2003',
  '2004',
  '2005',
  '2006',
  '2007',
  '2008',
  '2009',
  '2010',
  '2011',
  '2012',
  '2013',
  '2014',
  '2015',
  '2016',
  '2017',
  '2018',
  '2019',
  '2020'
];
