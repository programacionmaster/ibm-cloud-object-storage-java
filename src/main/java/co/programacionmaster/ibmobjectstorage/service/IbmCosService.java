package co.programacionmaster.ibmobjectstorage.service;

import com.ibm.cloud.objectstorage.services.s3.AmazonS3;

public interface IbmCosService {

  /**
   * Init Object Storage Service.
   *
   * @return A new {@link AmazonS3} instance
   */
  AmazonS3 init();
}