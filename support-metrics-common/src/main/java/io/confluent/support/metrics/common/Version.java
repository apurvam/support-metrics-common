package io.confluent.support.metrics.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class Version {

  private static final Logger log = LoggerFactory.getLogger(Version.class);
  private static String version = "unknown";

  static {
    try {
      Properties props = new Properties();
      props.load(Version.class.getResourceAsStream("/support-metrics-common-version.properties"));
      version = props.getProperty("version", version).trim();
    } catch (IOException e) {
      log.warn("Error while loading version:", e.getMessage());
    }
  }

  public static String getVersion() {
    return version;
  }

}