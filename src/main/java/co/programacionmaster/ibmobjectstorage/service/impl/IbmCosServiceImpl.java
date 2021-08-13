package co.programacionmaster.ibmobjectstorage.service.impl;

import co.programacionmaster.ibmobjectstorage.config.IbmCosProperties;
import co.programacionmaster.ibmobjectstorage.service.IbmCosService;
import com.ibm.cloud.objectstorage.ClientConfiguration;
import com.ibm.cloud.objectstorage.auth.AWSCredentials;
import com.ibm.cloud.objectstorage.auth.AWSStaticCredentialsProvider;
import com.ibm.cloud.objectstorage.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.ibm.cloud.objectstorage.oauth.BasicIBMOAuthCredentials;
import com.ibm.cloud.objectstorage.services.s3.AmazonS3;
import com.ibm.cloud.objectstorage.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class IbmCosServiceImpl implements IbmCosService {

  private final IbmCosProperties ibmCosProperties;

  public IbmCosServiceImpl(IbmCosProperties ibmCosProperties) {
    this.ibmCosProperties = ibmCosProperties;
  }

  @Override
  public AmazonS3 init() {
    AWSCredentials credentials = new BasicIBMOAuthCredentials(
        ibmCosProperties.getApiKey(),
        ibmCosProperties.getServiceInstanceId()
    );
    ClientConfiguration clientConfig = new ClientConfiguration()
        .withRequestTimeout(5000)
        .withTcpKeepAlive(true);

    return AmazonS3ClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withEndpointConfiguration(new EndpointConfiguration(
            ibmCosProperties.getEndpointUrl(),
            ibmCosProperties.getLocation()
        ))
        .withPathStyleAccessEnabled(true)
        .withClientConfiguration(clientConfig)
        .build();
  }
}