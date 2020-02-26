package org.unihh.basecamp.g4.wiki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.unihh.basecamp.g4.wiki.jobs.mostEditedArticles.MostEditedArticlesMapper;
import org.w3c.dom.Node;

@RunWith(MockitoJUnitRunner.class)
public class MEMTest {

    @Test
    public void test(){
        MostEditedArticlesMapper mapper = new MostEditedArticlesMapper();
    }
}
