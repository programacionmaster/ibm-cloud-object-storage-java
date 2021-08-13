package co.programacionmaster.ibmobjectstorage.service;

import co.programacionmaster.ibmobjectstorage.model.File;
import java.util.List;
import org.springframework.core.io.Resource;

public interface FileService {

  List<File> getAll();

  Resource getFileAsResource(String fileName);
}
