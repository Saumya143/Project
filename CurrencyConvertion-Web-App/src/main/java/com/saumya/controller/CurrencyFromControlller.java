package com.saumya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saumya.pojo.CurrencyConvertionPojo;
import com.saumya.pojo.CurrencyExchangePojo;
import com.saumya.service.CurrencyConvertionWebService;

@Controller
public class CurrencyFromControlller {
	@Autowired
	CurrencyConvertionWebService service=null;
	
	@RequestMapping(value = "/index")
	public String showFrom(@ModelAttribute("CurrencyFrom") CurrencyExchangePojo pojo) {
		return "currencyFrom";
		
	}
	@RequestMapping(value="/currencyFrom",method = RequestMethod.POST)
	public String convertionShowFrom(Model model,@ModelAttribute("CurrencyFrom")CurrencyExchangePojo pojo) {
		CurrencyConvertionPojo convertCurency = service.convertCurency();
		model.addAttribute("convertCurency",convertCurency);
		return "currencyFrom";
		
	}

}
