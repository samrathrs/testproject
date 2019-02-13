package com.transerainc.adaws.model.cache.contact.chat;

import java.util.Arrays;

/**
 * @author tnguyen
 *
 */
public class AdditionalData {

	private long[] suggestedTemplates;
	private long[] suggestedGuides;
	private String cherryPickComment;
	/**
	 * 
	 */
	public AdditionalData() {
	}

	/**
	 * @param suggestedTemplates
	 * @param suggestedGuides
	 */
	public AdditionalData(long[] suggestedTemplates, long[] suggestedGuides, String cherryPickComment) {
		this.suggestedTemplates = suggestedTemplates;
		this.suggestedGuides = suggestedGuides;
		this.cherryPickComment= cherryPickComment;
	}

	/**
	 * @return the suggestedTemplates
	 */
	public long[] getSuggestedTemplates() {
		return suggestedTemplates;
	}

	/**
	 * @param suggestedTemplates the suggestedTemplates to set
	 */
	public void setSuggestedTemplates(long[] suggestedTemplates) {
		this.suggestedTemplates = suggestedTemplates;
	}

	/**
	 * @return the suggestedGuides
	 */
	public long[] getSuggestedGuides() {
		return suggestedGuides;
	}

	/**
	 * @param suggestedGuides the suggestedGuides to set
	 */
	public void setSuggestedGuides(long[] suggestedGuides) {
		this.suggestedGuides = suggestedGuides;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdditionalData [suggestedTemplates=");
		builder.append(Arrays.toString(suggestedTemplates));
		builder.append(", suggestedGuides=");
		builder.append(Arrays.toString(suggestedGuides));
		builder.append(", cherryPickComment=");
		builder.append(cherryPickComment);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the cherryPickComment
	 */
	public String getCherryPickComment() {
		return cherryPickComment;
	}

	/**
	 * @param cherryPickComment the cherryPickComment to set
	 */
	public void setCherryPickComment(String cherryPickComment) {
		this.cherryPickComment = cherryPickComment;
	}

}
