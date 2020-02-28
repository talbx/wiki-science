import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter/src/rendering/sliver_persistent_header.dart';

class TitleBar implements SliverPersistentHeaderDelegate {
  TitleBar({
    this.minExtent,
    @required this.maxExtent,
  });
  final double minExtent;
  final double maxExtent;

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return Stack(
      fit: StackFit.expand,
      children: [
        Image.asset(
          'web/assets/images/ws_front.jpg',
          fit: BoxFit.cover,
        ),
        Container(
          // color: Colors.white,
          // decoration: BoxDecoration(
          //   gradient: LinearGradient(
          //     colors: [Colors.transparent, Colors.black54],
          //     stops: [0.5, 1.0],
          //     begin: Alignment.topCenter,
          //     end: Alignment.bottomCenter,
          //     tileMode: TileMode.repeated,
          //   ),
          // ),
        ),
        Positioned(
          left: 16.0,
          right: 16.0,
          bottom: 16.0,
          child: Text(
            'WikiScience.',
            style: TextStyle(
              fontWeight: FontWeight.w900,
              fontSize: 80,
            ), //color: Colors.black),
          ),
        ),
      ],
    );
  }

  double titleOpacity(double shrinkOffset) {
    // simple formula: fade out text as soon as shrinkOffset > 0
    return 1.0 - max(0.0, shrinkOffset) / maxExtent;
    // more complex formula: starts fading out text when shrinkOffset > minExtent
    //return 1.0 - max(0.0, (shrinkOffset - minExtent)) / (maxExtent - minExtent);
  }

  @override
  bool shouldRebuild(SliverPersistentHeaderDelegate oldDelegate) {
    return true;
  }

  @override
  FloatingHeaderSnapConfiguration get snapConfiguration => null;

  @override
  OverScrollHeaderStretchConfiguration get stretchConfiguration => null;
}
