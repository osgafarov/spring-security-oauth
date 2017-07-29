package org.springframework.security.oauth2.common.utils;

/* Created by osgafarov on 29.07.17. */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.security.oauth2.common.util.CodeChallengeUtils;

/**
 * @author Marco Lenzo
 */
public class CodeChallengeUtilsTests {

    @Test
    public void testPlainCodeChallenge() {
        String codeVerifier = "plainCodeChallenge";
        String codeChallenge = CodeChallengeUtils.getCodeChallenge("plainCodeChallenge", "plain");
        assertEquals(codeChallenge, codeVerifier);
    }

    @Test
    public void testS256CodeChallenge() {
        // As per example RFC7636 Appendix B example:
        // Code verifier is dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk
        // Code challenge is E9Melhoa2OwvFrEMTJguCHaoeK1t8URWbuGJSstw-cM
        String codeVerifier = "dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk";
        String codeChallenge = CodeChallengeUtils.getCodeChallenge("dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk",
                "S256");
        assertEquals("E9Melhoa2OwvFrEMTJguCHaoeK1t8URWbuGJSstw-cM", codeChallenge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodeChallengeWithUnsupportedCodeChallengeMethod() {
        CodeChallengeUtils.getCodeChallenge("dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk", "xyz");
    }

}
