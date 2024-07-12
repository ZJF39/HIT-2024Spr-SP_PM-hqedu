package com.haoqi.hqedu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "itheima";
    private static Long expire = 43200000L;

    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)// 添加自定义信息
                .signWith(SignatureAlgorithm.HS256,signKey)// 签名算法
                .setExpiration(new Date(System.currentTimeMillis() + expire))// 过期时间
                .compact();// 生成token
        return jwt;
    }
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)// 签名密钥
                .parseClaimsJws(jwt)// 解析token
                .getBody();// 获取自定义信息
        return claims;
    }
}
