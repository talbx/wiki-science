import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/results/answer.dart';
import 'package:wikiScienceFrontend/widgets/results/question.dart';


/*
Diese Klasse stellt einen Rahmen
für genau ein Ergebnis zur Verfügung.
Die Rahmen besteht aus einer Spalte mit zwei Elementen,
der Frage, welche immer angezeigt wird
und die Antwort, welche nur durch antippen entfaltet wird
 */

class ResultCard extends StatefulWidget {
  final String question;
  final Widget answer;
  ResultCard({this.question, this.answer});

  @override
  _ResultCardState createState() => _ResultCardState();
}

class _ResultCardState extends State<ResultCard> {
  bool _showAnswer = false;
  IconData dropDown = Icons.arrow_drop_down;
  IconData dropUp = Icons.arrow_drop_up;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => setState(() {
        _showAnswer = !_showAnswer;
      }),
      child: Card(
        margin: EdgeInsets.symmetric(vertical: 10),
        child: Column(
          children: <Widget>[
            SizedBox(height: 10),
            Question(question: widget.question, icon: _showAnswer? dropUp : dropDown),
            _showAnswer ? Answer(child: widget.answer) : SizedBox(),
            SizedBox(height: 10),
          ],
        ),
      ),
    );
  }
}
