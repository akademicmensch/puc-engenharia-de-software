package com.pucmg.authenticationcore.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pucmg.authenticationcore.models.AuthenticationRequest;
import com.pucmg.authenticationcore.models.AuthenticationResponse;
import com.pucmg.authenticationcore.models.SampleUser;
import com.pucmg.authenticationcore.services.UserDetailService;
import com.pucmg.authenticationcore.utils.JwtUtil;

import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailService userDetailService;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new BadCredentialsException("Invalid user or password! : ", e);
		}

		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping(value="/details")
	public SampleUser getUserDetailsByJwt(HttpServletRequest rq) {
		String auth = rq.getHeader("Authorization");
		auth = auth.replace("Bearer ", "");
		
		String name = Jwts.parser().setSigningKey("secret").parseClaimsJws(auth).getBody().get("sub", String.class);
		return userDetailService.retornarUsuarioERole(name);
	}

}
