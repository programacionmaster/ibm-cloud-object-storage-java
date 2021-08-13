package co.programacionmaster.ibmobjectstorage.service.impl;

import co.programacionmaster.ibmobjectstorage.model.File;
import co.programacionmaster.ibmobjectstorage.service.FileService;
import co.programacionmaster.ibmobjectstorage.service.ObjectCosService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

  private final ObjectCosService objectCosService;

  public FileServiceImpl(ObjectCosService objectCosService) {
    this.objectCosService = objectCosService;
  }

  @Override
  public List<File> getAll() {
    return objectCosService
        .getAllObjects()
        .stream()
        .map(objectSummary -> new File(
                objectSummary.getKey(),
                objectSummary.getSize(),
                objectSummary.getLastModified()
            )
        )
        .collect(Collectors.toList());
  }

  @Override
  public String upload(String name, InputStream inputStream, int length) {
    try {
      return objectCosService.uploadObject(name, inputStream, length);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public Resource getFileAsResource(String fileName) {
    return objectCosService.getObject(fileName);
  }
}
