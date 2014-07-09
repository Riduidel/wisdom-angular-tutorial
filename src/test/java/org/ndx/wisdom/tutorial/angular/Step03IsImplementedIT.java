package org.ndx.wisdom.tutorial.angular;


import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Step03IsImplementedIT  extends WisdomFluentLeniumTest {
	@Before
	public void makeSureWeUseFirefox() {
        assertThat(System.getProperty("fluentlenium.browser")).isEqualTo("firefox");
	}

	/**
	 * @see http://stackoverflow.com/q/24648963/15619 pour les détails sur le test du driver
	 */
	@Test
	public void canTestPageCorrectly() {
		assertThat(getDriver()).isInstanceOf(FirefoxDriver.class);
		goTo(GoogleShopController.LIST);
		FluentList<FluentWebElement> items = find("li");
		FluentLeniumAssertions.assertThat(items).hasSize(3);
		fill("input").with("nexus");
		await();
		items = find(".phone");
		FluentLeniumAssertions.assertThat(items).hasSize(1);
		fill("input").with("motorola");
		await();
		items = find(".phone");
		FluentLeniumAssertions.assertThat(items).hasSize(2);
	}

}
