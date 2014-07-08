package org.ndx.wisdom.tutorial.angular;

import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.Controller;
import org.wisdom.api.annotations.Route;
import org.wisdom.api.annotations.View;
import org.wisdom.api.http.HttpMethod;
import org.wisdom.api.http.Result;
import org.wisdom.api.templates.Template;

@Controller
public class GoogleShopController extends DefaultController {
	public static final String LIST = "/list";
	/**
	 * Ici "list" est le nom du fichier du template, sans l'extension thl.html
	 */
	@View("list")
	Template list;
	
	/**
	 * Et donc quand on va aller sur http://localhost:9000/list, ça va afficher le template {@link #list}
	 */
	@Route(method = HttpMethod.GET, uri = LIST)
	public Result list() {
		return ok(render(list));
	}
}
