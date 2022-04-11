package com.michelle.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {


	@GetMapping("/Gold")
	public String seeGold(Model model, HttpSession session) {
		if(session.getAttribute("totalGold") == null || session.getAttribute("messages") == null ) {
			session.setAttribute("totalGold", 0);
			session.setAttribute("messages", new ArrayList<String>());
		}else {
			model.addAttribute("totalGold", session.getAttribute("totalGold"));
		}
		return "GetGold.jsp";
	}
	
	@PostMapping("/getGold")
	public String getGold(@RequestParam("amtGold") String amtGold, HttpSession session,RedirectAttributes redirectAttributes){
		int amountGold = 0;
		String msg ="";
		
		redirectAttributes.addFlashAttribute("message", "Your action is done");
		
		if(amtGold.equals("farm")) {
			amountGold = randomNum(10,20);
			msg = getMessage("farm",amountGold);
		}else if(amtGold.equals("cave")) {
			amountGold = randomNum(10,20);
			msg = getMessage("cave",amountGold);
		}else if(amtGold.equals("house")) {
			amountGold = randomNum(10,20);
			msg = getMessage("house",amountGold);
		}else if(amtGold.equals("quest")) {
			amountGold = randomNum(-50,50);
			msg = getMessage("quest",amountGold);
		}else {
			System.out.println("There was an error...try again");
		}
		
		int total = (Integer) session.getAttribute("totalGold");
		total += amountGold;
		@SuppressWarnings("unchecked")
		ArrayList<String> message = (ArrayList<String>) session.getAttribute("messages");
		message.add(msg);
		session.setAttribute("totalGold", total);
		session.setAttribute("messages",message);
		return "redirect:/Gold";
	}
	
	public int randomNum(int min, int max) {
		return (int)(Math.random()*(max - min-1)+min);
	}
	
	public String getMessage(String type, int amountGold) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm a");  
		LocalDateTime now = LocalDateTime.now();
		
		if(amountGold < 0) {
			return "You failed a " + type + " and lost " + amountGold + " gold. Ouch (" + dtf.format(now) + ")";
		}else {
			return "You " + (type == "quest" ? "completed a ": "entered a ") + type + " and earned " + amountGold + " gold (" +  dtf.format(now) + ")";
		}
		
	}
}
