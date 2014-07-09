package org.ndx.wisdom.tutorial.angular;


import java.util.Collection;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.wisdom.test.parents.WisdomFluentLeniumTest;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import static org.assertj.core.api.Assertions.assertThat;

public class Step04IsImplementedIT  extends WisdomFluentLeniumTest {
	@Before
	public void makeSureWeUseFirefox() {
        assertThat(System.getProperty("fluentlenium.browser")).isEqualTo("firefox");
	}
	
	/**
	 * Une traduction Java absolument litérale de 
	 * <pre>
      function getNames() {
        return phoneNameColumn.map(function(elm) {
          return elm.getText();
        });
      }
	 * </pre>
	 * @param items
	 * @return
	 */
	public Collection<String> names(FluentList<FluentWebElement> items) {
		return Collections2.transform(items, new Function<FluentWebElement, String>() {

			public String apply(FluentWebElement input) {
				// le deuxième lien contient le nom !
				return input.find("a", 1).getText();
			}});
	}

	@Test
	public void canTestPageCorrectly() {
		goTo(GoogleShopController.LIST);
		FluentList<FluentWebElement> items = find("li");
		fill("input").with("tablet");
		await();
		items = find("li");
		assertThat(names(items)).containsExactly(
				        "Motorola XOOM\u2122 with Wi-Fi",
				        "MOTOROLA XOOM\u2122");

		// Et maintenant on change le filtre
		fillSelect("select").withValue("name");
		await();
		items = find("li");
		assertThat(names(items)).containsExactly(
				        "MOTOROLA XOOM\u2122",
						"Motorola XOOM\u2122 with Wi-Fi"
				        );
	}

}
