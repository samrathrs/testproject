package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */

public class FollowUp {
    private Long reminderDateTime;
    private String reminderComments;

    public FollowUp() {
    }

    public FollowUp(Long reminderDateTime, String reminderComments) {
        this.reminderDateTime = reminderDateTime;
        this.reminderComments = reminderComments;
    }

    public final Long getReminderDateTime() {
        return this.reminderDateTime;
    }

    public final void setReminderDateTime(Long reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public final String getReminderComments() {
        return this.reminderComments;
    }

    public final void setReminderComments(String reminderComments) {
        this.reminderComments = reminderComments;
    }

    public String debugToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FollowUp [reminderDateTime=");
        builder.append(this.reminderDateTime);
        builder.append(", reminderComments=");
        builder.append(this.reminderComments);
        builder.append("]");
        return builder.toString();
    }
}