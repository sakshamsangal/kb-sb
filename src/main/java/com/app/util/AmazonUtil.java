//package com.app.service;
//
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//
//// Java code for Bill Pugh Singleton Implementation
//public class AmazonUtil {
//    private static AmazonS3 s3Obj;
//
//    private AmazonUtil() {
//        // private constructor
//    }
//
//    public static AmazonS3 getInstance(String clientRegion) {
//        if (s3Obj == null) {
//            s3Obj = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
//                    .build();
//        }
//        return s3Obj;
//    }
//
//}
