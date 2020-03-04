import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';
import 'package:wikiScienceFrontend/widgets/column_builder/column_builder.dart';
import 'package:wikiScienceFrontend/widgets/results/result_card.dart';

// Die ResultsList-Klasse gibt ein Column mit ResultCard Objekten zurück
class ResultsList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ColumnBuilder(
      itemCount: questions.length,
      itemBuilder: (context, index) => ResultCard(question: questions[index], answer: answers[index]),
    );
  }
}
