package com.haoqi.hqedu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HqeduApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testJWT() {
		Map<String,Object> claims = new HashMap<>();
		claims.put("id",1);
		claims.put("name","tom");

		String jwt =Jwts.builder()
								.signWith(SignatureAlgorithm.HS256,"itheima")// 签名算法
								.setClaims(claims)// 有效载荷(自定义内容)
								.setExpiration(new Date(System.currentTimeMillis() + 3600*1000))// 过期时间：当前时间 + 1小时(3600ms*1000)
								.compact();
		System.out.println(jwt);
	}

	@Test
	public void testParseJWT() {
		Claims claims = Jwts.parser()
								.setSigningKey("itheima") // 签名秘钥
								.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyMDY4NzMwNX0.IjA13ZrjkzGLducEdU8Df3zS5MYzy_Dwr_ZMUSy50Ew")// 令牌
								.getBody();// 解析出有效载荷
		System.out.println(claims);
	}
}
