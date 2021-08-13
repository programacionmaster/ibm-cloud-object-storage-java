package co.programacionmaster.ibmobjectstorage.service;

import com.ibm.cloud.objectstorage.services.s3.model.S3ObjectSummary;
import java.util.List;

public interface ObjectCosService {

  /**
   * Get all object names.
   *
   * @return A new collection of Strings
   */
  List<S3ObjectSummary> getAllObjects();
}
