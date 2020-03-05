import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

class AnimatedCounter extends StatefulWidget {
  final int counterMax;
  AnimatedCounter(this.counterMax);
  @override
  _AnimatedCounterState createState() => _AnimatedCounterState();
}

class _AnimatedCounterState extends State<AnimatedCounter>
    with SingleTickerProviderStateMixin {
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
  void dispose() {
    // TODO: implement dispose
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        child: Text(
          (widget.counterMax * _animation.value).floorToDouble().toString(),
          style: TextStyle(
              fontSize: 60, fontWeight: FontWeight.w900, color: kMainColor),
        ),
      ),
    );
  }
}
