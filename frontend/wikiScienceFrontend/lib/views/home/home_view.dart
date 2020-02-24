import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/centered_view/centered_view.dart';
import 'package:wikiScienceFrontend/widgets/navigation_bar/navigation_bar.dart';
import 'package:wikiScienceFrontend/widgets/project_details/project_details.dart';
import 'package:wikiScienceFrontend/widgets/results/results_list.dart';

class HomeView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: CenteredView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            NavigationBar(),
            Expanded(
              child: ListView(
                children: <Widget>[
                  SizedBox(height: 150),
                  ProjectDetails(),
                  SizedBox(height: 150),
                  ResultsList(),
                  SizedBox(height: 300),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
