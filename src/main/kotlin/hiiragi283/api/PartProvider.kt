package hiiragi283.api

import hiiragi283.api.part.HiiragiPart

interface PartProvider {

    fun asPart(): HiiragiPart = HiiragiPart.EMPTY

}