package skp.billionAttempts.model.utils;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import skp.billionAttempts.model.utils.enums.EStatus;
import skp.billionAttempts.model.utils.interfaces.Creatable;
import skp.billionAttempts.model.utils.interfaces.Updatable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus status;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

}
