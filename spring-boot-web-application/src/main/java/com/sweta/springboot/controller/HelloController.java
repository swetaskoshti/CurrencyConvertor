/**
 * 
 */
/**
 * @author swetakoshti
 *
 */
package com.sweta.springboot.controller;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweta.springboot.CurrencyConvertor;
import com.sweta.springboot.DateTimeGenerator;
import com.sweta.springboot.SendEmail;

@Controller
public class HelloController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/Success")
   public String sayHello(@RequestParam("baseCurrency") String baseCurrency, @RequestParam("senderEmailID") String senderEmailID, 
		   @RequestParam("password") String password, @RequestParam("receiverEmailID") String receiverEmailID, Model model) {
	   
	   CurrencyConvertor cc = new CurrencyConvertor();
	   String filename = DateTimeGenerator.getDateTime();
	   String jsonObject =  cc.getResponse(baseCurrency.toUpperCase());
	   try{
		   cc.convertMapToCSV(jsonObject,filename);
		   SendEmail.sendAttachmentEmail(senderEmailID,password,receiverEmailID,filename,"FX Data", "The attached file contains the FX Data");
		   return "Success";
	   }catch(Exception e) {
		   return "ErrorPage";
	   }
   }
}