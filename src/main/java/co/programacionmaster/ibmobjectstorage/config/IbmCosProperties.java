package co.programacionmaster.ibmobjectstorage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * IBM Cloud Object Storage related properties.
 */
@Data
@Component
@ConfigurationProperties(prefix = "ibm.cos")
public class IbmCosProperties {

  private String apiKey;

  private String bucketName;

  private String serviceInstanceId;

  private String endpointUrl;

  private String storageClass;

  private String location;
}
