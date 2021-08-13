package co.programacionmaster.ibmobjectstorage.service;

import co.programacionmaster.ibmobjectstorage.model.File;
import java.io.InputStream;
import java.util.List;
import org.springframework.core.io.Resource;

public interface FileService {

  List<File> getAll();

  String upload(String name, InputStream inputStream, int length);

  Resource getFileAsResource(String fileName);
}
