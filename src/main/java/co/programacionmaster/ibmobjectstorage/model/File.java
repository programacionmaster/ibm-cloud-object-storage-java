package co.programacionmaster.ibmobjectstorage.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File {

  private String name;

  private Long size;

  private Date lastModified;
}
