package co.programacionmaster.ibmobjectstorage.service.impl;

import co.programacionmaster.ibmobjectstorage.model.File;
import co.programacionmaster.ibmobjectstorage.service.FileService;
import co.programacionmaster.ibmobjectstorage.service.ObjectCosService;
import java.util.List;
import java.util.stream.Collectors;
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
}
