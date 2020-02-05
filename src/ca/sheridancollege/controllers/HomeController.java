package ca.sheridancollege.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.NLP.NLP;
import ca.sheridancollege.beans.Sentence;

@Controller
public class HomeController {
	private NLP nlp;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("sentence", new Sentence());
		return "enter";
	}

	@PostMapping("process")
	public String processSentence(Model model, @ModelAttribute("sentence") Sentence sentence) {

		String temp = sentence.getText();
		
		if(temp != null && !temp.isEmpty()) { 
			try {
				sentence.setEntities(nlp.Process(temp));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // get nlp string
			
			model.addAttribute("sentence", sentence);
			
			return "display";
			
		}else {
			model.addAttribute("error", "Please enter some text.");
			return "enter";
			
		}
		
		

		
	}

	@Autowired
	public HomeController() {
		this.nlp = new NLP();
	}

}
