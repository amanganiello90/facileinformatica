package com.ezlearning.platform.services.aws.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.ezlearning.platform.services.aws.AmazonS3ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AmazonS3ClientServiceImpl.class);
  
  @Value("${aws.s3.bucket}")
  String bucketName;
  
  private AmazonS3 s3Client;
  
  public AmazonS3ClientServiceImpl(AmazonS3 s3Client) {
    this.s3Client = s3Client;
  }
  
  @Override
  public int createBucket() {
    int response;
    
    try {
      if (!s3Client.doesBucketExistV2(bucketName)) {
        CreateBucketRequest request = new CreateBucketRequest(bucketName)
            .withCannedAcl(CannedAccessControlList.BucketOwnerFullControl);
        s3Client.createBucket(request);
        response = 0;
      } else {
        response = 1;
      }
    } catch (Exception e) {
      LOGGER.error("Error creating bucket: {}", e.getMessage());
      response = 1;
    }
    
    return response;
  }
  
  @Override
  public URL upload(File file, String filename) {
    URL response = null;
    LOGGER.info("Inside upload method");
    
    try {
      LOGGER.info("Checking if object exists");
      if (!s3Client.doesObjectExist(bucketName, filename)) {
        LOGGER.info("Making request");
        PutObjectRequest request = new PutObjectRequest(bucketName, filename, file)
            .withCannedAcl(CannedAccessControlList.PublicRead);
        LOGGER.info("sending request");
        s3Client.putObject(request);
        LOGGER.info("getting url");
        response = s3Client.getUrl(bucketName, filename);
      }
    } catch (Exception e) {
      LOGGER.error("Error uploading file: {}", e.getMessage());
    }
    
    return response;
    
  }
}
