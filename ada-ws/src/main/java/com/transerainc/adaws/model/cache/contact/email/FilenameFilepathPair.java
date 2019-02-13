package com.transerainc.adaws.model.cache.contact.email;

import java.util.Collection;

import org.json.JSONObject;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tringuyen
 *
 */
public class FilenameFilepathPair {

	private String fileName;
	private String filePath;

	/**
	 * 
	 */
	public FilenameFilepathPair() {
	}

	/**
	 * @param id
	 * @param fileName
	 * @param filePath
	 */
	public FilenameFilepathPair(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilenameFilepathPair [fileName=");
		builder.append(fileName);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject filenameFilepathPairJsonObject = new JSONObject();
		filenameFilepathPairJsonObject.put(StateCacheConstants.FILE_NAME_KEY, fileName);
		filenameFilepathPairJsonObject.put(StateCacheConstants.FILE_PATH_KEY, filePath);
		return filenameFilepathPairJsonObject;
	}

}
