package org.ndx.wisdom.tutorial.angular;


import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Step07IsImplementedIT  extends WisdomFluentLeniumTest {
	@Test
	public void index_is_redirected_to_phones_list() {
		goTo(GoogleShopController.LIST);
		await();
		assertThat(url()).endsWith("#/phones");
	}
	@Test
	public void phone_page_is_placeholder() {
		goTo(GoogleShopController.LIST);
		fill("input").with("nexus");
		await();
		findFirst("li").findFirst("a").click();
		await();
		assertThat(url()).contains("#");
		assertThat(url()).endsWith("/phones/nexus-s");
		FluentLeniumAssertions.assertThat(findFirst("#phoneId")).hasText("nexus-s");
	}

}
