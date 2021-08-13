package co.programacionmaster.ibmobjectstorage.web.rest;

import co.programacionmaster.ibmobjectstorage.model.File;
import co.programacionmaster.ibmobjectstorage.service.FileService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
@AllArgsConstructor
public class FileRestController {

  private final FileService fileService;

  /**
   * Get all files.
   *
   * @return A collection of {@link File}s
   */
  @GetMapping
  public ResponseEntity<List<File>> getAll() {
    return ResponseEntity.ok(fileService.getAll());
  }

  /**
   * Download file by name.
   *
   * @param name {@link File} name
   * @return A new {@link Resource} instance
   */
  @GetMapping("/download")
  public ResponseEntity<Resource> download(
      @RequestParam("name") String name
  ) {
    var resource = fileService.getFileAsResource(name);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }
}
