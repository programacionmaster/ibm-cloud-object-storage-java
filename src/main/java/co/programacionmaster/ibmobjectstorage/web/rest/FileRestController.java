package co.programacionmaster.ibmobjectstorage.web.rest;

import co.programacionmaster.ibmobjectstorage.model.File;
import co.programacionmaster.ibmobjectstorage.service.FileService;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
   * Upload multiple files.
   */
  @PostMapping("/upload")
  public ResponseEntity<List<String>> upload(
      @RequestParam("files") MultipartFile[] files
  ) {
    List<String> response = Arrays
        .stream(files)
        .map(file -> {
          try {
            InputStream inputStream = file.getInputStream();
            return fileService.upload(file.getOriginalFilename(), inputStream,
                file.getBytes().length);
          } catch (IOException e) {
            e.printStackTrace();
          }
          return "";
        })
        .collect(Collectors.toList());
    return ResponseEntity.ok(response);
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
