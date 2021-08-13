package co.programacionmaster.ibmobjectstorage.service;

import com.ibm.cloud.objectstorage.services.s3.model.S3ObjectSummary;
import java.util.List;
import org.springframework.core.io.Resource;

public interface ObjectCosService {

  /**
   * Get all object names.
   *
   * @return A new collection of Strings
   */
  List<S3ObjectSummary> getAllObjects();

  /**
   * Get object by Key.
   *
   * @param key unique key
   * @return A new {@link Resource} instance
   */
  Resource getObject(String key);
}
