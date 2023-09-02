package com.springboot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
//	"say-hello" => "Hello! What are you learning today?"
	
//	to configure this url, use spring mvc
//	http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> HTML Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("HTML page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
//		return "Hello! What are you learning today?";
	}
	
//	"say-hello-jsp" => sayHello.jsp
//	src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
//	@ResponseBody // otherwise it will print "sayHello"
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
}
