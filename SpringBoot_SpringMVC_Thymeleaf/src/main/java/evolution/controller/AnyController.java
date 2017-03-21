package evolution.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import evolution.dto.Message;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AnyController {
	private List<Message> messages;
	
	public AnyController() {
		this.messages = new LinkedList<>();
		this.messages.add(new Message("id0", "title0", "text0"));
		this.messages.add(new Message("id1", "title1", "text1"));
	}
	
	@GetMapping(value = "/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("evolution");// Corresponds to evolution.html under templates.
        modelAndView.addObject("messages", this.messages);// Attach the attribute to modelAndView.
        return modelAndView;
    }
	
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
    		Map<String, Object> model) {
    	String fileName = file.getOriginalFilename();
    	log.info(fileName);
    	model.put("message", fileName);// Attach the attribute to the model.
        return "evolution";// Corresponds to evolution.html under templates.
    }
    
	@GetMapping("/map")
	public String map(Map<String, Object> model) {
		model.put("message", "Hello World");// Attach the attribute to the map.
		return "evolution";// Corresponds evolution.html under templates.
	}
	
	@GetMapping("/model")
	public String model(Model model) {
        model.addAttribute("messages", this.messages);// Attach the attribute to the model.
        return "evolution";// Corresponds evolution.html under templates.
    }
}
