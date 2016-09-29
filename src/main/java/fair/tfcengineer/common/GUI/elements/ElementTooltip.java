package fair.tfcengineer.common.GUI.elements;

import cofh.lib.gui.GuiBase;

import java.util.List;

public class ElementTooltip extends ElementTFCE {

    private String[] tooltips;

    public ElementTooltip(GuiBase guiBase, int x, int y, int sizeX, int sizeY, String[] tooltips) {
        super(guiBase, x, y, sizeX, sizeY);
        this.tooltips = tooltips;
    }

    public ElementTooltip(GuiBase guiBase, int x, int y, int sizeX, int sizeY, String tooltip) {
        this(guiBase, x, y, sizeX, sizeY, new String[]{tooltip});
    }

    public void setTooltips(String[] tooltips) {
        this.tooltips = tooltips;
    }

    public void setTooltip(String tooltip) {
        this.tooltips = new String[]{tooltip};
    }

    public void addTooltip(List<String> var1) {
        for (String s : tooltips) {
            var1.add(s);
        }
    }


}
