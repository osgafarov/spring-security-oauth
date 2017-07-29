package org.springframework.security.oauth2.common.exceptions;

/* Created by osgafarov on 29.07.17. */

@SuppressWarnings("serial")
public class InvalidCodeVerifierException extends ClientAuthenticationException {

    public InvalidCodeVerifierException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidCodeVerifierException(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_code_verifier";
    }
}
