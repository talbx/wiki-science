import 'package:flutter/material.dart';

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
      height: 20,
      child: Row(
        children: <Widget>[
          Icon(Icons.attach_file),
          SizedBox(width: 10),
          Text(
            question,
            style: Theme.of(context).textTheme.subtitle1,
            // TextStyle(
            //   fontWeight: FontWeight.w300,
            // ),
          ),
          Spacer(),
          Icon(icon),
        ],
      ),
    );
  }
}
