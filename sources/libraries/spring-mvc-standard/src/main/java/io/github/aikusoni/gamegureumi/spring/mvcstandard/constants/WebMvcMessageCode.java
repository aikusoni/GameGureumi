package io.github.aikusoni.gamegureumi.spring.mvcstandard.constants;

import io.github.aikusoni.gamegureumi.spring.core.common.MessageCode;

import static io.github.aikusoni.gamegureumi.spring.core.common.MessageCode.of;

public interface WebMvcMessageCode {
    MessageCode LANGUAGE = of("mvc.language");
    MessageCode LANGUAGE_DISPLAY = of("mvc.language.display");
    MessageCode FAILED_TO_ACCESS_SERVER_ERROR = of("mvc.failed_to_access_server_error");
    MessageCode NO_PERMISSION = of("mvc.no_permission");
    MessageCode NO_REQUEST_ATTRIBUTES = of("mvc.no_request_attributes");
    MessageCode NO_ROLES = of("mvc.no_roles");
}
