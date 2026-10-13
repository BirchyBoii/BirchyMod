package net.birchyboii.birchy.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class BirchisizerCategory implements DisplayCategory<BasicDisplay> {
    private static final Identifier TEXTURE = Identifier.of(BirchyMod.MOD_ID,
            "textures/gui/birchisizer/birchisizer_gui.png");
    public static final CategoryIdentifier<BirchisizerDisplay> BIRCHISIZER =
            CategoryIdentifier.of(BirchyMod.MOD_ID, "birchisizer");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return BIRCHISIZER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.birchy.birchisizer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.BIRCHISIZER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 54, startPoint.y + 34))
                .entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 104, startPoint.y + 34))
                .entries(display.getOutputEntries().get(0)).markOutput());


        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
