package it.aredegalli.dwld.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "dwld_cat_file_lnk")
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DwldCatFileLnk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "order")
    private Integer order;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwld_cat_id")
    private DwldCat dwldCat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwld_file_id")
    private DwldFile dwldFile;

}
