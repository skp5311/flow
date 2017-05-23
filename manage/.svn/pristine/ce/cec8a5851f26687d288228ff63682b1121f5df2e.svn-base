package com.op.flow.manage.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by MengFanwei on 2016/09/21.
 */
@Component
public class FreemarkerViewTool extends FreeMarkerView {

    private static final String CONTEXT_PATH = "base";
    private static final String VERSION = "version";
    private static final String PLATFORM_MENU = "platformMenu";

    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        //base 访问域名
        String appContext = request.getContextPath();
        StringBuilder basePath = new StringBuilder();
        basePath.append(request.getScheme()).append("://");
        basePath.append(request.getServerName());
        if (request.getServerPort() != 80) {
            basePath.append(":").append(request.getServerPort());
        }
        basePath.append(appContext);
        model.put(CONTEXT_PATH, basePath.toString());
        super.exposeHelpers(model, request);
    }
}
