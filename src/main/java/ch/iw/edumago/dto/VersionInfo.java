package ch.iw.edumago.dto;

import org.springframework.beans.factory.annotation.Value;

public class VersionInfo {
    @Value("${AWS_DEFAULT_REGION:not_found}")
    public String AWS_DEFAULT_REGION;

    @Value("${AWS_REGION:not_found}")
    public String AWS_REGION;

    @Value("${CODEBUILD_BUILD_ARN:not_found}")
    public String CODEBUILD_BUILD_ARN;

    @Value("${CODEBUILD_BUILD_ID:not_found}")
    public String CODEBUILD_BUILD_ID;

    @Value("${CODEBUILD_BUILD_IMAGE:not_found}")
    public String CODEBUILD_BUILD_IMAGE;

    @Value("${CODEBUILD_BUILD_NUMBER:not_found}")
    public String CODEBUILD_BUILD_NUMBER;

    @Value("${CODEBUILD_BUILD_SUCCEEDING:not_found}")
    public String CODEBUILD_BUILD_SUCCEEDING;

    @Value("${CODEBUILD_INITIATOR:not_found}")
    public String CODEBUILD_INITIATOR;

    @Value("${CODEBUILD_KMS_KEY_ID:not_found}")
    public String CODEBUILD_KMS_KEY_ID;

    @Value("${CODEBUILD_LOG_PATH:not_found}")
    public String CODEBUILD_LOG_PATH;

    @Value("${CODEBUILD_RESOLVED_SOURCE_VERSION:not_found}")
    public String CODEBUILD_RESOLVED_SOURCE_VERSION;

    @Value("${CODEBUILD_SOURCE_REPO_URL:not_found}")
    public String CODEBUILD_SOURCE_REPO_URL;

    @Value("${CODEBUILD_SOURCE_VERSION:not_found}")
    public String CODEBUILD_SOURCE_VERSION;

    @Value("${CODEBUILD_SRC_DIR:not_found}")
    public String CODEBUILD_SRC_DIR;

    @Value("${CODEBUILD_START_TIME:not_found}")
    public String CODEBUILD_START_TIME;

    @Value("${CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID:not_found}")
    public String CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID;

    @Value("${CODEBUILD_WEBHOOK_BASE_REF:not_found}")
    public String CODEBUILD_WEBHOOK_BASE_REF;

    @Value("${CODEBUILD_WEBHOOK_EVENT:not_found}")
    public String CODEBUILD_WEBHOOK_EVENT;

    @Value("${CODEBUILD_WEBHOOK_PREV_COMMIT:not_found}")
    public String CODEBUILD_WEBHOOK_PREV_COMMIT;

    @Value("${CODEBUILD_WEBHOOK_HEAD_REF:not_found}")
    public String CODEBUILD_WEBHOOK_HEAD_REF;

    @Value("${CODEBUILD_WEBHOOK_TRIGGER:not_found}")
    public String CODEBUILD_WEBHOOK_TRIGGER;

    @Value("${HOME:not_found}")
    public String HOME;
}