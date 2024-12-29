package io.github.aikusoni.gamegureumi.spring.testserver.constants;

import io.github.aikusoni.gamegureumi.spring.core.common.MessageCode;

import static io.github.aikusoni.gamegureumi.spring.core.common.MessageCode.of;

public interface TestMessageCode {
    MessageCode HAS_PERMISSION = of("test.has_permission");
}
