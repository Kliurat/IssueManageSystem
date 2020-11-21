package com.ibm.springboot.util;

import java.security.Key;
import java.util.Date;
import java.util.Objects;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.logging.log4j.util.Base64Util;

import com.ibm.springboot.entity.jwt.Audience;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {

	public static final String AUTH_HEADER_KEY = "Authorization";

	public static final String TOKEN_PREFIX = "Bearer";

	/**
	 * @Description: 解析jwt
	 * @Param:
	 * @return:
	 * @Author: 蔡海锋
	 * @Date: 2020/9/2
	 */

	public static Claims parseJWT(String jsonWebToken, String base64Security) {
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
					.parseClaimsJws(jsonWebToken).getBody();
			System.out.println("token签发时间：" + claims.getIssuedAt().toString());

			System.out.println("token过期时间：" + claims.getExpiration().toString());
			return claims;
		} catch (ExpiredJwtException eje) {
//            e.printStackTrace();
			System.out.println("===== Token过期 =====" + eje.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("===== Token解析异常 =====");

		}
		return null;
	}

	/**
	 * @Description: 构建jwt
	 * @Param: [userId, username, role, audience]
	 * @return: java.lang.String
	 * @Author: 蔡海锋
	 * @Date: 2020/9/3
	 */
	public static String createJWT(String loginId, String username, String role, Audience audience) {

		// 使用HS256加密算法
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		// 单位：毫秒
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// userId是重要信息，进行加密
		String encryId = Base64Util.encode(loginId);

		// 添加构成JWT的参数
		Date date = new Date();
		System.out.println("签发时间：" + date.toString());
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
				// 可以将基本不重要的对象信息放到claims
				.claim("role", role).claim("loginId", loginId).setSubject(username) // 代表这个JWT的主体，即它的所有者
				.setIssuer(audience.getClientId()) // 代表这个JWT的签发主体
				.setIssuedAt(date) // JWT的签发时间
				.setAudience(audience.getName()) // 代表这个JWT的接收对象
				.signWith(signatureAlgorithm, signingKey);
		// 添加Token过期时间
		int TTLMillis = audience.getExpiresSecond();
		if (TTLMillis >= 0) {
			long expMillis = nowMillis + TTLMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp) // 是一个时间戳，代表这个JWT的过期时间
					.setNotBefore(now); // JWT的生效时间
			System.out.println("过期时间：" + exp.toString());

		}
		// 生成JWT
		return builder.compact();
	}

	/**
	 * @Description: 从token中获取用户名
	 * @Param: [token, base64Security]
	 * @return: java.lang.String
	 * @Author: 蔡海锋
	 * @Date: 2020/9/3
	 */
	public static String getUsername(String token, String base64Security) {
		return Objects.requireNonNull(parseJWT(token, base64Security)).getSubject();
	}

	/**
	 * @Description: 从token中获取用户ID
	 * @Param: [token, base64Security]
	 * @return: java.lang.String
	 * @Author: 蔡海锋
	 * @Date: 2020/9/3
	 */
	public static String getUserId(String token, String base64Security) {
		String userId = Objects.requireNonNull(parseJWT(token, base64Security)).get("userId", String.class);
		return Base64Util.encode(userId);
	}

	/**
	 * @Description: 是否已过期
	 * @Param: [token, base64Security]
	 * @return: boolean
	 * @Author: 蔡海锋
	 */
	public static boolean isExpiration(String token, String base64Security) {
		return Objects.requireNonNull(parseJWT(token, base64Security)).getExpiration().before(new Date());
	}

}
