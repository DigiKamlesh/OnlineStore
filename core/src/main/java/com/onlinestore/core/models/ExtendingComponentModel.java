package com.onlinestore.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class ExtendingComponentModel{

   @ValueMapValue
    private String text;
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String fileReference;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getFileReference() {
        return fileReference;
    }
}
