import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/results/answer.dart';
import 'package:wikiScienceFrontend/widgets/results/question.dart';

// Diese ResultCard Klasse nimm eine Frage und eine Antwort entgegen
// und stellt einen Rahmen für genau ein Ergebnis zur Verfügung.
// Die ResultCard besteht aus einer Spalte mit zwei Elementen,
// der Frage, welche immer angezeigt wird
// und die Antwort, welche nur durch antippen entfaltet wird

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
    // GestureDetector erkennt, ob ein Nutzer mit der Anwendung interagiert
    return GestureDetector(
      // wenn die ResultCard angetippt wird, wird die _showAnswer Variable
      // negiert und der Status der Anwendung aktualisiert
      onTap: () => setState(() {
        _showAnswer = !_showAnswer;
      }),
      child: Card(
        color: Colors.white24,
        margin: EdgeInsets.symmetric(vertical: 16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            SizedBox(height: 10),
            // ein Question Objekt, zeigt immer die Frage an
            Question(
                question: widget.question,
                icon: _showAnswer ? dropUp : dropDown),
            // die Antwort wird nur angezeigt, wenn die _showAnswer Variable mit true belegt ist
            // ansonsten wird ein leeres Widget ohne ausdehnung angezeigt
            _showAnswer ? Answer(child: widget.answer) : SizedBox(),
            SizedBox(height: 10),
          ],
        ),
      ),
    );
  }
}
