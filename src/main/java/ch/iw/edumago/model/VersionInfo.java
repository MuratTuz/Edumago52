package ch.iw.edumago.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VersionInfo {

    private static final String AWS_DEFAULT_REGION = "AWS_DEFAULT_REGION";
    private static final String AWS_REGION = "AWS_REGION";
    private static final String CODEBUILD_BUILD_ARN = "CODEBUILD_BUILD_ARN";
    private static final String CODEBUILD_BUILD_ID = "CODEBUILD_BUILD_ID";
    private static final String CODEBUILD_BUILD_IMAGE = "CODEBUILD_BUILD_IMAGE";
    private static final String CODEBUILD_BUILD_NUMBER = "CODEBUILD_BUILD_NUMBER";
    private static final String CODEBUILD_BUILD_SUCCEEDING = "CODEBUILD_BUILD_SUCCEEDING";
    private static final String CODEBUILD_INITIATOR = "CODEBUILD_INITIATOR";
    private static final String CODEBUILD_KMS_KEY_ID = "CODEBUILD_KMS_KEY_ID";
    private static final String CODEBUILD_LOG_PATH = "CODEBUILD_LOG_PATH";
    private static final String CODEBUILD_RESOLVED_SOURCE_VERSION = "CODEBUILD_RESOLVED_SOURCE_VERSION";
    private static final String CODEBUILD_SOURCE_REPO_URL = "CODEBUILD_SOURCE_REPO_URL";
    private static final String CODEBUILD_SOURCE_VERSION = "CODEBUILD_SOURCE_VERSION";
    private static final String CODEBUILD_SRC_DIR = "CODEBUILD_SRC_DIR";
    private static final String CODEBUILD_START_TIME = "CODEBUILD_START_TIME";
    private static final String CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID = "CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID";
    private static final String CODEBUILD_WEBHOOK_BASE_REF = "CODEBUILD_WEBHOOK_BASE_REF";
    private static final String CODEBUILD_WEBHOOK_EVENT = "CODEBUILD_WEBHOOK_EVENT";
    private static final String CODEBUILD_WEBHOOK_PREV_COMMIT = "CODEBUILD_WEBHOOK_PREV_COMMIT";
    private static final String CODEBUILD_WEBHOOK_HEAD_REF = "CODEBUILD_WEBHOOK_HEAD_REF";
    private static final String CODEBUILD_WEBHOOK_TRIGGER = "CODEBUILD_WEBHOOK_TRIGGER";

    public String DEFAULT_REGION;

    public String REGION;

    public String BUILD_ARN;

    public String BUILD_ID;

    public String BUILD_IMAGE;

    public String BUILD_NUMBER;

    public String BUILD_SUCCEEDING;

    public String INITIATOR;

    public String KMS_KEY_ID;

    public String LOG_PATH;

    public String RESOLVED_SOURCE_VERSION;

    public String SOURCE_REPO_URL;

    public String SOURCE_VERSION;

    public String SRC_DIR;

    public String START_TIME;

    public String WEBHOOK_ACTOR_ACCOUNT_ID;

    public String WEBHOOK_BASE_REF;

    public String WEBHOOK_EVENT;

    public String WEBHOOK_PREV_COMMIT;

    public String WEBHOOK_HEAD_REF;

    public String WEBHOOK_TRIGGER;

    public VersionInfo get() {
        VersionInfo info = new VersionInfo();

        info.DEFAULT_REGION = System.getenv(AWS_DEFAULT_REGION);
        info.REGION = System.getenv(AWS_REGION);
        info.BUILD_ARN = System.getenv(CODEBUILD_BUILD_ARN);
        info.BUILD_ID = System.getenv(CODEBUILD_BUILD_ID);
        info.BUILD_IMAGE = System.getenv(CODEBUILD_BUILD_IMAGE);
        info.BUILD_NUMBER = System.getenv(CODEBUILD_BUILD_NUMBER);
        info.BUILD_SUCCEEDING = System.getenv(CODEBUILD_BUILD_SUCCEEDING);
        info.INITIATOR = System.getenv(CODEBUILD_INITIATOR);
        info.KMS_KEY_ID = System.getenv(CODEBUILD_KMS_KEY_ID);
        info.LOG_PATH = System.getenv(CODEBUILD_LOG_PATH);
        info.RESOLVED_SOURCE_VERSION = System.getenv(CODEBUILD_RESOLVED_SOURCE_VERSION);
        info.SOURCE_REPO_URL = System.getenv(CODEBUILD_SOURCE_REPO_URL);
        info.SOURCE_VERSION = System.getenv(CODEBUILD_SOURCE_VERSION);
        info.SRC_DIR = System.getenv(CODEBUILD_SRC_DIR);
        info.START_TIME = this.getFormattedDate(System.getenv(CODEBUILD_START_TIME));
        info.WEBHOOK_ACTOR_ACCOUNT_ID = System.getenv(CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID);
        info.WEBHOOK_BASE_REF = System.getenv(CODEBUILD_WEBHOOK_BASE_REF);
        info.WEBHOOK_EVENT = System.getenv(CODEBUILD_WEBHOOK_EVENT);
        info.WEBHOOK_PREV_COMMIT = System.getenv(CODEBUILD_WEBHOOK_PREV_COMMIT);
        info.WEBHOOK_HEAD_REF = System.getenv(CODEBUILD_WEBHOOK_HEAD_REF);
        info.WEBHOOK_TRIGGER = System.getenv(CODEBUILD_WEBHOOK_TRIGGER);

        return info;
    }

    private String getFormattedDate(String date) {
        try {
            return new SimpleDateFormat("dd.M.yyyy HH:mm:ss")
                    .format(new Date(Long.parseLong(date)));
        } catch (Exception ex) {
            return null;
        }
    }
}