import 'package:flutter/material.dart';
import 'package:wikiScienceFrontend/data/constants.dart';

class Gallery extends StatefulWidget {
  final List<Widget> widgetList;
  Gallery({@required this.widgetList});

  @override
  _GalleryState createState() => _GalleryState();
}

class _GalleryState extends State<Gallery> {
  int _imageIndex = 0;
  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex > 0)
                  ? _imageIndex--
                  : _imageIndex = widget.widgetList.length - 1;
            });
          },
          child: Icon(Icons.arrow_back_ios, color: kMainColor, size: 50),
        ),
        ConstrainedBox(
          constraints: BoxConstraints(maxWidth: 900, maxHeight: 600),
          child: widget.widgetList[_imageIndex],
        ),
        FlatButton(
          onPressed: () {
            setState(() {
              (_imageIndex < widget.widgetList.length - 1)
                  ? _imageIndex++
                  : _imageIndex = 0;
            });
          },
          child: Icon(Icons.arrow_forward_ios, color: kMainColor, size: 50),
        ),
      ],
    );
  }
}
