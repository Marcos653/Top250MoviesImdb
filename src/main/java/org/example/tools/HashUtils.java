package org.example.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static String getHashMd5(String value) {
        try {
            var md = MessageDigest.getInstance("MD5");
            var hash = new BigInteger(1, md.digest(value.getBytes()));
            return hash.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
