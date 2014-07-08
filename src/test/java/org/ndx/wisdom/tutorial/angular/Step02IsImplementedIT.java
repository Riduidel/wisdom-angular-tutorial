package org.ndx.wisdom.tutorial.angular;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class Step02IsImplementedIT  extends WisdomFluentLeniumTest {

	@Test
	public void canTestPageCorrectly() {
		goTo(GoogleShopController.LIST);
		// On charge l'élément UL.phones
		FluentWebElement phonesList = findFirst("#phones");
		// Et on charge la liste des téléphones
		FluentList<FluentWebElement> items = phonesList.find(".phone");
		assertThat(items).hasSize(3);
		fill("input").with("nexus");
		items = phonesList.find(".phone");
		assertThat(items).hasSize(1);
		fill("input").with("motorola");
		items = phonesList.find(".phone");
		assertThat(items).hasSize(2);
	}

}
