package org.unihh.basecamp.g4.wiki;

import org.apache.hadoop.io.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.unihh.basecamp.g4.wiki.jobs.NodeBuilder;

@RunWith(MockitoJUnitRunner.class)
public class NodeBuilderTest {

    String x = "<page>\n" +
            "  <title>Armonium</title>\n" +
            "  <id>2</id>\n" +
            "  <timestamp>2008-06-22T21:48:55Z</timestamp>\n" +
            "  <username>Nemo bis</username>\n" +
            "  <comment>italiano</comment>\n" +
            "  <text xml:space=\"preserve\">[[Immagine:Harmonium2.jpg|thumb|right|300 px]]\n" +
            "  \n" +
            "  L''''armonium'''' (in francese, ''harmonium'') è uno [[strumenti musicali|\n" +
            "  strumento musicale]] azionato con una [[tastiera (musica)|tastiera]], detta\n" +
            "  manuale. Sono stati costruiti anche alcuni armonium con due manuali.\n" +
            "  \n" +
            "  ==Armonium occidentale==\n" +
            "  Come l'[[organo (musica)|organo]], l'armonium è utilizzato tipicamente in\n" +
            "  [[chiesa (architettura)|chiesa]], per l'esecuzione di [[musica sacra]], ed è\n" +
            "  fornito di pochi registri, quando addirittura in certi casi non ne possiede\n" +
            "  nemmeno uno: il suo [[timbro (musica)|timbro]] è molto meno ricco di quello\n" +
            "  organistico e così pure la sua estensione.\n" +
            "  \n" +
            "  ...\n" +
            "  \n" +
            "  ==Armonium indiano==\n" +
            "  {{S sezione}}\n" +
            "  \n" +
            "  == Voci correlate ==\n" +
            "  *[[Musica]]\n" +
            "  *[[Generi musicali]]</text>\n" +
            "</page>";

    @Test
    public void test(){
        NodeBuilder nodeBuilder = new NodeBuilder();
        nodeBuilder.apply(new Text(x));
    }
}
