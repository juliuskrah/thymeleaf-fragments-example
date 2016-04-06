package com.jipasoft.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "/", "/index" })
	public String index() {

		return "index";
	}

	@RequestMapping("/tables")
	public String tables() {

		return "tables";
	}

	@RequestMapping("/flot")
	public String flot() {

		return "flot";
	}

	@RequestMapping("/morris")
	public String morris() {

		return "morris";
	}

	@RequestMapping("/forms")
	public String forms() {

		return "forms";
	}

	@RequestMapping("/blank")
	public String blank() {

		return "blank";
	}

	@RequestMapping("/panels-wells")
	public String panelsWells() {

		return "panels-wells";
	}

	@RequestMapping("/buttons")
	public String butons() {

		return "buttons";
	}

	@RequestMapping("/notifications")
	public String notifications() {

		return "notifications";
	}

	@RequestMapping("/typography")
	public String typography() {

		return "typography";
	}

	@RequestMapping("/icons")
	public String icons() {

		return "icons";
	}

	@RequestMapping("/grid")
	public String grid() {

		return "grid";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";
	}

}
