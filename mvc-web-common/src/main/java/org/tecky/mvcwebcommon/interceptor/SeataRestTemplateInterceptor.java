package org.tecky.mvcwebcommon.interceptor;

import io.seata.common.util.StringUtils;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

@Slf4j
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("Seata RestTemplate Interceptor");

        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
        String xid = RootContext.getXID();
        if (StringUtils.isNotEmpty(xid)) {
            requestWrapper.getHeaders().add(RootContext.KEY_XID, xid);
            log.info("Seata RestTemplate Interceptor :Add header xid=" + xid);

        }

        return execution.execute(requestWrapper, body);
    }
}