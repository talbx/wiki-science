import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

// Diese Klasse stellt einen Rahmen für die Frage genau einer Frage zur Verfügung.
class Question extends StatelessWidget {
  // nimmt ein Icon entgegen, welches neben der Frage angezeigt werden soll
  final IconData icon;
  // nimmt einen String entgegen
  final String question;
  Question({this.question, this.icon});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 40,
      child: Column(
        children: <Widget>[
          Row(
            children: <Widget>[
              Icon(Icons.attach_file, color: kMainColor),
              SizedBox(width: 10),
              Text(
                question,
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: kMainColor),
              ),
              Spacer(),
              Icon(icon, color: kMainColor),
            ],
          ),
          SizedBox(height: 8),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: Divider(
              height: 1,
              color: kMainColor,
            ),
          )
        ],
      ),
    );
  }
}
