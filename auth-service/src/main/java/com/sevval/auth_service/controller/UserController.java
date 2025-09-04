package com.sevval.auth_service.controller;

import com.sevval.auth_service.model.UserDto;
import com.sevval.auth_service.model.Users;
import com.sevval.auth_service.service.BlockchainService;
import com.sevval.auth_service.service.JWTService;
import com.sevval.auth_service.service.UserService;
import com.sevval.auth_service.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class UserController {

//    @Autowired
//    private UserService service;

//    @PostMapping("/register")
//    public Users register(@RequestBody Users user) {
//        return service.register(user);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody Users user) {
//
//        return service.verify(user);
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody Users user) {
//        Users savedUser = service.register(user);
//        return ResponseEntity.ok("User registered successfully with username: " + savedUser.getUsername());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Users user) {
//        String token = service.verify(user);
//
//        if (token.equals("fail")) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//        // Başarılı login → JWT JSON formatında dönülür
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return ResponseEntity.ok(response);
//    }

    private final BlockchainService blockchainService;
    private final JWTService jwtService;

    public UserController(BlockchainService blockchainService, JWTService jwtService) {
        this.blockchainService = blockchainService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        try {
            byte[] hash = HashUtil.keccak32(user.getEmail(), user.getPassword());
            blockchainService.registerUser(hash);
            return ResponseEntity.ok("Kullanıcı blockchain'e kaydedildi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kayıt sırasında hata: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto user) {
        try {
            byte[] hash = HashUtil.keccak32(user.getEmail(), user.getPassword());
            boolean isValid = blockchainService.verifyUser(hash);

            if (isValid) {
                String token = jwtService.generateToken(user.getEmail());
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Geçersiz kullanıcı");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Giriş sırasında hata: " + e.getMessage());
        }
    }

}

class AuthRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class AuthResponse {
    private String token;
    public AuthResponse(String token) { this.token = token; }
    public String getToken() { return token; }

}
