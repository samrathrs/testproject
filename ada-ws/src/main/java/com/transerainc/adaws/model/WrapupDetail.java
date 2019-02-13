/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */

public class WrapupDetail {

	private String comment;
	private Long conversationStatus;
	private Long emotionTone;
	private Long urgencyTone;
	private Category category;
	private String  wrapUpComment;
	
	public WrapupDetail() {
	}

	/**
	 * @param comment
	 * @param conversationStatus
	 * @param emotionTone
	 * @param urgencyTone
	 * @param category
	 */
	public WrapupDetail(String comment, Long conversationStatus, Long emotionTone, Long urgencyTone,
			Category category, String wrapUpComment) {
		super();
		this.comment = comment;
		this.conversationStatus = conversationStatus;
		this.emotionTone = emotionTone;
		this.urgencyTone = urgencyTone;
		this.category = category;
		this.wrapUpComment = wrapUpComment;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the conversationStatus
	 */
	public Long getConversationStatus() {
		return conversationStatus;
	}

	/**
	 * @param conversationStatus the conversationStatus to set
	 */
	public void setConversationStatus(Long conversationStatus) {
		this.conversationStatus = conversationStatus;
	}

	/**
	 * @return the emotionTone
	 */
	public Long getEmotionTone() {
		return emotionTone;
	}

	/**
	 * @param emotionTone the emotionTone to set
	 */
	public void setEmotionTone(Long emotionTone) {
		this.emotionTone = emotionTone;
	}

	/**
	 * @return the urgencyTone
	 */
	public Long getUrgencyTone() {
		return urgencyTone;
	}

	/**
	 * @param urgencyTone the urgencyTone to set
	 */
	public void setUrgencyTone(Long urgencyTone) {
		this.urgencyTone = urgencyTone;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the wrapUpComment
	 */
	public String getWrapUpComment() {
		return wrapUpComment;
	}

	/**
	 * @param wrapUpComment the wrapUpComment to set
	 */
	public void setWrapUpComment(String wrapUpComment) {
		this.wrapUpComment = wrapUpComment;
	}
	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WrapupDetail [comment=");
		builder.append(comment);
		builder.append(", conversationStatus=");
		builder.append(conversationStatus);
		builder.append(", emotionTone=");
		builder.append(emotionTone);
		builder.append(", urgencyTone=");
		builder.append(urgencyTone);
		builder.append(", category=");
		if (category != null) {
			builder.append(category.debugToString());
		}
		else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
