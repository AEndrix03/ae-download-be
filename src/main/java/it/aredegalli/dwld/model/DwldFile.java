package it.aredegalli.dwld.model;

import it.aredegalli.dwld.dto.FileDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "dwld_file")
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DwldFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "version")
    private String version;

    @Column(name = "private")
    private Boolean privateFile;

    @Lob
    @Column(name = "data", columnDefinition = "bytea")
    private byte[] data;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public FileDto toDto() {
        return new FileDto(this);
    }

}
