package hiiragi283.api.shape

import hiiragi283.material.RagiMaterials

object ShapeRegistry {

    private val REGISTRY: LinkedHashMap<String, HiiragiShape> = linkedMapOf()
    private var isLocked: Boolean = false

    @JvmStatic
    fun getShapes(): Collection<HiiragiShape> = REGISTRY.values

    @JvmStatic
    fun getShape(name: String) = REGISTRY.getOrDefault(name, HiiragiShape.EMPTY)

    @JvmStatic
    fun registerShape(shape: HiiragiShape) {

        //ロックされている場合はパス
        if (isLocked) {
            RagiMaterials.LOGGER.error("ShapeRegistry is already locked!")
            RagiMaterials.LOGGER.error("Shapes should be registered at \"ragi_materials\" entrypoint")
            return
        }

        //EMPTYを渡された場合はパス
        if (shape == HiiragiShape.EMPTY) return
        val name = shape.name

        //名前が空の場合はパス
        if (name.isEmpty()) {
            RagiMaterials.LOGGER.warn("The name of $shape is empty!")
            return
        }

        val resultName = REGISTRY[name]
        //同じ名前で登録されていた場合，登録せずに警告を表示する
        if (resultName !== null) {
            RagiMaterials.LOGGER.warn("The name of $shape was already registered by $resultName!")
            return
        }

        //重複しなかった場合のみ登録を行う
        REGISTRY[name] = shape
    }

    fun init() {
        REGISTRY.clear()
        registerShape(HiiragiShapes.DUST)
        registerShape(HiiragiShapes.DUST_TINY)
        registerShape(HiiragiShapes.GEAR)
        registerShape(HiiragiShapes.GEM)
        registerShape(HiiragiShapes.INGOT)
        registerShape(HiiragiShapes.NUGGET)
        registerShape(HiiragiShapes.PLATE)
        registerShape(HiiragiShapes.ROD)
    }

    fun lock() {
        isLocked = true
    }

}