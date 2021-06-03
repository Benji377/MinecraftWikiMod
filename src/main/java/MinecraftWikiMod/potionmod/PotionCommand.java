package MinecraftWikiMod.potionmod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;

public class PotionCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> potionCommand
                = Commands.literal("potion")
                .requires((commandSource) -> commandSource.hasPermissionLevel(1))
                .then(Commands.literal("RegenerationPotion")
                        .executes(commandContext -> sendMessage(commandContext, regenerationPotion()))
                )
                .then(Commands.literal("SwiftnessPotion")
                        .executes(commandContext -> sendMessage(commandContext, swiftnessPotion()))
                )
                .then(Commands.literal("FireResistancePotion")
                        .executes(commandContext -> sendMessage(commandContext, fireResistancePotion()))
                )
                .then(Commands.literal("HealingPotion")
                        .executes(commandContext -> sendMessage(commandContext, healingPotion()))
                )
                .then(Commands.literal("NightVisionPotion")
                        .executes(commandContext -> sendMessage(commandContext, nightVisionPotion()))
                )
                .then(Commands.literal("StrengthPotion")
                        .executes(commandContext -> sendMessage(commandContext, strengthPotion()))
                )
                .then(Commands.literal("LeapingPotion")
                        .executes(commandContext -> sendMessage(commandContext, leapingPotion()))
                )
                .then(Commands.literal("WaterBreathingPotion")
                        .executes(commandContext -> sendMessage(commandContext, waterBreathingPotion()))
                )
                .then(Commands.literal("InvisibilityPotion")
                        .executes(commandContext -> sendMessage(commandContext, invisibilityPotion()))
                )
                .then(Commands.literal("SlowFallingPotion")
                        .executes(commandContext -> sendMessage(commandContext, slowFallingPotion()))
                )
                .then(Commands.literal("LuckPotion")
                        .executes(commandContext -> sendMessage(commandContext, luckPotion()))
                )
                .then(Commands.literal("PoisonPotion")
                        .executes(commandContext -> sendMessage(commandContext, poisonPotion()))
                )
                .then(Commands.literal("WeaknessPotion")
                        .executes(commandContext -> sendMessage(commandContext, weaknessPotion()))
                )
                .then(Commands.literal("SlownessPotion")
                        .executes(commandContext -> sendMessage(commandContext, slownessPotion()))
                )
                .then(Commands.literal("HarmingPotion")
                        .executes(commandContext -> sendMessage(commandContext, harmingPotion()))
                )
                .then(Commands.literal("DecayPotion")
                        .executes(commandContext -> sendMessage(commandContext, decayPotion()))
                )
                .then(Commands.literal("TurtleMasterPotion")
                        .executes(commandContext -> sendMessage(commandContext, turtleMasterPotion()))
                )
                .then(Commands.literal("help")
                        .executes(commandContext -> sendMessage(commandContext, helpCommand()))
                )
                .executes(commandContext -> sendMessage(commandContext, helpCommand()));  // blank: didn't match a literal or the custommessage argument

        dispatcher.register(potionCommand);
    }

    static int sendMessage(CommandContext<CommandSource> commandContext, String message) {
        StringTextComponent finalText = new StringTextComponent(message);

        Entity entity = commandContext.getSource().getEntity();
        if (entity != null) {
            commandContext.getSource().getServer().getPlayerList().func_232641_a_(finalText, ChatType.CHAT, entity.getUniqueID());
            //func_232641_a_ is sendMessage()
        } else {
            commandContext.getSource().getServer().getPlayerList().func_232641_a_(finalText, ChatType.SYSTEM, Util.field_240973_b_);
        }
        return 1;
    }

    public static String helpCommand() {
        return "    [HELP]\n" +
                "    - Usage: /potion <potionname>\n" +
                "    - Description: A command to help player brew and understand Potions more easily\n" +
                "    - Creator: Benji377\n" +
                "    - INFO:\n" +
                "       - The contribute is online on Github\n" +
                "       - Project is open.source --> everyone can contribute\n" +
                "       - For any issues, ask there\n" +
                "    - LINKS: \n" +
                "       - Github: https://github.com/Benji377 \n" +
                "       - Blog: https://www.internetking.ga/ \n" +
                "    - CREDITS:\n" +
                "       - Forge: Mod is based on the Forge API\n" +
                "       - Minecraft Wiki: For all the information about the potions\n" +
                "       - TheGreyGhost: Great Minecraft mod example on Github\n" +
                "       - YOU: For using this mod <3\n";
    }

    /* POTIONS TEMPLATE
    [POTION TITLE]
    - Level: 1, 2, 3 ...
    - Duration: (in minutes:seconds)
    - Ingredients: ingr1, ingr2, ingr3, ...
    - Description: (short)
    - How to brew: (accurate)
    - How to boost: (make throwable, increase level, increase duration,...)
    - Specialties: (optional)
     */

    public static String regenerationPotion() {
        return "\n    [POTION OF REGENERATION]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 0:45, 1:30, 0:22\n" +
                "    - Ingredients: Ghast Tear, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       Regeneration Potion increases your regeneration rate.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Ghast Tear + Awkward Potion --> Regeneration Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: \n" +
                "       - Can be found in Buried treasures (34.3% chance)\n";
    }
    public static String swiftnessPotion() {
        return "\n    [POTION OF SWIFTNESS]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 3:00, 8:00, 1:30\n" +
                "    - Ingredients: Sugar, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       Swiftness Potion will make the player move faster and jump further.\n" +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Sugar + Awkward Potion --> Swiftness Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String fireResistancePotion() {
        return "\n    [POTION OF FIRE RESISTANCE]\n" +
                "    - Level: 1\n" +
                "    - Duration: 3:00, 8:00\n" +
                "    - Ingredients: Magma Cream, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       Fire Resistance Potions will protect you from taking Fire and Lava damage.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Magma Cream + Awkward Potion --> Fire Resistance Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String healingPotion() {
        return "\n    [POTION OF HEALING]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: instantly\n" +
                "    - Ingredients: Glistering Melon, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Healing Potion will heal the player instantly.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Glistering Melon + Awkward Potion --> Healing Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String nightVisionPotion() {
        return "\n    [POTION OF NIGHT VISION]\n" +
                "    - Level: 1\n" +
                "    - Duration: 3:00, 8:00\n" +
                "    - Ingredients: Golden Carrot, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Night Vision Potion will give the player the Night Vision effect.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Golden Carrot + Awkward Potion --> Night vision Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String strengthPotion() {
        return "\n    [POTION OF STRENGTH]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 3:00, 8:00, 1:30\n" +
                "    - Ingredients: Blaze Powder, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Strength Potion will make the players attacks stronger\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Blaze Powder + Awkward Potion --> Strength Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String leapingPotion() {
        return "\n    [POTION OF LEAPING]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 3:00, 1:30\n" +
                "    - Ingredients: Rabbits Foot, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Leaping Potion will make the player jump higher\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Rabbits Foot + Awkward Potion --> Leaping Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String waterBreathingPotion() {
        return "\n    [POTION OF WATER BREATHING]\n" +
                "    - Level: 1\n" +
                "    - Duration: 3:00, 8:00\n" +
                "    - Ingredients: Pufferfish, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Water Breathing Potion will allow the player to breathe underwater.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Pufferfish + Awkward Potion --> Night vision Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: \n" +
                "       - Can be found in Buried Treasures (46.9% chance)\n";
    }
    public static String invisibilityPotion() {
        return "\n    [POTION OF INVISIBILITY]\n" +
                "    - Level: 1\n" +
                "    - Duration: 3:00, 8:00\n" +
                "    - Ingredients: Fermented Spider Eye, NIGHT VISION POTION\n" +
                "    - Description:\n" +
                "       When consumed Invisibility Potion will make the player invisible.\n " +
                "    - How to brew: \n" +
                "       Fermented Spider Eye + Night vision Potion --> Invisibility Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String slowFallingPotion() {
        return "\n    [POTION OF SLOW FALLING]\n" +
                "    - Level: 1\n" +
                "    - Duration: 1:30, 4:00\n" +
                "    - Ingredients: Phantom Membrane, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       Makes the player fall at a much slower rate, and not take any damage when hitting the ground.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Phantom Membrane + Awkward Potion --> Slow falling Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String luckPotion() {
        return "\n    [POTION OF LUCK]\n" +
                "    - Level: 1\n" +
                "    - Duration: 5:00\n" +
                "    - Description:\n" +
                "       Increases the luck attribute by 1 point.\n " +
                "    - Specialties: \n" +
                "       - Can only be obtained in creative mode\n" +
                "       - JE: Java Edition only\n";
    }

    public static String poisonPotion() {
        return "\n    [POTION OF POISON]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 0:45, 1:30, 0:22\n" +
                "    - Ingredients: Spider Eye, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Poison Potion will poison the player for 45 seconds.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Spider Eye + Awkward Potion --> Poison Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: \n" +
                "       - Doesn't kill the player\n";
    }
    public static String weaknessPotion() {
        return "\n    [POTION OF WEAKNESS]\n" +
                "    - Level: 1\n" +
                "    - Duration: 1:30, 4:00\n" +
                "    - Ingredients: Fermented Spider Eye, Water Bottle\n" +
                "    - Description:\n" +
                "       When consumed Weakness Potion will make the players attacks less powerful.\n " +
                "    - How to brew: \n" +
                "       Spider Eye + Water Bottle --> Weakness Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: \n" +
                "       - Water Bottle in recipe can be replaced with Thick Potion or Awkward Potion\n";
    }
    public static String slownessPotion() {
        return "\n    [POTION OF SLOWNESS]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 1:30, 4:00, 0:20\n" +
                "    - Ingredients: Fermented Spider Eye, FIRE RESISTANCE POTION\n" +
                "    - Description:\n" +
                "       When consumed Slowness Potion will make the player move slower and jump shorter.\n " +
                "    - How to brew: \n" +
                "       Fermented Spider Eye + Fire resistance Potion --> Slowness Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String harmingPotion() {
        return "\n    [POTION OF HARMING]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: instant\n" +
                "    - Ingredients: Fermented Spider Eye, POISON POTION\n" +
                "    - Description:\n" +
                "       When consumed Harming Potion will damage the player instantly.\n " +
                "    - How to brew: \n" +
                "       Fermented Spider Eye + Poison Potion --> Harming Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "       Potion + Fermented Spider Eye --> Inverse effect\n" +
                "    - Specialties: NONE\n";
    }
    public static String decayPotion() {
        return "\n    [POTION OF REGENERATION]\n" +
                "    - Level: 1\n" +
                "    - Duration: 0:40\n" +
                "    - Description:\n" +
                "       Potions of decay will give the player the Wither effect.\n " +
                "    - Specialties: \n" +
                "       - Not craftable\n" +
                "       - Bedrock edition only\n";
    }

    public static String turtleMasterPotion() {
        return "\n    [POTION OF TURTLE MASTER]\n" +
                "    - Level: 1, 2\n" +
                "    - Duration: 0:20, 0:40, 0:20\n" +
                "    - Ingredients: Turtle Shell, Nether Wart, Water Bottle\n" +
                "    - Description:\n" +
                "       When this potion is drank, it will give the player Slowness IV and Resistance III status effects.\n " +
                "    - How to brew: \n" +
                "       Nether Wart + Water Bottle --> Awkward Potion\n" +
                "       Turtle Shell + Awkward Potion --> Turtle Master Potion\n" +
                "    - How to boost:\n" +
                "       Potion + Glowstone --> level up\n" +
                "       Potion + Redstone --> Increase duration\n" +
                "       Potion + Gunpowder --> Make throwable\n" +
                "       Potion + Dragon's breath --> Lingering potion\n" +
                "    - Specialties: NONE\n";
    }
}
