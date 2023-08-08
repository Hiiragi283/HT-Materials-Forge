package hiiragi283.api.shape

import hiiragi283.material.RagiMaterials

object ShapeRegistry {

    private val REGISTRY: LinkedHashMap<String, HiiragiShape> = linkedMapOf()

    @JvmStatic
    fun getShapes(): Collection<HiiragiShape> = REGISTRY.values

    @JvmStatic
    fun getShape(name: String) = REGISTRY.getOrDefault(name, HiiragiShape.EMPTY)

    @JvmStatic
    fun registerShape(shape: HiiragiShape) {

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

}