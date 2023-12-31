package hiiragi283.api.material

import hiiragi283.material.RagiMaterials

object MaterialRegistry {

    private val REGISTRY: LinkedHashMap<String, HiiragiMaterial> = linkedMapOf()

    @JvmStatic
    fun getMaterials(): Collection<HiiragiMaterial> = REGISTRY.values

    @JvmStatic
    fun getMaterial(name: String) = REGISTRY.getOrDefault(name, HiiragiMaterial.EMPTY)

    @JvmStatic
    fun registerMaterial(material: HiiragiMaterial) {

        //EMPTYを渡された場合はパス
        if (material == HiiragiMaterial.EMPTY) {
            RagiMaterials.LOGGER.error("$material is empty!")
            return
        }

        val name = material.name
        //名前が空の場合はパス
        if (name.isEmpty()) {
            RagiMaterials.LOGGER.error("The name of $material is empty!")
            return
        }

        //同じ名前で登録されていた場合，上書きの警告を表示する
        if (getMaterial(material.name) !== HiiragiMaterial.EMPTY) {
            RagiMaterials.LOGGER.warn("$material has been registered!")
            return
        }

        REGISTRY[material.name] = material

    }

}