/*
 * http://www.jrecruiter.org
 * Disclaimer of Warranty.
 * Unless required by applicable law or agreed to in writing, Licensor provides
 * the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE,
 * NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are
 * solely responsible for determining the appropriateness of using or
 * redistributing the Work and assume any risks associated with Your exercise of
 * permissions under this License.
 */
package com.transerainc.adaws.util;

import java.util.Date;

/**
 * Log file information.
 *
 * @author Gunnar Hillert
 * @version $Id: LogFileInfo.java,v 1.1.2.1 2017/11/15 21:40:53 tri Exp $
 */
public class LogFileInfo {

    private String fileName;
    private Long fileSize;
    private Date fileLastChanged;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(final Long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getFileLastChanged() {
        return fileLastChanged;
    }

    public void setFileLastChanged(final Date fileLastChanged) {
        this.fileLastChanged = fileLastChanged;
    }

}
