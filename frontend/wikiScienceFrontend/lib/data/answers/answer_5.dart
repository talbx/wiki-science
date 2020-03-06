import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/funfacts/article_counts.dart';
import 'package:wikiScienceFrontend/widgets/gallery/gallery.dart';

class Answer5 extends StatelessWidget {
  final _widgetList = [
    ArticleCounts(url: 'wordCount', description: 'word count'),
    ArticleCounts(url: 'totalArticleCount', description: 'total article Count '),
    ArticleCounts(url: 'redirects', description: 'redirects'),
    ArticleCounts(url: 'realArticleCount', description: 'real article count'),
  ];

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Gallery(_widgetList),
    );
  }
}
