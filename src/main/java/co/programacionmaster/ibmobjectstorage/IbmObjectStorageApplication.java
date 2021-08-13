package co.programacionmaster.ibmobjectstorage;

import co.programacionmaster.ibmobjectstorage.config.IbmCosProperties;
import co.programacionmaster.ibmobjectstorage.service.IbmCosService;
import co.programacionmaster.ibmobjectstorage.service.impl.IbmCosServiceImpl;
import co.programacionmaster.ibmobjectstorage.web.rest.FileRestController;
import com.ibm.cloud.objectstorage.services.s3.AmazonS3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
    IbmCosProperties.class,
    IbmCosServiceImpl.class,
    FileRestController.class
})
public class IbmObjectStorageApplication {

  public static void main(String[] args) {
    SpringApplication.run(IbmObjectStorageApplication.class, args);
  }

  @Bean
  AmazonS3 amazonS3Client(IbmCosService ibmCosService) {
    return ibmCosService.init();
  }
}