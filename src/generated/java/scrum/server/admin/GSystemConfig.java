// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.EntityGenerator










package scrum.server.admin;

import java.util.*;
import ilarkesto.persistence.*;
import ilarkesto.core.logging.Log;
import ilarkesto.base.*;
import ilarkesto.base.time.*;
import ilarkesto.auth.*;

public abstract class GSystemConfig
            extends AEntity
            implements ilarkesto.auth.ViewProtected<scrum.server.admin.User>, java.lang.Comparable<SystemConfig> {

    // --- AEntity ---

    public final SystemConfigDao getDao() {
        return systemConfigDao;
    }

    protected void repairDeadDatob(ADatob datob) {
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("googleAnalyticsId", this.googleAnalyticsId);
        properties.put("smtpServer", this.smtpServer);
        properties.put("smtpUser", this.smtpUser);
        properties.put("smtpPassword", this.smtpPassword);
    }

    public int compareTo(SystemConfig other) {
        return toString().toLowerCase().compareTo(other.toString().toLowerCase());
    }

    private static final ilarkesto.core.logging.Log LOG = ilarkesto.core.logging.Log.get(GSystemConfig.class);

    public static final String TYPE = "systemConfig";

    // -----------------------------------------------------------
    // - googleAnalyticsId
    // -----------------------------------------------------------

    private java.lang.String googleAnalyticsId;

    public final java.lang.String getGoogleAnalyticsId() {
        return googleAnalyticsId;
    }

    public final void setGoogleAnalyticsId(java.lang.String googleAnalyticsId) {
        googleAnalyticsId = prepareGoogleAnalyticsId(googleAnalyticsId);
        if (isGoogleAnalyticsId(googleAnalyticsId)) return;
        this.googleAnalyticsId = googleAnalyticsId;
        fireModified();
    }

    protected java.lang.String prepareGoogleAnalyticsId(java.lang.String googleAnalyticsId) {
        googleAnalyticsId = Str.removeUnreadableChars(googleAnalyticsId);
        return googleAnalyticsId;
    }

    public final boolean isGoogleAnalyticsIdSet() {
        return this.googleAnalyticsId != null;
    }

    public final boolean isGoogleAnalyticsId(java.lang.String googleAnalyticsId) {
        if (this.googleAnalyticsId == null && googleAnalyticsId == null) return true;
        return this.googleAnalyticsId != null && this.googleAnalyticsId.equals(googleAnalyticsId);
    }

    protected final void updateGoogleAnalyticsId(Object value) {
        setGoogleAnalyticsId((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - smtpServer
    // -----------------------------------------------------------

    private java.lang.String smtpServer;

    public final java.lang.String getSmtpServer() {
        return smtpServer;
    }

    public final void setSmtpServer(java.lang.String smtpServer) {
        smtpServer = prepareSmtpServer(smtpServer);
        if (isSmtpServer(smtpServer)) return;
        this.smtpServer = smtpServer;
        fireModified();
    }

    protected java.lang.String prepareSmtpServer(java.lang.String smtpServer) {
        smtpServer = Str.removeUnreadableChars(smtpServer);
        return smtpServer;
    }

    public final boolean isSmtpServerSet() {
        return this.smtpServer != null;
    }

    public final boolean isSmtpServer(java.lang.String smtpServer) {
        if (this.smtpServer == null && smtpServer == null) return true;
        return this.smtpServer != null && this.smtpServer.equals(smtpServer);
    }

    protected final void updateSmtpServer(Object value) {
        setSmtpServer((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - smtpUser
    // -----------------------------------------------------------

    private java.lang.String smtpUser;

    public final java.lang.String getSmtpUser() {
        return smtpUser;
    }

    public final void setSmtpUser(java.lang.String smtpUser) {
        smtpUser = prepareSmtpUser(smtpUser);
        if (isSmtpUser(smtpUser)) return;
        this.smtpUser = smtpUser;
        fireModified();
    }

    protected java.lang.String prepareSmtpUser(java.lang.String smtpUser) {
        smtpUser = Str.removeUnreadableChars(smtpUser);
        return smtpUser;
    }

    public final boolean isSmtpUserSet() {
        return this.smtpUser != null;
    }

    public final boolean isSmtpUser(java.lang.String smtpUser) {
        if (this.smtpUser == null && smtpUser == null) return true;
        return this.smtpUser != null && this.smtpUser.equals(smtpUser);
    }

    protected final void updateSmtpUser(Object value) {
        setSmtpUser((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - smtpPassword
    // -----------------------------------------------------------

    private java.lang.String smtpPassword;

    public final java.lang.String getSmtpPassword() {
        return smtpPassword;
    }

    public final void setSmtpPassword(java.lang.String smtpPassword) {
        smtpPassword = prepareSmtpPassword(smtpPassword);
        if (isSmtpPassword(smtpPassword)) return;
        this.smtpPassword = smtpPassword;
        fireModified();
    }

    protected java.lang.String prepareSmtpPassword(java.lang.String smtpPassword) {
        smtpPassword = Str.removeUnreadableChars(smtpPassword);
        return smtpPassword;
    }

    public final boolean isSmtpPasswordSet() {
        return this.smtpPassword != null;
    }

    public final boolean isSmtpPassword(java.lang.String smtpPassword) {
        if (this.smtpPassword == null && smtpPassword == null) return true;
        return this.smtpPassword != null && this.smtpPassword.equals(smtpPassword);
    }

    protected final void updateSmtpPassword(Object value) {
        setSmtpPassword((java.lang.String)value);
    }

    public void updateProperties(Map<?, ?> properties) {
        for (Map.Entry entry : properties.entrySet()) {
            String property = (String) entry.getKey();
            if (property.equals("id")) continue;
            Object value = entry.getValue();
            if (property.equals("googleAnalyticsId")) updateGoogleAnalyticsId(value);
            if (property.equals("smtpServer")) updateSmtpServer(value);
            if (property.equals("smtpUser")) updateSmtpUser(value);
            if (property.equals("smtpPassword")) updateSmtpPassword(value);
        }
    }

    protected void repairDeadReferences(String entityId) {
        super.repairDeadReferences(entityId);
    }

    // --- ensure integrity ---

    public void ensureIntegrity() {
        super.ensureIntegrity();
    }

    static SystemConfigDao systemConfigDao;

    public static final void setSystemConfigDao(SystemConfigDao systemConfigDao) {
        GSystemConfig.systemConfigDao = systemConfigDao;
    }

}