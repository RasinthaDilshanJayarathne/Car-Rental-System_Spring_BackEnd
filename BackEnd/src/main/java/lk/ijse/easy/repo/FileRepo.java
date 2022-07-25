package lk.ijse.easy.repo;

import lk.ijse.easy.entity.File;
import lk.ijse.easy.enums.ReferencedType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File,String> {

    boolean existsByReferencedIdAndReferencedType(String referencedId, ReferencedType referencedType);

    File findByReferencedIdAndReferencedType(String referencedId, ReferencedType referencedType);
}
