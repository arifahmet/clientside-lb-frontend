package com.arif.lb.frontend.configuration;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class SleuthConfiguration {

    @Bean
    SpanHandler handlerOne() {
        return new SpanHandler() {
            @Override
            public boolean end(TraceContext traceContext, MutableSpan span,
                               Cause cause) {
                span.localIp(getIp());
                span.remoteIp(getIp());
                span.localServiceName(getInfo());
                return true; // keep this span
            }

            private String getInfo() {
                String res = "lb-backend-deployment";
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    res = inetAddress.getHostName();
                } catch (UnknownHostException ignored) {
                }
                return res;
            }

            private String getIp() {
                String res = "lb-backend-deployment";
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    res = inetAddress.getHostAddress();
                } catch (UnknownHostException ignored) {
                }
                return res;
            }
        };
    }
}
