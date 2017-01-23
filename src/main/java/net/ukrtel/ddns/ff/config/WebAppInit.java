package net.ukrtel.ddns.ff.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class, SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    // to handle multipart requests and file uploads
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        // temp dir to store data while uploads
                        System.getProperty("java.io.tmpdir") + File.separator + "spittr" + File.separator + "uploads",
                        /*"D:\\temp\\spittr\\uploads",*/

                        // The maximum size (in bytes) of any file uploaded(2 Mb). By default there is no limit.
                        2097152,

                        // The maximum size (in bytes) of the entire multipart request (4 Mb),
                        // regardless of how many parts or how big any of the parts are. By default there is no limit.
                        4194304,

                        // The maximum size (in bytes) of a file that can be uploaded without being written
                        // to the temporary location. The default is 0, meaning that all uploaded files
                        // will be written to disk.
                        0
                )
        );
    }
}
