package org.ndx.wisdom.tutorial.angular;


import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Step10IsImplementedIT  extends WisdomFluentLeniumTest {
	@Test
	public void should_display_first_image_as_placeholder() {
		goTo(GoogleShopController.LIST+"#/phones/nexus-s");
		await();
		assertThat(findFirst("img").getAttribute("src")).endsWith("nexus-s.0.jpg");
	}

	@Test
	public void should_swap_image_when_another_one_is_clicked() {
		goTo(GoogleShopController.LIST+"#/phones/nexus-s");
		await();
		FluentWebElement big = find("img", 0);
		String bigSource = big.getAttribute("src");
		FluentWebElement small = find("img", 1);
		String smallSource = small.getAttribute("src");
		small.click();
		assertThat(big.getAttribute("src")).isEqualTo(smallSource);
		assertThat(small.getAttribute("src")).isEqualTo(bigSource);
	}
}
