package io.github.aikusoni.gamegureumi.spring.mvcstandard.constants;

import io.github.aikusoni.gamegureumi.spring.core.common.MessageCode;

public interface WebMvcTestMessageCode {
    MessageCode ADMIN_PERMISSION = MessageCode.of("mvc.admin_permission");
    MessageCode LOCALE_CONFIG_TEST = MessageCode.of("mvc.locale_config_test");
    MessageCode USER_PERMISSION = MessageCode.of("mvc.user_permission");
    MessageCode WITH_MESSAGE = MessageCode.of("mvc.with_message");
}
