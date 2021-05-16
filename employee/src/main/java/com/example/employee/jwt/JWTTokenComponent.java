package com.example.employee.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.employee.convertor.RoleConvertor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTTokenComponent {
	

	private String secret;
	private long tokenLifeTime;
	private RoleConvertor convertor;

	public JWTTokenComponent(Environment environment) {
		secret = environment.getRequiredProperty("jwt.secret");
		tokenLifeTime = Long.parseLong(environment.getRequiredProperty("jwt.lifetime"));
		convertor=new RoleConvertor();
	}
	
	
	
	public String doGenerateToken(UserDetails user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", convertor.apply(user.getAuthorities()));
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date((new Date().getTime() + tokenLifeTime * 1000)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String generateToken(UserDetails user) {
		return doGenerateToken(user);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public int getRolesFromToken(String token) {
		Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		int roles=claims.get("roles",Integer.class);
		return roles;
	}
	
	private <T> T getClaimnFromToken(String token,Function<Claims,T> claimsResolver) { //Interface Function được sử dụng để chuyển đổi dữ liệu từ tham số truyền vào để trả về kết quả ở định dạng khác. 
		Claims claims=getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public Date getExpirationFromToken(String token) {
		return getClaimnFromToken(token, Claims::getExpiration); // kiểu dạng cú pháp thêm .getEx
	}
	
	private boolean isTokenExpired(String token) {
		Date date = getExpirationFromToken(token);
		return date.before(new Date());
	}
	
	public String getUserNameFromToken(String token) {
		return getClaimnFromToken(token, Claims::getSubject);
	}
	
	public boolean validateToken(String token,UserDetails user) {
		String username= getUserNameFromToken(token);
		return username.equals(user.getUsername()) && !isTokenExpired(token);
	}

}
