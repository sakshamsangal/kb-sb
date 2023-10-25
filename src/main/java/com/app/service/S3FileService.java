//package com.app.service;
//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3Object;
//import com.app.property.AppProp;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Objects;
//
//@Service
//@Slf4j
//public class S3FileService {
//
//    private final AppProp appProp;
//
//    @Autowired
//    public S3FileService(AppProp AppProp) {
//        this.appProp = AppProp;
//    }
//
//    public String uploadFile(String fileNameWithPath, MultipartFile file) {
//        log.info("uploadFile call start");
//
//        AmazonS3 s3Client;
//        String url = null;
//        try {
//            s3Client = AmazonS3Util.getInstance(AppProp.getClientRegion());
//            log.info("Amazon S3 instance is now available to use");
//            checkDirectoryAndSaveFile(fileNameWithPath, file, s3Client);
//            url = s3Client.getUrl(AppProp.getBucketName(), fileNameWithPath).toString();
//
//        } catch (AmazonServiceException | IOException e) {
//            log.error("AmazonServiceException |IOException ", e);
//
//            // The call was transmitted successfully, but Amazon S3 couldn't process
//            // it, so it returned an error response.
//        } catch (SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client
//            // couldn't parse the response from Amazon S3.
//            log.error("uploadFile method exception: " + e);
//        }
//
////        s3Client.setObjectAcl(AppProp.getBucketName(), fileNameWithPath, CannedAccessControlList.PublicRead);
//        log.info("File object created successfully at" + url);
//        return url;
//    }
//
//    private void checkDirectoryAndSaveFile(String fileNameWithPath, MultipartFile file, AmazonS3 s3Client) throws IOException {
//        log.info("checkDirectoryAndSaveFile start");
//        try {
//            s3Client.getObjectMetadata(AppProp.getBucketName(), fileNameWithPath);
//        } catch (AmazonServiceException e) {
//            if (e.getStatusCode() == 404) {
//                ObjectMetadata metaData = new ObjectMetadata();
//                metaData.setContentLength(file.getSize());
//                metaData.setContentType(file.getContentType());
//                s3Client.putObject(AppProp.getBucketName(), fileNameWithPath, file.getInputStream(), metaData);
//            } else {
//                log.error("Error while uploading file to S3 " + e);
//            }
//        }
//        log.info("checkDirectoryAndSaveFile end");
//
//    }
//
//    public InputStream getFile(String fileName) {
//
//        String clientRegion = AppProp.getClientRegion();
//        AmazonS3 s3Client = null;
//        try {
//            s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
//                    .build();
//
//        } catch (AmazonServiceException e) {
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            log.error("getFile method Exception: " + e);
//            e.printStackTrace();
//        }
//
//        //read the file
//        if (Objects.nonNull(s3Client)) {
//            S3Object s3object = s3Client.getObject(AppProp.getBucketName(), fileName);
//            log.info("File object read successfully at" + s3Client.getUrl(AppProp.getBucketName(), fileName).toString());
//            return s3object.getObjectContent();
//        }
//        return null;
//    }
//
//
//}
