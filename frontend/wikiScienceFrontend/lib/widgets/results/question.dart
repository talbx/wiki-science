import 'package:flutter/material.dart';

class Question extends StatelessWidget {
  final IconData icon;
  final String question;
  Question({this.question, this.icon});
  
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 20,
      child: Row(
        //mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Icon(Icons.attach_file),
          SizedBox(width: 10),
          Text(question, style: TextStyle(fontWeight: FontWeight.w300, )),
          Spacer(),
          Icon(icon),
        ],
      ),
    );
  }
}
