package com.charles.financialhealth.customerconversation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class CustomerConversationApplication extends SpringBootServletInitializer {
  @Override
  protected  SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
    return builder.sources (CustomerConversationApplication.class);
  }
  public static void main (String str[]){
    SpringApplication.run(CustomerConversationApplication.class, str);
  }

}
