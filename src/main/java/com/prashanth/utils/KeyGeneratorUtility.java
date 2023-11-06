//package com.prashanth.utils;
//
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//
//public class KeyGeneratorUtility {
//
//    public static KeyPair generateRsaKey(){
//
//        KeyPair keyPair;
//
//        try{
//            //get an instance of a key generator
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            //use 2048 bits
//            keyPairGenerator.initialize(2048);
//            //generate keypair
//            keyPair = keyPairGenerator.generateKeyPair();
//        } catch(Exception e){
//            throw new IllegalStateException();
//        }
//        return keyPair;
//    }
//
//}
