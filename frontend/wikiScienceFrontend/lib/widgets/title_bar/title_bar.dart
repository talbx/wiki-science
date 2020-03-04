import 'package:flutter/material.dart';
import 'package:flutter/src/rendering/sliver_persistent_header.dart';
import 'package:wikiScienceFrontend/data/constants.dart';
import 'dart:math';

// TitleBar Klasse gibt die Titelleiste zurück
class TitleBar implements SliverPersistentHeaderDelegate {
  final double minExtent;
  final double maxExtent;

  TitleBar({
    this.minExtent,
    @required this.maxExtent,
  });

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return Container(
      color: kMainColor,
      child: Stack(
        fit: StackFit.expand,
        children: [
          Opacity(
            opacity: (shrinkOffset < (0.75 * maxExtent))
                ? imageOpacity(shrinkOffset)
                : 0,
            child: Image.asset(
              'web/assets/images/ws_front.png',
              fit: BoxFit.cover,
            ),
          ),
          Positioned(
            top: 16.0,
            left: 16.0,
            right: 16.0,
            child: Opacity(
              opacity: (shrinkOffset > (0.75 * maxExtent)) ? 1 : 0,
              child: Row(
                children: <Widget>[
                  SizedBox(width: 16),
                  Image.asset(
                    'web/assets/images/ws_logo.png',
                    width: 70,
                    height: 70,
                  ),
                  SizedBox(width: 8),
                  Text(
                    'WikiScience.',
                    style: TextStyle(
                      fontWeight: FontWeight.w900,
                      fontSize: 60,
                      color: Colors.white,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  double imageOpacity(double shrinkOffset) {
    // simple formula: fade out image as soon as shrinkOffset > 0
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
