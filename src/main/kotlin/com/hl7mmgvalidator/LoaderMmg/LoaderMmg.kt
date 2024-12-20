package com.hl7mmgvalidator.loadermmg

import java.io.File

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Interface
interface LoaderMmg {

    // ********************************************************************
    // TODO: Implement the logic to read the MMGs based on the parameters 
    // see example such as here: 
    // https://github.com/CDCgov/data-exchange-hl7/blob/v0.0.24/local_libs/lib-dex-commons/src/main/kotlin/gov/cdc/dex/mmg/MmgUtil.kt#L54
    // ********************************************************************
    fun getMMGs(
        genVProfile: String,        // Generic Version Profile 
        conditionProfile: String,   // Condition Version Profile    
        eventCode: String,
        jurisdictionCode: String
    ): Array<MMG> 

}// .LoaderMmg

// Implementation read MMG from local file read
class LoaderMmgImpl : LoaderMmg {

    override fun getMMGs(       
        genVProfile: String,
        conditionProfile: String,
        eventCode: String,
        jurisdictionCode: String
        ): Array<MMG> {

        println("Looking for MMGs with the following parameters: genVProfile: $genVProfile, conditionProfile: $conditionProfile, eventCode: $eventCode, jurisdictionCode: $jurisdictionCode")
        // ********************************************************************
        // TODO: Implement the logic to return the needed MMGs based on the parameters 
        // see example such as here: 
        // https://github.com/CDCgov/data-exchange-hl7/blob/v0.0.24/local_libs/lib-dex-commons/src/main/kotlin/gov/cdc/dex/mmg/MmgUtil.kt#L54
        // ********************************************************************
        println("Loading GenV2 MMG available from local file...")

        // Read the resource file from the classpath
        val resourcePath = "mmgs/generic_version_2_0_1.json"

        val fileContent = this::class.java.classLoader.getResource(resourcePath)?.readText()
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")

        // Deserialize JSON to MMG object
        val mmg = Gson().fromJson(fileContent, MMG::class.java)
        // println("Deserialized MMG: $mmg")

        return arrayOf<MMG>(mmg)
    }// .getMMGs 

}// .LoaderMmgImpl 
