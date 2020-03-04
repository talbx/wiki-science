import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/centered_view/centered_view.dart';
import 'package:wikiScienceFrontend/widgets/project_details/project_details.dart';
import 'package:wikiScienceFrontend/widgets/results/results_list.dart';
import 'package:wikiScienceFrontend/widgets/title_bar/title_bar.dart';

// die Anwendung ist eine Single-View Application
// die HomeView Klasse baut dieses Fenster auf und gibt es zurück
class HomeView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: CustomScrollView(
        slivers: <Widget>[
          // der SliverPersistentHeader ist die Titelleiste
          SliverPersistentHeader(
            floating: false,
            pinned: true,
            delegate: TitleBar(
              minExtent: 100,
              maxExtent: 500,
            ),
          ),
          // die SliverList zeigt den Hauptteil in Form einer Liste an
          SliverList(
            delegate: SliverChildListDelegate(
              [
                CenteredView(
                  child: Column(
                    children: <Widget>[
                      SizedBox(height: 150),
                      // eine Übersicht über unser Projekt
                      ProjectDetails(),
                      SizedBox(height: 150),
                      // eine Liste über die Analysefragen, mit entsprechendem Resultat
                      ResultsList(),
                      SizedBox(height: 300),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
