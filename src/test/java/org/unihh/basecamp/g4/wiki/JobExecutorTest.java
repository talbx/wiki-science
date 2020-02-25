package org.unihh.basecamp.g4.wiki;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobExecutorTest extends TestCase {

    @Mock
    JobFactory jobFactory;

    @Test
    public void testAccept() {
        JobExecutor executor = new JobExecutor(jobFactory);

        ImmutableArguments arguments = Arguments.of("job", "input", "output");

        executor.accept(arguments);
    }
}