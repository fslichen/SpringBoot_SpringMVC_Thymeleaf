package evolution.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AnyController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
    		Map<String, Object> model) {
    	String fileName = file.getOriginalFilename();
    	log.info(fileName);
    	model.put("message", fileName);
        return "evolution";// Corresponds to evolution.html under templates.
    }
    
	@GetMapping("/map")
	public String map(Map<String, Object> model) {
		model.put("message", "Hello World");
		return "evolution";
	}
}
