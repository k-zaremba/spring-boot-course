package com.sunner.sbhibernateh2relations;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2Config {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server getServer() throws SQLException {
        return Server.createTcpServer("-tcp");
    }
}
