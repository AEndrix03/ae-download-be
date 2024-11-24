package it.aredegalli.dwld.dto;

import it.aredegalli.dwld.model.DwldFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    private Long id;
    private String name;
    private String description;
    private byte[] content;
    private LocalDateTime uploadDate;

    public FileDto(DwldFile dwldFile) {
        this.id = dwldFile.getId();
        this.name = dwldFile.getName();
        this.description = dwldFile.getDescription();
        this.content = dwldFile.getData();
        this.uploadDate = dwldFile.getCreationDate();
    }
}
