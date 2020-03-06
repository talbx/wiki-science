import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/funfacts/article_counts.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer5 extends StatelessWidget {
  final _widgetList = [
    ArticleCounts(
        url: 'wordCount',
        description: 'Die Anzahl aller unterschiedlichen Wörter'),
    ArticleCounts(
        url: 'redirects',
        description: 'Alle Artikel, die nur auf andere Artikel verweisen'),
    ArticleCounts(
        url: 'realArticleCount',
        description: 'Alle Artikel die keine \'Redirects\' sind'),
    ArticleCounts(
        url: 'totalArticleCount',
        description: 'Alle Artikel inklusive Redirects'),
  ];

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Gallery(_widgetList),
    );
  }
}
