package com.java.springcloud.properties;

import lombok.Data;

/**
 * SwaggerProperties
 *
 * @author TONE
 * @date 2019/8/9
 */
@Data
public class SwaggerProperties {

    private String title;

    private String description;

    private String version = "1.0";

    private String license = "Apache License 2.0";

    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

    private String contactName = "contactName";

    private String contactUrl = "contactUrl";

    private String contactEmail = "contactEmail";
}
