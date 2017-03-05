package com.takemeout.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import com.takemeout.user.projections.UserProjection;
import com.takemeout.user.entities.User;

public class JwtUtil {

    //@Value("${jwt.secret}")
    private static final String secret = "secret";

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public static User parseToken(String token) throws JwtException {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            User u = new User();
            u.setUserName(body.getSubject());
            u.setId(Integer.parseInt((String) body.get("userId")));

            return u;

        } catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public static String generateToken(User u) {
        Claims claims = Jwts.claims().setSubject(u.getUserName());
        claims.put("userId", u.getId() + "");

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
