package skp.billionAttempts.model.utils.interfaces;

import java.util.Date;

public interface Updatable {

    Date getUpdate();

    void setUpdate(Date updateTs);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

}
