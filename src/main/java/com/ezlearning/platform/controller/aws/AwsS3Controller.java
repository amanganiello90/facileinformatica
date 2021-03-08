package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s3")
@PreAuthorize("hasRole('ROLE_USER')")
public class AwsS3Controller {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AwsS3Controller.class);


    AmazonS3ClientService s3Service;


    public AwsS3Controller(AmazonS3ClientService service) {
        this.s3Service = service;
    }

    @GetMapping("/createbucket")
    int createBucket() {
      LOGGER.info("Get request to /aws/createbucket");
        return s3Service.createBucket();
    }

}
