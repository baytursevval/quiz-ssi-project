package com.sevval.auth_service.util;

import org.web3j.crypto.Hash;
import org.web3j.utils.Numeric;

public class HashUtil {
    private HashUtil() {}

    public static byte[] keccak32(String email, String password) {
        String input = email + password;
        String hex = Hash.sha3String(input); // "0x..." formatında keccak256 hash
        return Numeric.hexStringToByteArray(hex); // 32 byte array
    }
}
