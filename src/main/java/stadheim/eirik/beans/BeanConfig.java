package stadheim.eirik.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by eirikstadheim on 22/03/2017.
 */

@Configuration
public class BeanConfig {
    @Component
    @Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
    public class User implements Serializable {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean checkAuth() {
            return username != null;
        }
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(1000*60*60*24*60);
        factory.setConnectTimeout(1000*60*60*24*60);
        System.out.println("satt session...");
        return factory;
    }
}