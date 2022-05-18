package net.springsecurity.demo.springsecuritydemo.rest;

import net.springsecurity.demo.springsecuritydemo.model.User;
import net.springsecurity.demo.springsecuritydemo.repository.UserRepository;
import net.springsecurity.demo.springsecuritydemo.securiry.JwtTokenProvider;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationRestControllerV1 {

	private final AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private JwtTokenProvider jwtTokenProvider;

	public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword()));
			User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException(
				"User doesn't exists"));
			String token = jwtTokenProvider.createToken(request.getEmail(), user.getRole().name());
			Map<Object, Object> response = new HashMap<>();
			response.put("email", request.getEmail());
			response.put("token", token);
			return ResponseEntity.ok(response);
		} catch (AuthenticationException e) {
			return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/logout")
	public void authenticate(HttpServletRequest request, HttpServletResponse response) {
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		securityContextLogoutHandler.logout(request, response, null);
	}
}