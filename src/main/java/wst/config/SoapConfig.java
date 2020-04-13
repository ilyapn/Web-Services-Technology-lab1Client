package wst.config;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.security.SimpleAuthorizingInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.HTTPConduit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
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

    @Bean
    public Client ticketAgentClientProxy() {
        return ClientProxy.getClient(db());
    }

    @Bean
    public HTTPConduit ticketAgentConduit() {
        HTTPConduit httpConduit = (HTTPConduit) ticketAgentClientProxy().getConduit();
        httpConduit.setAuthorization(basicAuthorization());

        return httpConduit;
    }

    @Bean
    public AuthorizationPolicy basicAuthorization() {
        AuthorizationPolicy authorizationPolicy =
                new AuthorizationPolicy();
        authorizationPolicy.setUserName("1");
        authorizationPolicy.setPassword("1");
        authorizationPolicy.setAuthorizationType("Basic");

        return authorizationPolicy;
    }
}
