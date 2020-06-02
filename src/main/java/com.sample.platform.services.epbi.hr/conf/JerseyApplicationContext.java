package com.sample.platform.services.ebpi.hr.conf;

//import com.ebpi.sample.services.platform.resource.HrImpl;
import com.ebpi.sample.services.platform.resource.HrImpl;
import com.google.common.collect.Sets;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.DynamicFeature;

@Component
public class JerseyApplicationContext extends ResourceConfig {

    public JerseyApplicationContext(){
        super(Sets.newHashSet(DynamicFeature.class));
        register(HrImpl.class);
    }
}
