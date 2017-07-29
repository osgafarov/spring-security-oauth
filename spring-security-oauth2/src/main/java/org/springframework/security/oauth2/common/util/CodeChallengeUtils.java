package org.springframework.security.oauth2.common.util;

/* Created by osgafarov on 29.07.17. */

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.codec.Utf8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodeChallengeUtils {

    private CodeChallengeUtils() {

    }

    /**
     * Generates the code challenge from a given code verifier and code challenge method.
     * @param codeVerifier
     * @param codeChallengeMethod allowed values are only <code>plain</code> and <code>S256</code>
     * @return
     */
    public static String getCodeChallenge(String codeVerifier, String codeChallengeMethod) {
        if (codeChallengeMethod.equals("plain")) {
            return codeVerifier;
        }
        else if (codeChallengeMethod.equalsIgnoreCase("S256")) {
            return getS256CodeChallenge(codeVerifier);
        }
        else {
            throw new IllegalArgumentException(codeChallengeMethod + " is not a supported code challenge method.");
        }
    }

    private static String getS256CodeChallenge(String codeVerifier) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [SHA-256]");
        }
        byte[] sha256 = md.digest(Utf8.encode(codeVerifier));
        String codeChallenge = Base64.encodeBase64URLSafeString(sha256);
        return codeChallenge;
    }

}
