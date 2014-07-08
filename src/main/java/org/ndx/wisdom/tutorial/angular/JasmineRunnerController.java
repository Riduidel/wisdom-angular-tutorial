package org.ndx.wisdom.tutorial.angular;

import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.Controller;
import org.wisdom.api.annotations.Route;
import org.wisdom.api.annotations.View;
import org.wisdom.api.http.HttpMethod;
import org.wisdom.api.http.Result;
import org.wisdom.api.templates.Template;

@Controller
public class JasmineRunnerController extends DefaultController {
	public static final String JASMINE_TESTS = "/jasmineTests";

	@View("jasmine/SpecRunner") Template jasmineTests;
	
	@Route(method = HttpMethod.GET, uri = JASMINE_TESTS)
	public Result jasmineTests() {
		return ok(render(jasmineTests));
	}
}
