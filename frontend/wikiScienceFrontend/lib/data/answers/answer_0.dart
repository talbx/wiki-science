import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/findby/findby_time.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer0 extends StatelessWidget {
  final _widgetList = [
    FindByTime(),
  ];

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Gallery(_widgetList),
    );
  }
}