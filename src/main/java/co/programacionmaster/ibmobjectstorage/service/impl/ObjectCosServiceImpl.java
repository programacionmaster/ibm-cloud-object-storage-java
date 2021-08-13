package co.programacionmaster.ibmobjectstorage.service.impl;

import co.programacionmaster.ibmobjectstorage.config.IbmCosProperties;
import co.programacionmaster.ibmobjectstorage.service.ObjectCosService;
import com.ibm.cloud.objectstorage.services.s3.AmazonS3;
import com.ibm.cloud.objectstorage.services.s3.model.ListObjectsRequest;
import com.ibm.cloud.objectstorage.services.s3.model.ObjectListing;
import com.ibm.cloud.objectstorage.services.s3.model.S3ObjectSummary;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ObjectCosServiceImpl implements ObjectCosService {

  private final IbmCosProperties ibmCosProperties;
  private final AmazonS3 amazonS3;

  public ObjectCosServiceImpl(
      IbmCosProperties ibmCosProperties,
      AmazonS3 amazonS3
  ) {
    this.ibmCosProperties = ibmCosProperties;
    this.amazonS3 = amazonS3;
  }

  @Override
  public List<S3ObjectSummary> getAllObjects() {
    ObjectListing objectListing = amazonS3.listObjects(
        new ListObjectsRequest().withBucketName(ibmCosProperties.getBucketName())
    );
    return objectListing.getObjectSummaries();
  }
}