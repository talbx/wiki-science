import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

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
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex > 0)
                  ? _imageIndex--
                  : _imageIndex = images.length - 1;
            });
          },
          child: Icon(Icons.arrow_back_ios, color: kMainColor, size: 50),
        ),
        ConstrainedBox(
          constraints: BoxConstraints(maxWidth: 900, maxHeight: 600),
          child: Expanded(
            child: images[_imageIndex],
          ),
        ),
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex < images.length - 1)
                  ? _imageIndex++
                  : _imageIndex = 0;
            });
          },
          child: Icon(Icons.arrow_forward_ios, color: kMainColor, size: 50),
        ),
      ],
    );
  }
}
