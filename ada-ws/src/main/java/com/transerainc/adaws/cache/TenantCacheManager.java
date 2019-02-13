/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.TenantDataModel;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Component
public class TenantCacheManager {
    private static Map<String, Map<String, TenantDataModel>> tacgTenants = new HashMap<String, Map<String, TenantDataModel>>();

    /**
     * @param serverIp
     * @param tenantData
     */
    public void populateTenants(final String heartBeatInterval, final String missedHeartBeatsAllowed,
            final String lostConnectionRecoveryTimeout, final String server, final String tenantName) {

        if (!tacgTenants.containsKey(server)) {
            final TenantDataModel tenantData = createTenantModel(heartBeatInterval, missedHeartBeatsAllowed,
                    lostConnectionRecoveryTimeout);
            tenantData.setTenantName(tenantName);

            final Map<String, TenantDataModel> tenant = new HashMap<String, TenantDataModel>();
            tenant.put(tenantName, tenantData);

            populateTenants(server, tenant);
        }
    }

    /**
     * @param serverIp
     * @param tenantData
     */
    public void populateTenants(final String serverIp, final TenantDataModel tenantData) {
        Map<String, TenantDataModel> tenants = new HashMap<String, TenantDataModel>();
        if (tacgTenants.containsKey(serverIp)) {
            tenants = tacgTenants.get(serverIp);
        }
        tenants.put(tenantData.getTenantName(), tenantData);

        populateTenants(serverIp, tenants);
    }

    /**
     * @param serverIp
     * @param tenants
     */
    public void populateTenants(final String serverIp, final Map<String, TenantDataModel> tenants) {
        synchronized (tacgTenants) {
            tacgTenants.put(serverIp, tenants);
        }
    }

    /**
     * 
     */
    public void clearTenants() {
        tacgTenants.clear();
    }

    /**
     * @param serverIp
     * @return
     */
    public Map<String, TenantDataModel> getTenant(final String serverIp) {
        return tacgTenants.get(serverIp);
    }

    /**
     * @param serverIp
     * @return
     */
    public List<TenantDataModel> getTenants(final String serverIp) {
        final List<TenantDataModel> tenants = new ArrayList<TenantDataModel>();
        if (tacgTenants.containsKey(serverIp)) {
            tenants.addAll(tacgTenants.get(serverIp).values());
        }

        return tenants;
    }

    /**
     * @param serverIp
     */
    public void removeTenant(final String serverIp) {
        tacgTenants.remove(serverIp);
    }

    /**
     * @param serverIp
     */
    public boolean tenantsSubscribed(final String serverIp) {
        return tacgTenants.containsKey(serverIp);
    }

    /**
     * @param serverIp
     * @param tenant
     */
    public void removeTenant(final String serverIp, final String tenant) {
        if (tacgTenants.containsKey(serverIp)) {
            final Map<String, TenantDataModel> tenants = tacgTenants.get(serverIp);

            if (tenants != null && tenants.containsKey(tenant)) {
                tenants.remove(tenant);
            }

            if (tenants == null || tenants.isEmpty()) {
                tacgTenants.remove(serverIp);
            } else {
                populateTenants(serverIp, tenants);
            }
        }
    }

    /**
     * @param clientId
     * @param hbInterval
     * @param missedHbsAllowed
     * @param connectionRecoveryTimeout
     * @return
     */
    private TenantDataModel createTenantModel(final String hbInterval, final String missedHbsAllowed,
            final String connectionRecoveryTimeout) {
        final TenantDataModel tenantModel = new TenantDataModel();

        if (StringUtils.isNotEmpty(hbInterval)) {
            tenantModel.setHeartBeatInterval(Integer.valueOf(hbInterval));
        }

        if (StringUtils.isNotEmpty(missedHbsAllowed)) {
            tenantModel.setMissedHeartBeatsAllowed(Integer.valueOf(missedHbsAllowed));
        }

        if (StringUtils.isNotEmpty(connectionRecoveryTimeout)) {
            tenantModel.setLostConnectionRecoveryTimeout(Integer.valueOf(connectionRecoveryTimeout));
        }

        return tenantModel;
    }
}
