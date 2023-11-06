//package com.prashanth.utils;
//
//import lombok.Data;
//import org.springframework.stereotype.Component;
//
//import java.security.KeyPair;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//
//@Component
//@Data
//public class RSAKeyProperties {
//
//    private RSAPublicKey publicKey;
//    private RSAPrivateKey privateKey;
//
//    //constructor
//    public RSAKeyProperties(){
//        KeyPair pair = KeyGeneratorUtility.generateRsaKey();
//        //set rsa key value to public and private key
//        this.publicKey = (RSAPublicKey) pair.getPublic();
//        this.privateKey = (RSAPrivateKey) pair.getPrivate();
//    }
//}
