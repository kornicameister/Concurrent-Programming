package org.cp.monitor.threads;

import org.apache.log4j.Logger;
import org.cp.monitor.resources.ResourceB;

/**
 * Created by: Nappa
 * Version: 0.01
 * Since: 0.01
 */
public class MonitorB extends MonitorRunnable  {

    protected Logger logger=Logger.getLogger(MonitorB.class);

    ResourceB resourceB;

    @Override
    public void run() {
        while (roundNumber <= roundsAmount) {
            try {
                logger.info("Trying to acquire resource");

                resourceB = RESOURCE_B_RESOURCES_POOL.acquireResource();

                logger.info(String.format("Round %d: I acquire %s",roundNumber,resourceB));

                RESOURCE_B_RESOURCES_POOL.releaseResource(resourceB);

                logger.info("Released resource");

            } catch (Exception e) {
                logger.error(e);
            }
            roundNumber++;
        }

    }
}
