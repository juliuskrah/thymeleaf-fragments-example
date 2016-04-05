package com.jipasoft.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("title", "SB Admin 2 - Bootstrap Admin Theme");

		return "index";
	}

	@RequestMapping("/tables")
	public String tables(Model model) {
		model.addAttribute("title", "SB Admin 2 - Tables");

		return "tables";
	}

	@RequestMapping("/flot")
	public String flot(Model model) {
		model.addAttribute("title", "SB Admin 2 - Flot");

		return "flot";
	}

	@RequestMapping("/morris")
	public String morris(Model model) {
		model.addAttribute("title", "SB Admin 2 - Morris");

		return "morris";
	}

	@RequestMapping("/forms")
	public String forms(Model model) {
		model.addAttribute("title", "SB Admin 2 - Forms");

		return "forms";
	}

	@RequestMapping("/blank")
	public String blank(Model model) {
		model.addAttribute("title", "SB Admin 2 - Blank");

		return "blank";
	}

	@RequestMapping("/panels-wells")
	public String panelsWells(Model model) {
		model.addAttribute("title", "SB Admin 2 - Panels Wells");

		return "panels-wells";
	}

	@RequestMapping("/buttons")
	public String butons(Model model) {
		model.addAttribute("title", "SB Admin 2 - Buttons");

		return "buttons";
	}

	@RequestMapping("/notifications")
	public String notifications(Model model) {
		model.addAttribute("title", "SB Admin 2 - Notifications");

		return "notifications";
	}

	@RequestMapping("/typography")
	public String typography(Model model) {
		model.addAttribute("title", "SB Admin 2 - Typography");

		return "typography";
	}

	@RequestMapping("/icons")
	public String icons(Model model) {
		model.addAttribute("title", "SB Admin 2 - Icons");

		return "icons";
	}

	@RequestMapping("/grid")
	public String grid(Model model) {
		model.addAttribute("title", "SB Admin 2 - Grid");

		return "grid";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "SB Admin 2 - Login");

		return "login";
	}

}
