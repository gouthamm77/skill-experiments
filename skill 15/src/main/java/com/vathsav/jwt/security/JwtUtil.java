package com.vathsav.jwt.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {
private static final String SECRET="secretkey";

public static String generateToken(String username,String role){
return Jwts.builder()
.setSubject(username)
.claim("role",role)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis()+3600000))
.signWith(SignatureAlgorithm.HS256,SECRET)
.compact();
}

public static Claims validate(String token){
return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
}
}