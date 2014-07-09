package org.ndx.wisdom.tutorial.angular;


import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

public class Step03IsImplementedIT  extends WisdomFluentLeniumTest {
	@Test
	public void canTestPageCorrectly() {
		goTo(GoogleShopController.LIST);
		FluentList<FluentWebElement> items = find("li");
		FluentLeniumAssertions.assertThat(items).hasSize().greaterThanOrEqualTo(3);
		fill("input").with("nexus");
		await();
		items = find("li");
		FluentLeniumAssertions.assertThat(items).hasSize().greaterThanOrEqualTo(1);
		fill("input").with("motorola");
		await();
		items = find("li");
		FluentLeniumAssertions.assertThat(items).hasSize().greaterThanOrEqualTo(2);
	}

}
