package org.ndx.wisdom.tutorial.angular;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class Step03IsImplementedIT  extends WisdomFluentLeniumTest {

	@Test
	public void canTestPageCorrectly() {
		if (getDriver() instanceof HtmlUnitDriver) {
			HtmlUnitDriver driver = (HtmlUnitDriver) getDriver();
			if(!driver.isJavascriptEnabled()) {
				driver.setJavascriptEnabled(true);
			}
			Assert.assertTrue("Javascript should be enabled for Angular to work !", driver.isJavascriptEnabled());
		}
		goTo(GoogleShopController.LIST);
		await().untilPage();
		// Et on charge la liste des téléphones
		FluentWebElement phones = findFirst(".phones");
		assertThat(phones).isDisplayed();
		// pure black magic script that should ensure angular has totally loaded data
		FluentList<FluentWebElement> items = find(".phone");
		assertThat(items).hasSize(3);
		fill("input").with("nexus");
		await();
		items = find(".phone");
		assertThat(items).hasSize(1);
		fill("input").with("motorola");
		await();
		items = find(".phone");
		assertThat(items).hasSize(2);
	}

}
