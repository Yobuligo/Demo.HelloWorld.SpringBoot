package com.yobuligo.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	
	/*@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="Morld") String name) {
		return new Greeting(12, "hello" + name);
	}*/
	
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }	
    
    @RequestMapping("/greetings")
    public List<Greeting> greetings(){
    	List<Greeting> greetings = new ArrayList<>();
    	greetings.add(new Greeting(counter.incrementAndGet(), "Hello World"));
    	greetings.add(new Greeting(counter.incrementAndGet(), "Hello World"));
    	greetings.add(new Greeting(counter.incrementAndGet(), "Hello World"));
    	
    	return greetings;
    }
}
