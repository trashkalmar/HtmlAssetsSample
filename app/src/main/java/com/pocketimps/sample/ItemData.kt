package com.pocketimps.sample

import java.io.Serializable

/**
 * Describes single item data: title in the list and URI of corresponding file in assets
 */
class ItemData(val title: String, val fileUri: String) : Serializable
