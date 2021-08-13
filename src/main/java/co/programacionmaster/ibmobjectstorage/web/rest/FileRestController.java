package co.programacionmaster.ibmobjectstorage.web.rest;

import co.programacionmaster.ibmobjectstorage.model.File;
import co.programacionmaster.ibmobjectstorage.service.FileService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
@AllArgsConstructor
public class FileRestController {

  private final FileService fileService;

  @GetMapping
  public ResponseEntity<List<File>> getAll() {
    return ResponseEntity.ok(fileService.getAll());
  }
}
