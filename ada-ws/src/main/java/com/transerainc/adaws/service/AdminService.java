/**
 *
 */
package com.transerainc.adaws.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.transerainc.adaws.model.AppInfo;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

/**
 * @author suresh.kumar
 */
@Service
public class AdminService {

    private static final long START_TIME = System.currentTimeMillis();

    public AppInfo info() {
        final AppInfo info = new AppInfo();
        info.setVersion(SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty("app.version"));
        info.setStartTime(new Timestamp(START_TIME));
        info.setCurrentTime(new Timestamp(System.currentTimeMillis()));
        return info;
    }

}
