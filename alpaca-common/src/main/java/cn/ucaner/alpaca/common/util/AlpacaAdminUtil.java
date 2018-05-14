package cn.ucaner.alpaca.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压alpacaAdmin-x.x.x.jar到resources目录
 */
public class AlpacaAdminUtil implements InitializingBean, ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlpacaAdminUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("===== 开始解压alpaca-admin =====");
        String version = PropertiesFileUtil.getInstance("alpaca-admin-client").get("alpaca.admin.version");
        LOGGER.info("alpaca-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/alpaca-admin-" + version + ".jar");
        LOGGER.info("alpaca-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/alpaca-admin";
        LOGGER.info("alpaca-admin.jar 解压到: {}", resources);
        JarUtil.decompress(jarPath, resources);
        LOGGER.info("===== 解压alpaca-admin完成 =====");
    }

}
