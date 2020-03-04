import 'dart:io';

import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

class RedirectCounter extends StatefulWidget {
  @override
  _RedirectCounterState createState() => _RedirectCounterState();
}

class _RedirectCounterState extends State<RedirectCounter>
    with SingleTickerProviderStateMixin {
  int _counterMax = 221607;
  AnimationController _controller;
  Animation _animation;

  @override
  void initState() {
    super.initState();
    _controller =
        AnimationController(vsync: this, duration: Duration(seconds: 2));
    _animation = CurvedAnimation(parent: _controller, curve: Curves.easeInExpo);
    _controller.forward();
    _controller.addListener(() {
      setState(() {});
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text('Hier steht eine Erklärung über redirects'),
        SizedBox(height: 20),
        Center(
          child: AnimatedContainer(
            child: Text(
              (_counterMax * _animation.value).floorToDouble().toString(),
              style: TextStyle(
                  fontSize: 60, fontWeight: FontWeight.w900, color: kMainColor),
            ),
            duration: Duration(seconds: 50),
          ),
        ),
      ],
    );
  }
}
