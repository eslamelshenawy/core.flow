package com.core.flow.shared.util;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64EncoderDecoder {

    public static String encodeRequesterId(Long requesterId) {
        String idAsString = requesterId.toString();
        return Base64.getEncoder().encodeToString(idAsString.getBytes(StandardCharsets.UTF_8));
    }

    public static Long decodeRequesterId(String encodedId) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedId);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        return Long.parseLong(decodedString);
    }
}

