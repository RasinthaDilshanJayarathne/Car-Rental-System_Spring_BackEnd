package lk.ijse.easy.entity;

import lk.ijse.easy.enums.ReferencedType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class File {
    @Id
    @GeneratedValue
    private int id;
    private String referencedId;
    @Enumerated(EnumType.STRING)
    private ReferencedType referencedType;
    private String filePath;

    public File(String referencedId, ReferencedType referencedType, String filePath) {
        this.referencedId = referencedId;
        this.referencedType = referencedType;
        this.filePath = filePath;
    }
}
