package MinecraftWikiMod;

import MinecraftWikiMod.potionmod.StartupCommon;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MinecraftModInit.MODID)
public class MinecraftModInit {

    public static final String MODID = "minecraftwikimod";

    public MinecraftModInit() {
        // Get an instance of the mod event bus
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Get an instance of the event registrar that is used to bind events to the mod event bus
        // this is a separate class to allow us to use `safeRunWhenOn` instead of the deprecated
        // `runWhenOn` method on the DistExecuter.
        final ClientSideOnlyModEventRegistrar clientSideOnlyModEventRegistrar = new ClientSideOnlyModEventRegistrar(modEventBus);

        // The event bus register method is used to specify classes used for receiving startup events:
        // The classes you register will be searched for methods which are interested in startup events
        //    (i.e. methods that are decorated with the @SubscribeEvent annotation)

        // Beware - there are two event busses: the MinecraftForge.EVENT_BUS, and your own ModEventBus.
        //  If you subscribe your event to the wrong bus, it will never get called.
        // likewise, beware of the difference between static and non-static methods, i.e.
        //  If you register a class, but the @SubscribeEvent is on a non-static method, it won't be called.  e.g.
        //  eventBus.register(MyClass.class);
        //  public class ServerLifecycleEvents {
        //    @SubscribeEvent
        //      public void onServerStartingEvent(FMLServerStartingEvent event) { // missing static! --> never gets called}
        //  }

        // Based on my testing: ModEventBus is used for setup events only, in the following order:
        // * RegistryEvent of all types
        // * ColorHandlerEvent for blocks & items
        // * ParticleFactoryRegisterEvent
        // * FMLCommonSetupEvent (multithreaded)
        // * TextureStitchEvent
        // * FMLClientSetupEvent or FMLDedicatedServerSetupEvent (multithreaded)
        // * ModelRegistryEvent
        // * Other ModLifecycleEvents such as InterModEnqueueEvent, InterModProcessEvent (multithreaded)
        // ModelBakeEvent

        // We need to split the registration of events into:
        // 1) "Common" events that are executed on a dedicated server and also on an integrated client + server installation
        // 2) "Client only" events that are not executed on a dedicated server.
        // If you aren't careful to split these into two parts, your mod will crash when installed on a dedicated server
        // It doesn't matter if your client-only code is never actually called; simply referencing the class is often enough to
        //   cause a crash.  I have also heard that the behaviour depends on the particular implementation of the Java Virtual
        //   Machine (for example Windows vs Linux), so you can't necessarily rely on testing to be sure it works.
        //   See the comments in DistExecutor class for more context.
        //  This is the reason that the ClientOnlyEvents are split into a completely-separate class.

        registerCommonEvents(modEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientSideOnlyModEventRegistrar::registerClientOnlyEvents);

    }
    /**
     * Register common events for both dedicated servers and clients. This method is safe to call directly.
     */
    public void registerCommonEvents(IEventBus eventBus) {
        eventBus.register(StartupCommon.class);
    }

}
