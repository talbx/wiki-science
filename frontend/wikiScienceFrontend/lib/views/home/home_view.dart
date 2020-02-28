import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/widgets/centered_view/centered_view.dart';
import 'package:wikiScienceFrontend/widgets/project_details/project_details.dart';
import 'package:wikiScienceFrontend/widgets/results/results_list.dart';
import 'package:wikiScienceFrontend/widgets/title_bar/title_bar.dart';

// Die HomeView Klasse stellt den Generellen Aufbau der Anwendung zusammen.
// Der Inhalt wird in einem CenteredView angezeigt.
// Die einzelnen Widgets werden übereinander in einem Column aufgebaut
class HomeView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Scaffold stellt ein fertiges Grundgerüst für die Anwendung zur Verfügung
    return Scaffold(
      backgroundColor: Colors.white,
      body: CustomScrollView(
        slivers: <Widget>[
          SliverAppBar(
            expandedHeight: 500,
            floating: false,
            pinned: true,
            snap: false,
            title: Text('WikiScience.', style: TextStyle(fontSize: 50, fontWeight: FontWeight.w900, color: Colors.black),),
            flexibleSpace: FlexibleSpaceBar(
              background: Image.asset('web/assets/images/ws_front.png', fit: BoxFit.cover,),
              // title: Text('WikiScience.',
              //     style: TextStyle(
              //         fontWeight: FontWeight.w900,
              //         // fontSize: 80,
              //         color: Colors.black)),
            ),
            backgroundColor: Colors.white,
            elevation: 0,
          ),
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
                )),
              ],
            ),
          ),
          // ),
          // )
        ],
      ),
    );
  }
}

// SliverAppBar(
//             expandedHeight: 500,
//             floating: false,
//             pinned: true,
//             snap: false,
//             // title: Text('WikiScience.'),
//             flexibleSpace: FlexibleSpaceBar(
//               title: Text('WikiScience.',
//                   style: TextStyle(
//                       fontWeight: FontWeight.w900,
//                       // fontSize: 80,
//                       color: Colors.black)),
//             ),
//             backgroundColor: Colors.white,
//             elevation: 0,
//           ),


// SliverPersistentHeader(
//             floating: false,
//             pinned: true,
//             delegate: TitleBar(
//               minExtent: 100,
//               maxExtent: 500,
//             ),
//           ),



// CenteredView(
//           // in diesem Column werden alle UI-Elemente der Anwendung angeordnet
//           child: Column(
//             crossAxisAlignment: CrossAxisAlignment.start,
//             children: <Widget>[
//               // die NavigationBar zeigt bei uns nur den Titel an, eine Navigation ist nicht vorgesehen
//               NavigationBar(),
//               // das Expanded Widget nimmt den restlichen Platz der Anwendung ein
//               Expanded(
//                 child: ListView(
//                   children: <Widget>[
//                     SizedBox(height: 150),
//                     // eine Übersicht über unser Projekt
//                     ProjectDetails(),
//                     SizedBox(height: 150),
//                     // eine Liste über die Analysefragen, mit entsprechendem Resultat
//                     ResultsList(),
//                     SizedBox(height: 300),
//                   ],
//                 ),
//               ),
//             ],
//           ),
//         ),
