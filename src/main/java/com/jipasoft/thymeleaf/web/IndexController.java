package com.jipasoft.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "/", "/index" })
	public String index() {

		return "index";
	}

	@GetMapping("/tables")
	public String tables() {

		return "tables";
	}

	@GetMapping("/flot")
	public String flot() {

		return "flot";
	}

	@GetMapping("/morris")
	public String morris() {

		return "morris";
	}

	@GetMapping("/forms")
	public String forms() {

		return "forms";
	}

	@GetMapping("/blank")
	public String blank() {

		return "blank";
	}

	@GetMapping("/panels-wells")
	public String panelsWells() {

		return "panels-wells";
	}

	@GetMapping("/buttons")
	public String butons() {

		return "buttons";
	}

	@GetMapping("/notifications")
	public String notifications() {

		return "notifications";
	}

	@GetMapping("/typography")
	public String typography() {

		return "typography";
	}

	@GetMapping("/icons")
	public String icons() {

		return "icons";
	}

	@GetMapping("/grid")
	public String grid() {

		return "grid";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

}
