package org.unihh.basecamp.g4.wiki;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONRealArticleCount.JSONRealArticleCountJob;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(MockitoJUnitRunner.class)
public class JobFactoryTest {

    @Test
    public void shouldReturnJob() {
        JobFactory factory = new JobFactory();
        String sample = "word-count";
        WikiJob wikiJob = factory.apply(sample);
        Assertions.assertThat(wikiJob).isNotNull();
        Assertions.assertThat(wikiJob.getName()).isEqualTo(sample);

        WikiJob job = new JSONRealArticleCountJob();
        job.getName();
    }

    @Test
    public void should_fail() {
        JobFactory factory = new JobFactory();
        String sample = "sample";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> factory.apply(sample))
                .withMessageContaining("job could not be found");
    }
}
