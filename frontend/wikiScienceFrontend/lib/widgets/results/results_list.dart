import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/constants/constants.dart';
import 'package:wikiScienceFrontend/widgets/results/result_card.dart';

class ResultsList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        ResultCard(question: frage_1, answer: antwort_1),
        ResultCard(question: frage_2, answer: antwort_1),
        ResultCard(question: frage_3, answer: antwort_1),
        ResultCard(question: frage_4, answer: antwort_1),
        ResultCard(question: frage_5, answer: antwort_1),
        ResultCard(question: frage_1, answer: antwort_1),
        ResultCard(question: frage_2, answer: antwort_1),
        ResultCard(question: frage_3, answer: antwort_1),
        ResultCard(question: frage_4, answer: antwort_1),
        ResultCard(question: frage_5, answer: antwort_1),
      ],
    );
  }
}
