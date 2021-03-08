package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonSqsClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sqs")
@RestController
@PreAuthorize("hasRole('ROLE_USER')")
public class AwsSqsController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AwsSqsController.class);
  
  AmazonSqsClientService sqsService;
  
  public AwsSqsController(AmazonSqsClientService sqsService) {
    this.sqsService = sqsService;
  }
  
  @GetMapping("/createqueue")
  String createQueue() {
    LOGGER.info("Get request to /aws/createqueue");
    return sqsService.createQueue();
  }
  
}
