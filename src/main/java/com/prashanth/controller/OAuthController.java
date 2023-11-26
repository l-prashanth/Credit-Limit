package com.prashanth.controller;


import com.prashanth.model.OAuthForm;
import com.prashanth.model.token.JWTTokenResponse;
import com.prashanth.service.jwtservice.JWTProcessor;
import com.prashanth.utils.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class OAuthController {

	private JwtTokenUtil jwtTokenUtil;
	private JWTProcessor jwtProcessor;

	@GetMapping("/auth")
	public String auth() {
		
		return "auth";
	}
	
	@PostMapping("/auth")
	public String userRegistration(@ModelAttribute OAuthForm oAuthForm, Model model) {
		System.out.println(oAuthForm.getClientId());
		JWTTokenResponse token = jwtProcessor.generateToken(oAuthForm.getClientId(),oAuthForm.getClientSecret());
		System.out.println(token);

//		oAuthForm.setToken(token);
//		System.out.println(oAuthForm);
		// validate
//		System.out.println(oAuthForm.getGrantType());
//		System.out.println(oAuthForm.getClientId());
//		System.out.println(oAuthForm.getClientSecret());
//		System.out.println(oAuthForm.getToken());
		model.addAttribute("grantType", oAuthForm.getGrantType());
		model.addAttribute("clientId", oAuthForm.getClientId());
		model.addAttribute("clientSecret", oAuthForm.getClientSecret());

		model.addAttribute("token", token);
		return "auth";
	}
}
