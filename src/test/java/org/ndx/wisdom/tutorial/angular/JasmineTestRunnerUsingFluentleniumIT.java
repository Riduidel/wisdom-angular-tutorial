package org.ndx.wisdom.tutorial.angular;

import org.junit.Ignore;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

/**
 * Fluentlenium test that go to jasmine page to grab test results
 * 
 * @author ndx
 *
 */
public class JasmineTestRunnerUsingFluentleniumIT extends WisdomFluentLeniumTest {
	@Test @Ignore
	public void doc() throws Exception {
		goTo(JasmineRunnerController.JASMINE_TESTS);
		assertThat(find(".")).hasText("1. The Wisdom Framework");
	}
}
