package net.springsecurity.demo.springsecuritydemo.securiry;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.*;
import java.util.*;

@Component
public class JwtTokenProvider {

	private final UserDetailsService userDatailsService;

	@Value("${jwt.secret}")
	private String secretKey;
	@Value("${jwt.header}")
	private String authorizationHeader;
	@Value("${jwt.expiretion}")
	private long validityInMillisecuds;

	public JwtTokenProvider(@Qualifier("userDetailsServiceImpl") UserDetailsService userDatailsService) {
		this.userDatailsService = userDatailsService;
	}

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String createToken(String username, String role) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("role", role);
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMillisecuds * 1000);

		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(validity)
			.signWith(SignatureAlgorithm.ES256, secretKey)
			.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return !claimsJws.getBody().getExpiration().before(new Date());
		} catch (JwtException | IllegalArgumentException e) {
			throw new JwtAuthenticationException("JWT token is expired or invalid", HttpStatus.UNAUTHORIZED);
		}
	}

	public Authentication getAuthentication(String token) {
		UserDetails userDetails=this.userDatailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest request) {
		return request.getHeader(authorizationHeader);
	}
}