package com.charles.financialhealth.customerconversation.configuration;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotaion.Import;
import org.springframework.context.support.PropertySourcePlaceholderConfigurer;

import com.wellsfargo.component.customerform.configuration.CustomerFormsSpringConfiguration;
import com.wellsfargo.jsk.persistence.configuration.BaseRepositoryConfiguration;

import core.config.LayeredConfigPropertiesAdaptor;


@Configuration
@import({BaseRepositoryConfiguration.class, CustomerFormsSpringConfiguration.class})
public class CustomerConversationConfiguration {
  private static final int keyStorePasswordMaxLength = 100;
  private static void setKeyStorePassword (String keyStoreFilePath ) throws IOException {
  
    String pswd = null;
    BufferedReader br = null;
    try {
      br = new BufferedReader (new InputStreamReader (new FileInputStream(keyStoreFilePath), Charset.defaultCharset()));

      StringBuffer sb = new StringBuffer();
      int value;
      while((value = br.read())!= -1){
        char charValue = (char) value;
        if(charValue == '\n') {
            break;
        }

        if(sb.length() > = keyStorePasswordMaxLength  ){
            throw new IOException("Password Input too long");
        }

        sb.append(charValue);
      }
      pswd = sb.toString();
      if(pswd != null) {
          System.setProperty("javax.net.ssll.keyStorePassword", pswd);
      }
    
    
    } catch (IOException e) {
        throw e;
    }
    finally {
      try {
        if (null != br){
          br.close();
        }
      }catch (IOException e){
          e.printStackTrace();
      }
    
    }
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
  
      PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
      propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
      propertySourcesPlaceholderConfigurer.setProperties(
            LayeredConfigPropertiesAdaptor.initGlobalConfiguration()
          );

      final String keyStorePassword = LayeredConfigPropertiesAdaptor.getProperties().getProperty("javax.net.ssl.keyStorePassword");
      setKeyStorePassword (keyStorePassword);
      return propertySourcesPlaceholderConfigurer;
  
  }




}























