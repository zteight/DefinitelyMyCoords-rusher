package lol.zt8;

import de.luludodo.definitelymycoords.api.DMCApi;
import org.rusherhack.client.api.feature.hud.TextHudElement;
import net.minecraft.world.phys.Vec3;
import org.rusherhack.client.api.render.graphic.TextureGraphic;

import java.text.DecimalFormat;


public class DMCoordinatesHud extends TextHudElement {
    private TextureGraphic graphic = null;

    public DMCoordinatesHud() {
        super("DMCoordinates", false);

        //try loading graphic
    }

    public String getText() {
        Vec3 pos = DMCApi.getOffset(mc.player.position());
        DecimalFormat format = new DecimalFormat("#,###.0");
        String x = format.format(pos.x());
        String y = format.format(pos.y());
        String z = format.format(pos.z());

        String dim = getDim();
        String dimCoords = "";
        if (dim.equals("the_nether")) {
            dimCoords = " ["+format.format(pos.x * 8)+", "+format.format(pos.z * 8)+"]";
        }
        if (dim.equals("overworld")) {
            dimCoords = " ["+format.format(pos.x / 8)+", "+format.format(pos.z / 8)+"]";
        }

        String output = "X: " + x + " Y: " + y + " Z: " + z + dimCoords;
        return output;
    }
    public String getDim() {
        return mc.level.dimension().location().getPath();
    }

}
