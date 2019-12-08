package skp.billionAttempts.model.utils.interfaces;

import java.util.Date;

public interface Creatable {

    Date getCreate();

    void setCreate(Date date);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

}
