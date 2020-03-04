import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class AnswerGallerie extends StatefulWidget {
  @override
  _AnswerGallerieState createState() => _AnswerGallerieState();
}

class _AnswerGallerieState extends State<AnswerGallerie> {
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
    return Container(
      child: Gallery(widgetList: images),
    );
  }
}
