package wst.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wst.generated.DB;

@Configuration
public class SoapConfig {

    @Bean
    public DB db(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(DB.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:7070/services/db");
        return (DB) jaxWsProxyFactoryBean.create();
    }
}
