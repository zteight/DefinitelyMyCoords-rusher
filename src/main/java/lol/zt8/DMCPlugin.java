package lol.zt8;

import lol.zt8.DMCoordinatesHud;
import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class DMCPlugin extends Plugin {
    @Override
    public void onLoad() {

        //logger
        this.getLogger().info("Initializing rusherhack-DMCoords");

        //creating and registering a new hud element
        final DMCoordinatesHud dmCoords = new DMCoordinatesHud();
        RusherHackAPI.getHudManager().registerFeature(dmCoords);

    }

    @Override
    public void onUnload() {
        this.getLogger().info("DMCoords plugin unloaded!");
    }
}
