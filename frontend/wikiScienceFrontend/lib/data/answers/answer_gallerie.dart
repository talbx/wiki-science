import 'package:flutter/material.dart';

class AnswerGallerie extends StatefulWidget {
  @override
  _AnswerGallerieState createState() => _AnswerGallerieState();
}

class _AnswerGallerieState extends State<AnswerGallerie> {
  int _imageIndex = 0;
  final images = [
    Image.asset(
      'web/assets/images/answerGallerie/picture1.png',
      fit: BoxFit.contain,
    ),
    Image.asset(
      'web/assets/images/answerGallerie/picture2.png',
      fit: BoxFit.contain,
    ),
    Image.asset(
      'web/assets/images/answerGallerie/picture3.png',
      fit: BoxFit.contain,
    ),
  ];

  @override
  Widget build(BuildContext context) {
    return Row(
      children: <Widget>[
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex > 0) ? _imageIndex-- : _imageIndex = images.length-1;
            });
          },
          child: Container(height: 20, width: 20, color: Colors.blue),
        ),
        Container(height: 500, width: 800, child: images[_imageIndex]),
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex < images.length-1) ? _imageIndex++ : _imageIndex = 0;
            });
          },
          child: Container(height: 20, width: 20, color: Colors.blue),
        ),
      ],
    );
  }
}
