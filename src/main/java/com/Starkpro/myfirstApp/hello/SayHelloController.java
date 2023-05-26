package com.Starkpro.myfirstApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	//"say-hello" ==> "Hello! What are you learning today?"
	
	@RequestMapping("say-hello")
	// http://localhost:8080/say-hello
	
	// to map a url we use request mapping annotation when we type say-hello it needs to give the string
	@ResponseBody 
	
	// Responsebody will return the message to browser
	public String sayHello() {
		return "Hello! What are you learning today?" ; 
	}
	
	
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayhelloHTML() {
		StringBuffer sb = new StringBuffer() ; 
		sb.append("<html>") ; 
		sb.append("<head>") ; 
		sb.append("<title> My First HTML Page </title>") ; 
		sb.append("</head>") ; 
		sb.append("<body>") ; 
		sb.append("My first html page with body") ; 
		sb.append("</body>") ; 
		sb.append("</html>") ; 
		return sb.toString() ; 
	}
	
	// Since we cant make like this, we use JSP 
	
	@RequestMapping("say-hello-jsp")

	public String sayHelloJsp() {
		return "sayHello" ; 
	}
}
