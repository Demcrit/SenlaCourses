package com.senla.service;

import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Component
public class TokenStorage {

	public String createToken(Long id) throws JOSEException {
		byte[] shared = new byte[64];
		JWSSigner jwsSigner = new MACSigner(shared);
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().issuer(null)
				.expirationTime(new Date(new Date().getTime() + 60 * 1000)).claim("id", id).build();
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		signedJWT.sign(jwsSigner);
		String token = signedJWT.serialize();
		return token;

	}

	private Boolean checkToken(String token) throws ParseException, JOSEException {
		byte[] shared = new byte[64];
		SignedJWT signedJWT = SignedJWT.parse(token);
		JWSVerifier jwsVerifier = new MACVerifier(shared);
		Boolean verify = signedJWT.verify(jwsVerifier);
		Date date = (Date) signedJWT.getJWTClaimsSet().getExpirationTime();
		if (date.after(new Date()) && verify.equals(true)) {
			return true;
		}
		return false;
	}

	public Long getUserIdByToken(String token) throws ParseException, JOSEException {
		if (this.checkToken(token)) {
			SignedJWT signedJWT = SignedJWT.parse(token);
			Long id = (Long) signedJWT.getJWTClaimsSet().getClaim("id");
			return id;
		}
		return null;
	}

}
