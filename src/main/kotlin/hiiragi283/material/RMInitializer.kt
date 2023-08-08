package hiiragi283.material

import hiiragi283.api.material.MaterialCommon
import hiiragi283.api.material.MaterialElements
import hiiragi283.api.shape.HiiragiShapes
import hiiragi283.api.shape.ShapeRegistry

object RMInitializer {

    fun initShapes() {
        ShapeRegistry.registerShape(HiiragiShapes.DUST)
        ShapeRegistry.registerShape(HiiragiShapes.DUST_TINY)
        ShapeRegistry.registerShape(HiiragiShapes.GEAR)
        ShapeRegistry.registerShape(HiiragiShapes.GEM)
        ShapeRegistry.registerShape(HiiragiShapes.INGOT)
        ShapeRegistry.registerShape(HiiragiShapes.NUGGET)
        ShapeRegistry.registerShape(HiiragiShapes.PLATE)
        ShapeRegistry.registerShape(HiiragiShapes.ROD)
        RagiMaterials.LOGGER.info("Shapes registered!")
    }

    fun initMaterials() {
        MaterialElements.register()
        RagiMaterials.LOGGER.info("Elemental Materials registered!")

        MaterialCommon.register()
        RagiMaterials.LOGGER.info("Common Materials registered!")

        //RMResourceHandler.load()
        RagiMaterials.LOGGER.info("Materials from data packs loaded!")
    }

    fun initResourcePack() {
        RMBlocks.initResourcePack()
        RMItems.initResourcePack()
    }

}