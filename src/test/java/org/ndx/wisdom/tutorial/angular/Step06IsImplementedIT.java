package org.ndx.wisdom.tutorial.angular;


import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Step06IsImplementedIT  extends WisdomFluentLeniumTest {
	@Test
	public void canNavigateLink() {
		goTo(GoogleShopController.LIST);
		FluentList<FluentWebElement> items = find("li");
		fill("input").with("nexus");
		await();
		findFirst("li").findFirst("a").click();
		await();
		assertThat(url()).contains("#");
		assertThat(url()).endsWith("/phones/nexus-s");
	}

}
