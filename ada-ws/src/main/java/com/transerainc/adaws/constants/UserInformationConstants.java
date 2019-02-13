/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author tnguyen
 *
 */
public interface UserInformationConstants {

    // HTTP Header Constants
    public static final String HTTP_HEADER_FROM_KEY = "From";
    public static final String HTTP_HEADER_AUTHORIZATION_KEY = "Authorization";
    public static final String HTTP_HEADER_AUTHORIZATION_FORMAT_TEMPLATE = "%s; user=%s";

    // URL Constants
    public static final String URL_QUERY_PARAMETER_SEPARATOR = "?";
    public static final String URL_LOGIN_PARAMETER = "login__s=%s";
    public static final String URL_LOGIN_QUERY_PARAMETER = "login__s";
    public static final String URI_TENANT_API = "/security/tenants";

    // JSON Constants
    public static final String JSON_ATTRIBUTE_ENTERPRISE_KEY = "name";
}
