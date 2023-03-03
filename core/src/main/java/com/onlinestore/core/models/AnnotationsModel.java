package com.onlinestore.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables =  SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AnnotationsModel {
    private static final Logger log = LoggerFactory.getLogger(AnnotationsModel.class);
    private String msg;
    @ValueMapValue
    private String title;
    @ValueMapValue
    private String desc;
    @Inject
    @Via("resource")
    private String fileReference;

    public String getTitle() {
        log.info("this is logger from title");
        return title;
    }

    public String getDesc() {
        log.info("this is logger from description");
        return desc;
    }
    public String getFileReference() {
        return fileReference;
    }
    @PostConstruct
    protected void init() {
        msg = "This is init method with post construct annotation";
        log.info(msg);
    }

    public String getMsg() {
        return msg;
    }

}
